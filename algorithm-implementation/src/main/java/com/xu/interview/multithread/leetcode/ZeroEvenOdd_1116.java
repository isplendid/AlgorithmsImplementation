package com.xu.interview.multithread.leetcode;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * Created by sop on 2020/6/28.
 */
public class ZeroEvenOdd_1116 {
    private int n;
    private Semaphore zero = new Semaphore(1);
    private Semaphore odd = new Semaphore(0);
    private Semaphore even = new Semaphore(0);


    public ZeroEvenOdd_1116(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
       for(int i=1; i<=n; i++){
           zero.acquire();
           printNumber.accept(i);
           if(i % 2 == 0){
               even.release();
           }else {
               odd.release();
           }
       }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for(int i=2; i<=n; i+=2){
            even.acquire();
            printNumber.accept(i);
            zero.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i=1; i<=n; i+=2){
            odd.acquire();
            printNumber.accept(i);
            zero.release();
        }
    }


    public static void main(String[] args) {
        ZeroEvenOdd_1116 zero = new ZeroEvenOdd_1116(2);
    }
}
