package com.xu.leetcode.desgin;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by sop on 2020/5/10.
 * 问题描述见： MyCircularQueue_Array_622
 * 与固定大小的数组相比，单链表不会为未使用的容量预分配内存，因此它的内存效率更高
 */
public class MyCircularQueue_List_622 {
    private Node head, tail;
    private int count;  // 队列元素数量
    private int capacity; //队列容量

    // Additional variable to secure the access of our queue
    private Lock queueLock = new ReentrantLock();

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue_List_622(int k) {
        this.capacity = k;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        // ensure the exclusive access for the following block.
        queueLock.lock();
        try {
            if(this.count == this.capacity) {
                return false;
            }
            Node newNode = new Node(value);
            if(this.count == 0){
                head=tail=newNode;
            }else {
                this.tail.next = newNode;
                tail = newNode;
            }
            this.count ++;
        } finally {
            queueLock.unlock();
        }
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        queueLock.lock();
        try {
            if(this.count == 0){
                return false;
            }
            this.head = this.head.next;
            this.count --;
        } finally {
            queueLock.unlock();
        }
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
       if(this.count == 0){
           return -1;
       }
        return head.value;
    }

    /** Get the last item from the queue. */
    public int Rear() {
       if(this.count == 0){
           return -1;
       }
        return tail.value;
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
       return this.count == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
       return this.count == this.capacity;
    }

}
