package com.xu.leetcode.linkedlist;

/**
 * Created by sop on 2020/3/4.
 *
 * 相交链表
 */
public class IntersectionNode_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;

        while(pA != pB){
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }

        return pA;

    }
}
