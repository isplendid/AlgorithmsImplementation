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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        while(l1 != null){
            s1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            s2.push(l2.val);
            l2 = l2.next;
        }

        int sum = 0;

        ListNode list = new ListNode(0);
        while(!s1.isEmpty() || ! s2.isEmpty()){
            if(!s1.isEmpty()) sum += s1.pop();
            if(!s2.isEmpty()) sum += s2.pop();

            list.val = sum % 10;
            ListNode head = new ListNode(sum/10);
            head.next = list;
            list = head;
            sum /=10;
        }
        return list.val == 0? list.next : list;
    }
}
