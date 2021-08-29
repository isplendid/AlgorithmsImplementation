package com.xu.leetcode.linkedlist;

/**
 * Created by sop on 2020/7/19.
 */
public class ReverseList {

    /***
     * 迭代法 反转单链表
     * @param head
     * @return  返回新的链表
     */
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    /**
     * 反转链表，头结点不变
     * @param head
     */
    public void reverseSingleList(ListNode head) {
        // 也可以使用递归反转一个链表
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }

    /***
     * 递归法反转单链表
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

}
