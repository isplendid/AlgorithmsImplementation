package com.xu.interview.multithread.leetcode;

import java.util.concurrent.Semaphore;

/**
 * Created by sop on 2020/5/17.
 */
public class TurnPrint_Ali {

//    public void foo(Runnable printFoo) throws InterruptedException {
//
//        for (int i = 0; i < n; i++) {
//            foo.acquire();
//            // printFoo.run() outputs "foo". Do not change or remove this line.
//            printFoo.run();
//            bar.release();
//        }
//    }
//
//    public void bar(Runnable printBar) throws InterruptedException {
//
//        for (int i = 0; i < n; i++) {
//            bar.acquire();
//            // printBar.run() outputs "bar". Do not change or remove this line.
//            printBar.run();
//            foo.release();
//        }
//    }

    public static void main(String[] args) throws InterruptedException {
        FooBar_Byturn_1115 fooBar = new FooBar_Byturn_1115(3);

         Semaphore odd = new Semaphore(1);
         Semaphore even = new Semaphore(0);
         String str = "20200517"; //交替打印字符






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
