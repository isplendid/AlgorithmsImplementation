package turing;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.ReferenceCountUtil;
import it.unimi.dsi.fastutil.longs.Long2IntOpenHashMap;
import it.unimi.dsi.fastutil.longs.LongSet;

import java.io.*;
import java.util.Objects;

/**
 * @author xushichao
 * @date 2023/3/27 20:23
 * @desc
 *
 * 1) 把数据写入memTableBuilder， 再构造MemTable
 * 2)
 *
 */
public class MemTable {
    private static final int TABLE_VERSION_0 = 0;
    private static final int VERSION_0 = 0;
    private static final int DEFAULT_RETURN_VALUE = -1;


    private Long2IntOpenHashMap indexMap;
    private ByteBuf buffer;

    private final long tableId;   //groupId
    private final int date;      //version
    private final String tableInfo;   //groupName


    private MemTable(final long tableId, int date, String tableInfo, final Long2IntOpenHashMap indexMap, final ByteBuf buffer) {
        this.tableId = tableId;
        this.date = date;
        this.tableInfo = tableInfo;
        this.indexMap = indexMap;
        this.buffer = buffer;
    }


    public static MemTable readFrom(InputStream rawIn) throws IOException, ClassNotFoundException {
        Long2IntOpenHashMap indexMap;
        ByteBuf buffer;
        long tableId;
        int date;
        String tableInfo;

        try(ObjectInputStream in = new ObjectInputStream(rawIn)) {
            int version = in.readInt();
            assert  version == TABLE_VERSION_0;

            tableId = in.readLong();
            date = in. readInt();

            final int tableInfoLen = in.readInt();
            final byte[] tableInfoBytes = new byte[tableInfoLen];

            in.readFully(tableInfoBytes, 0, tableInfoLen);

            tableInfo = new String(tableInfoBytes);

            int tableSize = in.readInt();
            indexMap = (Long2IntOpenHashMap) in.readObject();
            assert tableSize == indexMap.size();

            int contentSize = in.readInt();
            buffer = Unpooled.directBuffer(contentSize);
            byte[] buf = new byte[1024];
            for(int i=0; i<contentSize; i += buf.length) {
                final int endIndex = Math.min(contentSize, i+buf.length) -i;
                in.readFully(buf, 0, endIndex); //读取到buf
                buffer.writeBytes(buf, 0, endIndex); //写到ButeBuf buffer
            }

        }

        return new MemTable(tableId, date, tableInfo, indexMap, buffer);
    }


    public void writeTo(OutputStream rawOut) throws IOException {

        try(ObjectOutputStream out = new ObjectOutputStream(rawOut)) {
            out.writeInt(TABLE_VERSION_0);
            out.writeLong(tableId);
            out.writeInt(date);

            byte[] bytesTableInfo = tableInfo.getBytes();
            out.writeInt(bytesTableInfo.length);
            out.write(bytesTableInfo);

            out.writeInt(indexMap.size());
            out.writeObject(indexMap);

            int contentSize = buffer.readableBytes();
            out.writeInt(contentSize);
            byte[] buf = new byte[1024];
            for (int i = 0; i < contentSize; i += buf.length) {
                final int endIndex = Math.min(contentSize, i+buf.length) - i;
                buffer.readBytes(buf, 0, endIndex);
                out.write(buf, 0, endIndex);
            }

            assert buffer.readableBytes() == 0;
            buffer.resetReaderIndex();

        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MemTable)) return false;
        MemTable memTable = (MemTable) o;
        return tableId == memTable.tableId &&
                date == memTable.date &&
                Objects.equals(indexMap, memTable.indexMap) &&
                Objects.equals(buffer, memTable.buffer) &&
                Objects.equals(tableInfo, memTable.tableInfo);
    }

    @Override
    public int hashCode() {
        return Long.valueOf(tableId).hashCode();
    }

    @Override
    public void finalize() {
        destroy();
    }

    public void destroy() {
        final ByteBuf thisBuffer = this.buffer;
        if(thisBuffer != null) {
            final int cnt = thisBuffer.refCnt();
            if(cnt > 0) {
                assert cnt == 1;
                this.buffer = null;
                ReferenceCountUtil.release(thisBuffer);
            }
        }
    }






    public static class MemTableBuilder {
         ByteBuf buffer;
         Long2IntOpenHashMap indexMap;
         final long tableId;
         final  int date;
         final String tableInfo;

         public MemTableBuilder(int expectedItemCont, int avgItemSize, long tableId, final int date, String tableInfo) {
              buffer = Unpooled.directBuffer(expectedItemCont * avgItemSize);
              indexMap = new Long2IntOpenHashMap(expectedItemCont);
              indexMap.defaultReturnValue(DEFAULT_RETURN_VALUE);
             this.tableInfo = tableInfo == null ? "" : tableInfo;
             this.tableId = tableId;
             this.date = date;

         }


         //应用，比如设置dimensionValue, messageContent,   过滤非数字类型的维度值
         public MemTableBuilder put(long key, byte[] value) {
             int index = buffer.writerIndex(); //返回当前写指针
             indexMap.put(key, index);     // <long， 写指针索引>
             buffer.writeShort(VERSION_0);
             buffer.writeShort(value.length);
             buffer.writeBytes(value);

             return this;
         }

         public MemTable build() {
             this.indexMap.trim();
             MemTable memTable = new MemTable(tableId, date, tableInfo, indexMap, buffer);
             this.indexMap = null;
             this.buffer = null;

             return memTable;
         }

    }




    public long getTableId() {
        return tableId;
    }

    public int getDate() {
        return date;
    }

    public String getTableInfo() {
        return tableInfo;
    }

    public int size() {
        return indexMap.size();
    }

    public long getMemoryCost() {
        return indexMap.size() * 16 + buffer.readableBytes();
    }

    public LongSet keySet() {
        return this.indexMap.keySet();
    }



}
