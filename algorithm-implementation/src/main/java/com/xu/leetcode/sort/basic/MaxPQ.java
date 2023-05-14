package com.xu.leetcode.sort.basic;

/**
 * @author xushichao
 * @date 2023/5/14 19:59
 * @desc
 */
public interface MaxPQ<Key extends Comparable<Key>> {

    /***
     * 往堆中插入一个元素
     * 1） 往数组最后加入新元素， 然后heapify (堆化）
     * @param v
     */
     void insert(Key v);


     Key max();

     Key delMax();

     boolean isEmpty();

     int size();

}
