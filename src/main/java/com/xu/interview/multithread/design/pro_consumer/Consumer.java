package com.xu.interview.multithread.design.pro_consumer;

/**
 * Created by sop on 2020/08/2020/8/23 18:16
 *
 * @Description:
 */
public class Consumer extends Thread{
    private MyBlockingQueue<String> queue;

    public Consumer(MyBlockingQueue queue){
        this.queue = queue;
    }

    public void run(){
        while (true){
            try {
                String task = queue.take();
                System.out.println("handle task :" + task);
                Thread.sleep((int) (Math.random() * 100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
