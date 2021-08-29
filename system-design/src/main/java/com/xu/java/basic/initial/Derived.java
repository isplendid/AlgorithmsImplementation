package com.xu.java.basic.initial;

/**
 * @author xushichao
 * @date 2021/7/4 3:05 PM
 * @desc
 * 父类静态变量
 *
 * 父类静态代码块
 *
 * 子类静态变量
 *
 * 子类静态代码块
 *
 * 父类非静态变量
 *
 * 父类非静态代码块
 *
 * 父类构造函数
 *
 * 子类非静态变量
 *
 * 子类非静态代码块
 *
 * 子类构造函数
 *
 */
public class Derived extends Base {
    public Derived() {
        System.out.println("子类构造器");
    }

    String b = "子类非静态变量";

    {
        System.out.println(b);
        System.out.println("子类非静态代码块");
    }

    static String a = "子类静态变量";

    static {
        System.out.println(a);
        System.out.println("子类静态块");
    }

    public static void A() {
        System.out.println("子类普通静态方法");
    }

    public static void main(String[] args) {
        //Base.A();
       Derived.A();
//        new Derived();
    }
}
