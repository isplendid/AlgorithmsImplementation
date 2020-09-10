package com.xu.interview.multithread.design.pro_consumer;

/**
 * Created by sop on 2020/08/2020/8/23 18:13
 *
 * @Description:
 */
public class Producer extends Thread {
    private MyBlockingQueue<String> queue;

    public Producer(MyBlockingQueue<String> queue) {
        this.queue = queue;
    }


    @Override
    public void run() {
        int num = 0;
        while (true) {
            String task = String.valueOf(num);
            try {
                queue.put(task);
                System.out.println("produce task: " + task);
                num++;
                Thread.sleep((int) (Math.random() * 100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
