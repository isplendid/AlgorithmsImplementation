package com.xu.leetcode.linkedlist;

import java.util.Stack;

/**
 * Created by sop on 2020/7/19.
 */
public class ReverseList {

    /***
     * 迭代法 反转单链表
     * @param head
     * @return 返回新的链表
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
     *
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

    /***
     * 递归打印链表
     *
     */
    public int[] reversePrint(ListNode head) {

        ListNode prev = null;
        ListNode next = null;
        int cnt = 0;
        while (head != null) {
            cnt++;
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        //prev此时链表头;
        int[] res = new int[cnt];
        next = prev;
        int i = 0;
        while (next != null) {
            res[i++] = next.val;
            next = next.next;
        }
        return res;
    }


    //借助栈实现逆序打印
    public int[] reversePrint_3(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] print = new int[size];
        for (int i = 0; i < size; i++) {
            print[i] = stack.pop().val;
        }
        return print;
    }


    //无需借助栈实现逆序打印
    public int[] reversePrint_2(ListNode head) {
        //先获取链表长度，创建对应长度数组
        ListNode currNode = head;
        int len = 0;
        while (currNode != null) {
            len++;
            currNode = currNode.next;
        }
        int[] result = new int[len];

        //再次遍历链表，将值倒序填充至结果数组
        currNode = head;
        while (currNode != null) {
            result[len - 1] = currNode.val;
            len--;
            currNode = currNode.next;
        }
        return result;
    }

}
