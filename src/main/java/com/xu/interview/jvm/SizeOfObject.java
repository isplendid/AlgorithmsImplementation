package com.xu.interview.jvm;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sop on 2020/4/11.
 */
public class SizeOfObject {
    private  static  final  ReferenceQueue<Integer> QUEUE = new ReferenceQueue<>();
    private static  final List<Object> LIST = new ArrayList<>();

    public static void main(String[] args) {
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        PhantomReference<Integer> phantomReference = new PhantomReference<>(new Integer(1), QUEUE);
    }

}
