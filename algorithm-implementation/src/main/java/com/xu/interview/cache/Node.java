package com.xu.interview.cache;

/**
 * Created by sop on 2019/3/9.
 */

/***
 * 双向链表节点
 * @param <V>
 */
public class Node<V> {
    public V value;
    public Node<V> last;
    public Node<V> next;
    public Node(V value) {
        this.value = value;
    }
}
