package xu.test;

import learnProto.selfTest.MyTest;

public class DemoTest {

    public static void main(String[] args) {
        MyTest.Data.Builder dataBuilder = MyTest.Data.newBuilder();
//        dataBuilder.setUint32(121);
//        dataBuilder.setInt32(121);
//        dataBuilder.setUint64(123);
//        dataBuilder.setInt32(1);

        int timestamp = (int) System.currentTimeMillis() / 1000;
        System.out.println("timestamp: "+ timestamp);
        long time2 = System.currentTimeMillis() / 1000;
        System.out.println("time2: " + time2);
        int val = 1703835156;
        System.out.println(val);

        dataBuilder.setInt64(val);
//        dataBuilder.setInt32(timestamp);

        byte[] bytes = dataBuilder.build().toByteArray();

        System.out.println("bytes length: " + bytes.length);




    }

}
