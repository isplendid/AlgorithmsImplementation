package com.xu.leetcode.desgin.lru;

/**
 * Created by sop on 2020/4/25.
 */
public class DoubleList {
    private Node head, tail; // 头尾虚节点
    private int size;

    public DoubleList(){ //初始化双向链表头尾节点
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    // 在链表头部添加节点 x，时间 O(1)
    public void addFirst(Node x){
        x.next = head.next;
        head.next.prev = x;
        head.next = x;
        x.prev = head;
        size++;
    }

    // 删除链表中的 x 节点（x 一定存在）
    // 由于是双链表且给的是目标 Node 节点，时间 O(1)
    public void remove(Node x){
       x.prev.next = x.next;
        x.next.prev = x.prev;
        size--;
    }

    // 删除链表中最后一个节点，并返回该节点，时间 O(1),  最久不使用的
    public Node removeLast(){
        if(tail.prev == head){
            return null;
        }
        Node last = tail.prev;
        remove(last);
        return last;
    }

    // 返回链表长度，时间 O(1)
    public int size(){
       return size;
    }
}
