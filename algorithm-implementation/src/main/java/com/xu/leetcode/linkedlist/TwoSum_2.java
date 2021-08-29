package com.xu.leetcode.linkedlist;

/**
 * Created by sop on 2020/2/23.
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，
 * 并且它们的每个节点只能存储 一位 数字
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 输出：7 -> 0 -> 8
 原因：342 + 465 = 807
 *
 */
public class TwoSum_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        ListNode p = l1, q = l2;
        int carry = 0;
        //trick carry != 0 处理
        while(p != null || q!= null || carry != 0) {
            int x = p == null ? 0 : p.val;
            int y = q == null ? 0 : q.val;
            int sum = x + y + carry;
            ListNode node = new ListNode(sum % 10);
            carry = sum /10;
            cur.next = node;
            cur = cur.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }

        return dummy.next;

    }
}
