package com.xu.leetcode.linkedlist;

/**
 * Created by sop on 2020/7/19.
 */
public class ReverseList {

    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode next = null;
        while(head != null){
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
