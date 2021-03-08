package com.xu.basic.datatype;

/**
 * @author xushichao
 * @date 2021/3/3 11:20 AM
 * @desc
 */
public class StringIntegerCacheMain {
    public static void main(String[] args) {
        //创建方式并不会使用到IntegerCache
        Integer i1 = new Integer(123);
        Integer i2 = new Integer(123);

        //可以利用IntegerCache缓存，返回共享的对象，以达到节省内存的目的; 本质上自动装箱使用的 Integer.valueOf()
        Integer i11 = 128;
        Integer i12 = 128;

        //false
        System.out.println(i1 == i2);
        //false
        System.out.println(i11 == i12);
    }
}
