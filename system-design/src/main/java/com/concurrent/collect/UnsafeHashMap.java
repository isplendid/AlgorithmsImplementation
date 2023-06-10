package com.concurrent.collect;

import com.sun.jdi.request.ThreadDeathRequest;
import it.unimi.dsi.fastutil.Hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author xushichao
 * @date 2023/4/2 13:34
 * @desc
 */
public class UnsafeHashMap {

//    public static void unsafeConcurrentUpdate() {
//        final Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < 1000; i++) {
//            Thread t = new Thread() {
//                Random rnd = new Random();
//
//                @Override
//                public void run() {
//                    for (int j = 0; j < 1000; j++) {
//                        map.put(rnd.nextInt(), 1);
//                    }
//                }
//            };
//            t.start();
//        }
//
//    }

    public static void main(String[] args) {
    //    unsafeConcurrentUpdate();
    }
}
