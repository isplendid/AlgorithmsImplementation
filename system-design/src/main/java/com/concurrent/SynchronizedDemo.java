package com.concurrent;

/**
 * @author xushichao
 * @date 2023/3/27 14:22
 * @desc
 * 多个线程之间访问资源的同步性，可以保证被它修饰的方法或者代码块在任意时刻只能有一个线程执行。
 */
public class SynchronizedDemo {

    private Object object = new Object();

    private void waitM() throws InterruptedException {
        System.out.println("wait");
        object.wait();
    }

    private void notifyM() {
        System.out.println("notify");
        object.notify();
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedDemo demo = new SynchronizedDemo();
        demo.waitM();
        demo.notifyM();
    }

}

