package com.concurrent;

/**
 * @author xushichao
 * @date 2023/3/28 21:04
 * @desc
 * synchronized 不可中断锁
 * Lock可中断
 *  不可中断的意思是等待获取锁的时候不可中断，拿到锁之后可中断，没获取到锁的情况下，中断操作一直不会生效。
 */
public class Uninterruptible {
    private static final Object o1 = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            System.out.println("t1 enter");
            synchronized (o1) {
                try {
                    System.out.println("start lock t1");
                    Thread.sleep(15000);
                    System.out.println("end lock t1");
                } catch (InterruptedException e) {
                    System.out.println("t1 interruptedException");
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("t2 enter");
            synchronized (o1) {
                try {
                    System.out.println("start lock t2");
                    Thread.sleep(1000);
                    System.out.println("end lock t2");
                } catch (InterruptedException e) {
                    System.out.println("t2 interruptedException");
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();

        // 主线程休眠一下，让t1,t2线程百分百已经启动，避免线程交替导致测试结果混淆
        Thread.sleep(1000);
        // 中断t2线程的执行
        thread2.interrupt();
        System.out.println("t2 interrupt...");


        /***
         * t2 interruptedException
         * java.lang.InterruptedException: sleep interrupted
         * 结果正好印证了Synchronized不可中断的说法：只有获取到锁之后才能中断，等待锁时不可中断。
         */
    }
}
