package com.xu.leetcode.linkedlist;

/**
 * Created by sop on 2020/3/3.
 */
public class DetectCycleEntrance_211 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast =head, slow = head;
        while(true){
            if(fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast) break;
        }
        fast = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
