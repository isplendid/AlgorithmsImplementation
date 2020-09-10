package com.xu.interview.multithread.design.pro_consumer;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by sop on 2020/08/2020/8/23 18:05
 *
 * @Description:  生产者/消费者模式
 *
 * 只能有一个条件等待队列， java wait/notify机制的局限性
 */
public class MyBlockingQueue<E> {
   private Queue<E> queue = null;
   private int capacity;

    public MyBlockingQueue(int cap){
        this.capacity = cap;
        queue = new ArrayDeque<>(cap);
    }

    //给生产者用的，满了就wait
    public synchronized void put(E e) throws InterruptedException {
        while(queue.size() == this.capacity){
            wait();
        }
        queue.offer(e);
        notifyAll();
    }
    //给消费者用的，空了就wait
    public synchronized E take() throws InterruptedException {
        while(queue.isEmpty()){
            wait();
        }
        E e = queue.poll();
        notifyAll();
        return e;
    }
}
