package com.xu.leetcode.desgin.lfu;

import com.xu.algs.basic.In;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author xushichao
 * @date 2022/11/30 22:07
 * @desc
 */
public class LFUCache {

    private class Node{
        int key, val, freq;
        public Node(int key, int val, int freq){
            this.key = key;
            this.val = val;
            this.freq = freq;
        }
    }
    private Map<Integer, Node> cache;

    //LinkedList FIFO
    //[1, [2,3]]
    // <频率， 节点列表>
    private Map<Integer, LinkedList<Node>>  freqListsMap;

    private int minFreq = 0;

    int capacity;

    public LFUCache(int capacity) {
        cache = new HashMap<>();
        freqListsMap = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if(capacity == 0) {
            return -1;
        }
        if(!cache.containsKey(key)) {
            return -1;
        }
        Node node = cache.get(key);
        incrFreq(key);
        return node.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        Node curNode;
        if(cache.containsKey(key)) { //包含key,原地更新，freq自增
            curNode = cache.get(key);
            curNode.val = value;
            incrFreq(key);
        } else {
            if(cache.size() == capacity){ //满了则移除
                removeLeastFreqNode();
            }
            insertNewNode(key,value); //插入新节点
        }
    }

    private void insertNewNode(int key, int value) {
        Node node = new Node(key, value, 1);
        cache.put(key, node);
        minFreq=1;
        LinkedList<Node> list = freqListsMap.getOrDefault(1, new LinkedList<>());
        list.addLast(node);
        freqListsMap.put(1, list);
    }

    private void removeLeastFreqNode() {
        LinkedList<Node> leastFreqList = freqListsMap.get(minFreq);
        Node removeNode = leastFreqList.removeFirst();
        cache.remove(removeNode.key);
        if(leastFreqList.isEmpty()) {
            freqListsMap.remove(removeNode.freq);
        }
    }

    void incrFreq(int key) {
        Node curNode = cache.get(key);
        int curFreq = curNode.freq++;
        LinkedList<Node> curFreqList = freqListsMap.get(curFreq);
        curFreqList.remove(curNode);

        if(curFreqList.isEmpty()) {
            freqListsMap.remove(curFreq); //todo 容易错，移除curNode
            if(curFreq == minFreq) {
                ++minFreq;
            }
        }
        LinkedList<Node> newFreqList = freqListsMap.getOrDefault(curNode.freq, new LinkedList<>());
        newFreqList.add(curNode);
        freqListsMap.put(curNode.freq, newFreqList);
    }


    public static void main1(String[] args) {
      LFUCache lfu = new LFUCache(2);
        lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
        lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
        lfu.get(1);      // 返回 1
        // cache=[1,2], cnt(2)=1, cnt(1)=2
        lfu.put(3, 3);   // 去除键 2 ，因为 cnt(2)=1 ，使用计数最小
        // cache=[3,1], cnt(3)=1, cnt(1)=2
        lfu.get(2);      // 返回 -1（未找到）
        lfu.get(3);      // 返回 3
        // cache=[3,1], cnt(3)=2, cnt(1)=2
        lfu.put(4, 4);   // 去除键 1 ，1 和 3 的 cnt 相同，但 1 最久未使用
        // cache=[4,3], cnt(4)=1, cnt(3)=2
        lfu.get(1);      // 返回 -1（未找到）
        lfu.get(3);      // 返回 3
        // cache=[3,4], cnt(4)=1, cnt(3)=3
        lfu.get(4);      // 返回 4
    }

    public static void main(String[] args) {
        LFUCache lfu = new LFUCache(3);
        lfu.put(2, 2);   // cache=[1,_], cnt(1)=1
        lfu.put(1, 1);   // cache=[2,1], cnt(2)=1, cnt(1)=1
        lfu.get(2);
        lfu.get(1);
        lfu.get(2);

       lfu.put(3,3);
       lfu.put(4,4);

       lfu.get(3);
       lfu.get(2);
       lfu.get(1);
       lfu.get(4);
    }
}
