package com.xu.interview.multithread.leetcode;

/**
 * Created by sop on 2020/5/17.
 *
 * 信号量控制线程交替打印 foobar foolbar
 *
 * 交替打印FooBar
 * 两个不同的线程将会共用一个 FooBar 实例。其中一个线程将会调用 foo() 方法，
 * 另一个线程将会调用 bar() 方法。
 *
 * 输入: n = 2
 输出: "foobarfoobar"
 解释: "foobar" 将被输出两次。
 */

import java.util.concurrent.Semaphore;

public class FooBar_Byturn_1115 {
    private int n;
    private Semaphore foo = new Semaphore(1);
    private Semaphore bar = new Semaphore(0);

    public FooBar_Byturn_1115(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            foo.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            bar.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            bar.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            foo.release();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        FooBar_Byturn_1115 fooBar = new FooBar_Byturn_1115(3);


        Thread t1 = new Thread(() -> {
            try {
                fooBar.foo(() -> {
                    System.out.print("foo");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                fooBar.bar(() -> {
                    System.out.print("bar");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t2.start();
        t1.start();

    }
}
