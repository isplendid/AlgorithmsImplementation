package com.xu.interview.multithread.juc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sop on 2020/5/16.
 */
public class T02_Taobao_NotifyWait {

    volatile List lists = new ArrayList<>();
    public void add(Object o){
        lists.add(o);
    }
    public int size(){
        return lists.size();
    }

    public static void main(String[] args) {

        T02_Taobao_NotifyWait c = new T02_Taobao_NotifyWait();
        final Object lock = new Object();
        //需要下启动t2再启动t1
        new Thread(() -> {
            synchronized (lock){
                System.out.println("t2 start!");
                if(c.size()!=5){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("t2 over!");
            }
            //通知t1继续执行
            //lock.notify();
        });

    }
}
