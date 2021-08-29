package com.xu.leetcode.linkedlist;

/**
 * @author xushichao
 * @date 2021/4/4 5:32 PM
 * @desc
 */
public class ListUtil {
    public static ListNode create(int[] nums) {
        ListNode dummy = new ListNode(0), cur = dummy;
        for (int num : nums) {
            cur.next = new ListNode(num);
            cur = cur.next;
        }
        return dummy.next;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            if (head.next != null) {
                System.out.print(head.val + "->");
            } else {
                System.out.print(head.val);
            }
            head = head.next;
        }
        System.out.println();
    }

    /**
     * 将链表分为左右两个半区，左半区：N/2, 右半区剩余的
     *
     * @param head
     */
    public void findMedian(ListNode head) {
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
    }
}
