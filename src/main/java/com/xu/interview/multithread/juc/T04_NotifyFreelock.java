package com.xu.interview.multithread.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by sop on 2020/5/17.
 */
public class T04_NotifyFreelock {
    volatile List lists = new ArrayList<>();
    public void add(Object o){
        lists.add(o);
    }
    public int size(){
        return lists.size();
    }

    public static void main(String[] args) {
        T04_NotifyFreelock c = new T04_NotifyFreelock();
        final Object lock = new Object();
        new Thread(() -> {
            synchronized(lock) {
                System.out.println("t2 start!");
                if(c.size() != 5) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("t2 over");
                //通知t1继续执行
                lock.notify();
            }

        }, "t2").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        new Thread(() -> {
            System.out.println("t1 start1");
            synchronized(lock) {
                for(int i=1; i<=10; i++) {
                    c.add(new Object());
                    System.out.println("add " + i);

                    if(c.size() == 5) {
                        lock.notify();
                        //释放锁，让t2得以执行
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "t1").start();



    }
}
