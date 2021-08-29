package com.xu.leetcode.linkedlist;

import java.util.Stack;

/**
 * @author xushichao
 * @date 2021/4/6 10:28 PM
 * <p>
 * 1->2->3->4->5
 * 结果：1->5->2->4->3  右半区逆序
 * @desc
 */
public class ReorderList_143 {
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        //左半区的最后一个节点mid, right是右半区的第一个节点
        //慢指针, 从长度为2开始，长度每增加2， 则mid就往后移动一个节点
        ListNode mid = head;
        //快指针
        ListNode right = head.next;
        while (right.next != null && right.next.next != null) {
            mid = mid.next;
            right = right.next.next;
        }
        //右半区第一个
        right = mid.next;
        //左半区截断
        mid.next = null;
        Stack<ListNode> rightStack = new Stack<>();
        while (right != null) {
            rightStack.push(right);
            right = right.next;
        }
        mergeLR(head, rightStack);
    }

    private static void mergeLR(ListNode left, Stack<ListNode> rightStack) {
        ListNode peek = null;
        while (left != null) {
            peek = rightStack.pop();
            peek.next = left.next;
            left.next = peek;
            left = peek.next;
        }
        while (!rightStack.isEmpty()) {
            ListNode cur = rightStack.pop();
            peek.next = cur;
            cur.next = null;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4,5,6};
        ListNode head = ListUtil.create(arr);
        ListUtil.printList(head);
        reorderList(head);
        ListUtil.printList(head);
    }
}
