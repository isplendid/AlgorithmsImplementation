package com.xu.leetcode.desgin;

import com.xu.algs.basic.In;

import java.util.*;

/**
 * Created by sop on 2020/4/19.
 *
 *  环形缓冲器  功能设计
 * 你的实现应该支持如下操作：

 MyCircularQueue(k): 构造器，设置队列长度为 k 。
 Front: 从队首获取元素。如果队列为空，返回 -1 。
 Rear: 获取队尾元素。如果队列为空，返回 -1 。
 enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
 deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
 isEmpty(): 检查循环队列是否为空。
 isFull(): 检查循环队列是否已满。

 //线程不安全， 数组实现

 */
public class MyCircularQueue_Array_622 {

    private int[] queue;
    private int headIndex;
    private int count; //队列元素数量
    private int capacity; //数组容量


    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue_Array_622(int k) {
        this.queue = new int[k];
        this.capacity = k;
        this.headIndex = 0;
        this.count = 0;

    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(this.capacity == this.count){
            return false;
        }
        this.count ++;
        int tailIndex = (headIndex + count -1) % capacity;
        this.queue[tailIndex] = value;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
       if(this.count == 0){
           return false;
       }
       this.headIndex = (this.headIndex + 1) % this.capacity;
        this.count --;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (this.count == 0) {
            return -1;
        }
       return queue[headIndex];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(this.count==0){
            return -1;
        }
       return queue[(headIndex + count -1) % capacity ];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return this.count == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return this.capacity == this.count;
    }

    public static void main(String[] args) {
        /**
         * Your MyCircularQueue object will be instantiated and called as such:
         * MyCircularQueue obj = new MyCircularQueue(k);
         * boolean param_1 = obj.enQueue(value);
         * boolean param_2 = obj.deQueue();
         * int param_3 = obj.Front();
         * int param_4 = obj.Rear();
         * boolean param_5 = obj.isEmpty();
         * boolean param_6 = obj.isFull();
         */
    }

}
