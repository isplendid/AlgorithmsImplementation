package com.xu.interview.multithread.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * Created by sop on 2020/5/16.
 */
public class TestLockSupport {
    public static void main(String[] args) {
        Thread t = new Thread( () -> {
           for(int i=0; i<10; i++){
               System.out.println(i);
               if(i==5) {
                   LockSupport.park();
               }
               if(i==8){
                   LockSupport.park();
               }

               try {
                   TimeUnit.SECONDS.sleep(1);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        });
        t.start();

        LockSupport.unpark(t);
        LockSupport.unpark(t);
    }
}
