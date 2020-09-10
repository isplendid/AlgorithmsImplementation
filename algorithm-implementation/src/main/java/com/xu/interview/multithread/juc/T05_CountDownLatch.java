package com.xu.interview.multithread.juc;

import com.mashibing.juc.c_001.T;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by sop on 2020/5/17.
 */
public class T05_CountDownLatch {
    volatile List lists = new ArrayList<>();
    public void add(Object o){
        lists.add(o);
    }
    public int size(){
        return lists.size();
    }

    public static void main(String[] args) {
        T05_CountDownLatch c = new T05_CountDownLatch();
        CountDownLatch latch = new CountDownLatch(1);

        new Thread(() -> {
            System.out.println("t2 start!");
            if (c.size() != 5) {
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t2 over! ");
        }, "t2").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        new Thread(() -> {
            System.out.println("t1 start!");
            for (int i = 1; i < 10; i++) {
                c.add(new Object());
                System.out.println("add " + i);

                if (c.size() == 5) {
                  //暂停t1线程
                    latch.countDown();

                    try {
                        latch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


//				try {
//					TimeUnit.SECONDS.sleep(1);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
            }

        }, "t1").start();
    }
}
