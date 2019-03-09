package com.xu.interview.cache;

/**
 * Created by sop on 2019/3/9.
 */

/***
 * 根据双向链表节点生成 双向链表结构 NodeDoubleLinkedList, 优先级最高的是head(头)，优先级最低的是tail(尾)
 * 1）当加入一个新节点时，放入尾部，addNode(Node newNode)
 * 2) 对结构中的任意节点，都可以放入尾部，moveNodeToTail(Node node)
 * 3) 移除head节点，并返回这个节点，然后将head节点 设置成老的head节点的 下一个
 *
 */

public class NodeDoubleLinkedList<V> {
    private Node<V> head;
    private Node<V> tail;

    public NodeDoubleLinkedList() {
        this.head = null;
        this.tail = null;
    }
    public void addNode(Node<V> newNode){
        if(newNode == null) return;
        if(this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        }else{
            this.tail.next = newNode;
            newNode.last = this.tail;
            this.tail = newNode;
        }
    }

    public void moveNodeToTail(Node<V> node) {
        if(this.tail == node) return;
        if(this.head == node) {
            this.head = node.next;
            this.head.last = null;
        }else{
            node.last.next = node.next;
            node.next.last = node.last;
        }
        node.last = this.tail;
        this.tail.next = node;
        node.next = null;
        this.tail = node;
    }

    public Node removeHead(){
        if(this.head == null) return null;
        Node<V> res = this.head;
        if(this.head == this.tail){
            this.head = null;
            this.tail = null;
        }{
            this.head = res.next;
            res.next = null;
            this.head.last = null;
        }
        return res;
    }

}
