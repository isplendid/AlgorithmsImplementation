package com.xu.leetcode.linkedlist;

import java.util.Stack;

/**
 * Created by sop on 2020/3/8.
 *
 * 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。
 * 将这两数相加会返回一个新的链表
 * 输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出: 7 -> 8 -> 0 -> 7
 */
public class TwoSumII_445 {
    /**
     * 用栈处理，逆序处理，注意trick, carry != 0
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode p=l1, q = l2;
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        while(p!=null) {
            s1.push(p.val);
            p = p.next;
        }
        while(q!=null) {
            s2.push(q.val);
            q = q.next;
        }
        int carry = 0;
        ListNode res= null;;
        while(!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
            int x = s1.isEmpty()? 0: s1.pop();
            int y = s2.isEmpty()? 0: s2.pop();
            int sum = x + y + carry;
            ListNode curnode = new ListNode( sum % 10);
            curnode.next = res;
            carry =  sum /10;
            res = curnode;
        }
        return res;

    }
}
