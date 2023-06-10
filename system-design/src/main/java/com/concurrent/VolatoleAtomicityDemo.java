package com.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xushichao
 * @date 2023/3/27 11:07
 * @desc
 * volatile 关键字能保证变量的可见性，但不能保证对变量的操作是原子性的。
 *
 * 解决方式：
 * 1）synchronized void increase()
 * 2）public AtomicInteger inc = new AtomicInteger();
 *
 * public void increase() {
 *     inc.getAndIncrement();
 * }
 *
 *
 * 3）
 * Lock lock = new ReentrantLock();
 * public void increase() {
 *     lock.lock();
 *     try {
 *         inc++;
 *     } finally {
 *         lock.unlock();
 *     }
 * }

 * 著作权归所有
 * 原文链接：https://javaguide.cn/java/concurrent/java-concurrent-questions-02.html
 */
public class VolatoleAtomicityDemo {
    public volatile static int inc = 0;

    public  void increase() {
        inc++;
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        VolatoleAtomicityDemo volatoleAtomicityDemo = new VolatoleAtomicityDemo();
        for (int i = 0; i < 5; i++) {
            threadPool.execute(() -> {
                for (int j = 0; j < 10000; j++) {
                    volatoleAtomicityDemo.increase();
                }
            });
        }
        // 等待1.5秒，保证上面程序执行完成
        Thread.sleep(1500);
        System.out.println(inc);
        threadPool.shutdown();


    }

}
