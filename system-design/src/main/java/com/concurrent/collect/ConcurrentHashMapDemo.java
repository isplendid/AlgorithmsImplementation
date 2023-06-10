package com.concurrent.collect;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xushichao
 * @date 2023/4/5 21:41
 * @desc
 */
public class ConcurrentHashMapDemo {

    public static void main(String[] args) {
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
        map.put(11,"xsc");

        map.get(11);

    }
}
