package com.xu.interview.multithread.design.pro_consumer;

/**
 * Created by sop on 2020/08/2020/8/23 18:18
 *
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        MyBlockingQueue<String> queue = new MyBlockingQueue<>(10);
        new Producer(queue).start();
        new Consumer(queue).start();

    }
}
