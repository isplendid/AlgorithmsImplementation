package com.xu.leetcode.linkedlist;

/**
 * Created by sop on 2020/2/23.
 * 其中我们应该关心的主要有三点：

 返回值
 调用单元做了什么
 终止条件
 在本题中：
 返回值：交换完成的子链表
 调用单元：设需要交换的两个点为 head 和 next，head 连接后面交换完成的子链表，next 连接 head，完成交换
 终止条件：head 为空指针或者 next 为空指针，也就是当前无节点或者只有一个节点，无法进行交换

 */
public class SwapPairs_24 {

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }
}
