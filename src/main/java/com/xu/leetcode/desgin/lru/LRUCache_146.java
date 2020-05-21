package com.xu.leetcode.desgin.lru;

import java.util.HashMap;

/**
 * Created by sop on 2020/4/25.
 * https://leetcode-cn.com/problems/lru-cache/
 *
 */
public class LRUCache_146 {

    // key -> Node(key, val)
    private HashMap<Integer, Node> map;
    // Node(k1, v1) <-> Node(k2, v2)..
    private DoubleList cache;
    //最大容量
    private int cap;

    public LRUCache_146(int capacity) {
       this.cap = capacity;
        map = new HashMap<Integer, Node>();
        cache = new DoubleList();
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        int val = map.get(key).val;
        put(key,val);
        return val;
    }

    public void put(int key, int value) {
        //先把新节点x做出来
        Node x = new Node(key, value);

        if(map.containsKey(key)){
            //删除旧的节点，新的插入到头部
            cache.remove(map.get(key));
            cache.addFirst(x);
            //更新map中对应的数据
            map.put(key,x);

        } else {
            if(cap == cache.size()){
                //删除链表最后一个元素
                Node last = cache.removeLast();
                map.remove(last.key);
            }
            // 直接添加到头部
            cache.addFirst(x);
            map.put(key,x);
        }
    }
}
