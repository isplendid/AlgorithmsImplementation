package com.xu.java.basic.initial;

/**
 * @author xushichao
 * @date 2021/7/4 3:05 PM
 * @desc
 */
public class Base {
    public Base() {
        System.out.println("父类构造方法");
    }

    String b = "父类非静态变量";

    {
        System.out.println(b);
        System.out.println("父类非静态代码块");
    }

    static String a = "父类静态变量";

    static {
        System.out.println(a);
        System.out.println("父类静态代码块");
    }

    public static void A() {
        System.out.println("父类普通静态方法");
    }

}
