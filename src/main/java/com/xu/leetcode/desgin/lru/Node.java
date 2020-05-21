package com.xu.leetcode.desgin.lru;

/**
 * Created by sop on 2020/4/25.
 */
public class Node {
    public int key, val;
    public Node next, prev;
    public Node(int k, int v) {
        this.key = k;
        this.val = v;
    }
}
