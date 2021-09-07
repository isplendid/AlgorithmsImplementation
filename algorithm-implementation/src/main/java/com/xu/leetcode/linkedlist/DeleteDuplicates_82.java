package com.xu.leetcode.linkedlist;

/**
 * Created by sop on 2020/2/24.
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
 * 1->1->2  =>  2
 */
public class DeleteDuplicates_82 {
    /**
     * 跟我的方法83的方法2类似
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        //use two pointers, slow -track the node before the dup ndoes,
        //fast - to find the last node of dups.
        ListNode dummy = new ListNode(-1);
        ListNode slow = dummy, fast = head;
        slow.next = fast;
        while (fast != null) {
            while (fast.next != null && fast.val == fast.next.val) {
                fast = fast.next; //while loop to find the last node of the dups
            }
            if (slow.next != fast) { //duplicates detector
                slow.next = fast.next;// remove the dups
                fast = slow.next;
            } else { //no dup, move forward both pointers
                slow = slow.next;
                fast = fast.next;
            }
        }
        return dummy.next;
    }
}
