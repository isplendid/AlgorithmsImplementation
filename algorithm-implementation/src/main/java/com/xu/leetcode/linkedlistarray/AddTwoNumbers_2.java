package com.xu.leetcode.linkedlistarray;

/**
 * Created by sop on 2019/2/16.
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Example:

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers_2 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * Two things to make the code simple
     * 1. Whenever one of the two ListNode is null, replace it with 0.
     * 2. Keep the while loop going when at least one of the three conditions is met.
     *
     * 优化点：1）使用头结点 返回 head.next  2）使用 carry !=0 无需再 判断carry =1 的情况
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0);
        ListNode head = prev;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0) {
            int sum = ((l1 == null) ? 0: l1.val) + ((l2 == null) ? 0:l2.val) + carry;
            ListNode cur = new ListNode(sum % 10);
            carry = sum / 10;
            prev.next = cur;
            prev = cur;
            l1 = (l1 == null) ? null : l1.next;
            l2 = (l2 == null) ? null : l2.next;
        }
        return head.next;
    }



    public static void main(String[] args) {

    }

}
