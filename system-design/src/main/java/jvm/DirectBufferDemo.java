package jvm;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import javax.management.*;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;
import java.lang.management.MemoryUsage;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author xushichao
 * @date 2023/4/27 17:32
 * @desc
 */
public class DirectBufferDemo {



    public static void main(String[] args) throws Exception {



        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer() ;
        ObjectName objectName = new ObjectName("java.nio:type=BufferPool,name=direct" ) ;
        MBeanInfo info = mbs.getMBeanInfo(objectName) ;
        for(MBeanAttributeInfo i : info.getAttributes()) {
            System.out .println(i.getName() + ":" + mbs.getAttribute(objectName , i.getName()));
        }
    }

    public void testDirectBuf() throws Exception {

//        final File outFile = new File(TempFiles.getTempDir() + "/memtable.data");
//
//        ByteBuffer buffer = ByteBuffer.allocateDirect(10000);
//        Random random = new Random();
//        byte[] data = new byte[random.nextInt(300) + 950];
//        random.nextBytes(data);
//

        ByteBuffer demoDirectByteBuffer = ByteBuffer.allocateDirect(1000);//1
        //put to buffer 5 bytes utf-8 编码
        demoDirectByteBuffer.put("hello,xushichao,hallaaaa".getBytes());
        // jdk8 metaspace 使用内存
        final long m_usedMetaSpace;
        // jdk8 metaspace 最大使用内存
        final long m_maxMetaSpace;

        final MemoryPoolMXBean metaSpaceMemoryPool = getMetaspaceMemoryPool();
        if (metaSpaceMemoryPool != null) {
            final MemoryUsage usage = metaSpaceMemoryPool.getUsage();
            m_usedMetaSpace = usage.getUsed();
            m_maxMetaSpace = usage.getMax();
        } else {
            m_usedMetaSpace = 0;
            m_maxMetaSpace = 0;
        }

        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer() ;
        ObjectName objectName = new ObjectName("java.nio:type=BufferPool,name=direct" ) ;
        MBeanInfo info = mbs.getMBeanInfo(objectName) ;
        for(MBeanAttributeInfo i : info.getAttributes()) {
            System.out .println(i.getName() + ":" + mbs.getAttribute(objectName , i.getName()));
        }

        ByteBuf buf = Unpooled.directBuffer(500);
        stats();


    }

    private void stats() {
        try {
            Class c = Class.forName("io.netty.util.internal.PlatformDependent");

            Field field1 = c.getDeclaredField("MAX_DIRECT_MEMORY");
            field1.setAccessible(true);
            Field field2 = c.getDeclaredField("DIRECT_MEMORY_COUNTER");
            field2.setAccessible(true);
            synchronized (c) {
                Long max =  (Long) field1.get(null);
                AtomicLong reserve = (AtomicLong) field2.get(null);
                System.out.println(max + " 总量，使用量：" + reserve.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private MemoryPoolMXBean getMetaspaceMemoryPool() {
        for (final MemoryPoolMXBean memoryPool : ManagementFactory.getMemoryPoolMXBeans()) {
            if (memoryPool.getName().endsWith("Metaspace")) {
                return memoryPool;
            }
        }
        return null;
    }

}
