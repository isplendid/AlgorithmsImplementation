package com.xu.interview.cache;

/**
 * Created by sop on 2019/3/9.
 */

import java.util.HashMap;

/***
 * LRU缓存, 由双端队列 + 哈希表结合的方式实现
 *
 * "经常访问度"
 * 加入新纪录， 加到NodeDoubleLinkedList尾部; 一旦获得（get）或者 设置（set)一个记录的key, 将这个key 对应的Node 调整到 NodeDoubleLinkedList尾部
 * 一旦 cache满了，移除head。
 * 为了能让每一个key 都能找到在 NodeDoubleLinkedList 所对应的的节点，两个map: key->Node,  node -> key
 */
public class LRUCache<K,V> {
    private HashMap<K, Node<V>> keyNodeMap;
    private HashMap<Node<V>, K> nodeKeyMap;
    private NodeDoubleLinkedList<V> nodeList;
    private int capacity;

    public LRUCache(int capacity) {
        if(capacity < 1){
            throw new RuntimeException("should be more than 0.");
        }
        this.capacity = capacity;
        this.keyNodeMap = new HashMap<K, Node<V>>();
        this.nodeKeyMap = new HashMap<Node<V>, K>();
        this.nodeList = new NodeDoubleLinkedList<V>();
        this.capacity = capacity;
    }

    public V get(K key){
        if(this.keyNodeMap.containsKey(key)){
            Node<V> res = this.keyNodeMap.get(key);
            this.nodeList.moveNodeToTail(res);
            return res.value;
        }
        return null;
    }


    public void set(K key, V value){
        if(this.keyNodeMap.containsKey(key)){
            Node<V> node  = this.keyNodeMap.get(key);
            node.value = value;
            this.nodeList.moveNodeToTail(node);
        }else{
            Node<V> newNode = new Node<V>(value);
            this.keyNodeMap.put(key, newNode);
            this.nodeKeyMap.put(newNode, key);
            this.nodeList.addNode(newNode);
            if(this.keyNodeMap.size() == this.capacity + 1){
                this.removeMostUnusedCache();
            }
        }
    }

    private void removeMostUnusedCache(){
        Node<V> removeNode = this.nodeList.removeHead();
        K removeKey = this.nodeKeyMap.get(removeNode);
        this.nodeKeyMap.remove(removeNode);
        this.keyNodeMap.remove(removeKey);
    }
}
