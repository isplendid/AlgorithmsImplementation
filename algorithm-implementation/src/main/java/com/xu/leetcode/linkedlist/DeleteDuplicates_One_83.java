package com.xu.leetcode.linkedlist;

/**
 * @author xushichao
 * @date 2021/8/29 8:08 AM
 * @desc
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 * 1->1->2  =>  1->2
 */
public class DeleteDuplicates_One_83 {


    /***
     *  如果当前cur 与cur.next对应元素相同，将cur.next移除，否则直接cur = cur.next;
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }


    /**
     * 找到重复的最后一个节点
     * @param head
     * @return
     */
    public ListNode deleteDuplicates_2(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while(head!=null) {
            while(head.next!=null && head.val == head.next.val){
                head = head.next;
            }
            prev.next = head;
            prev = head;
            head = head.next;
        }
        return dummy.next;
    }
}
