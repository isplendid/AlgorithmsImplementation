package com.xu.interview.multithread.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by sop on 2020/5/16.
 */
public class T02_Taobao {
   volatile List lists = new ArrayList<>();
    public void add(Object o){
        lists.add(o);
    }
    public int size(){
        return lists.size();
    }

    public static void main(String[] args) {

        T02_Taobao c = new T02_Taobao();
        new Thread(() -> {
            for(int i=0; i<10; i++){
                c.add(new Object());
                System.out.println("add "+i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t1").start();


        new Thread(() -> {
            while (true){
                if(c.size() == 5){
                    break;
                }
            }

            System.out.println("t2 over!");
        },"t2").start();

    }

}
