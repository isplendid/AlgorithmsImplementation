package com.xu.leetcode.linkedlist;

/**
 * Created by sop on 2020/2/24.
 */
public class DeleteDuplicates_82 {
    public ListNode deleteDuplicates(ListNode head) {
        //use two pointers, slow -track the node before the dup ndoes,
        //fast - to find the last node of dups.
        ListNode dummy = new ListNode(-1);
        ListNode slow = dummy, fast = head;
        slow.next = fast;
        while(fast != null){
            while(fast.next != null && fast.val == fast.next.val){
                fast = fast.next; //while loop to find the last node oft the dups
            }
            if(slow.next != fast){ //duplicates detected
                slow.next = fast.next;// remove the dups
                fast = slow.next;
            }else { //no dup, move forward both pointers
                slow = slow.next;
                fast = fast.next;
            }
        }
        return dummy.next;
    }
}
