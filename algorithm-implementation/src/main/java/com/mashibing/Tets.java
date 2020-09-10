package com.mashibing;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Tets {
    public static void main(String[] args) {
        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put("1", "msb");
        ReentrantLock lock = new ReentrantLock();
        CountDownLatch latch = new CountDownLatch(1);
        Object o = new Object();
    }
}
