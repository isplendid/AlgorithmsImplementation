package com.xu2022.resume;


import com.xu.leetcode.linkedlist.ListNode;

import java.util.PriorityQueue;

/**
 * @author xushichao
 * @date 2022/8/6 9:31 PM
 * @desc
 *
 * 1->4->5,
 * 1->3->4,
 * 2->6
 *
 * 1->1->2->3->4->4->5->6
 *     5
 *  , 6
 *
 *
 *    4->5,
 *    3->4
 * dummy
 * head -> 1 -> 1 -> 2 ->4
 */
public class MergeKSortedLinkedList {
    public ListNode mergeKLists(ListNode[] lists) {

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        PriorityQueue<ListNode> minP = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);

        for(ListNode node: lists){
            if(node !=null){
                minP.add(node);
            }
        }
        while(!minP.isEmpty()) {
            tail.next = minP.poll();
            tail = tail.next;
            if(tail.next != null){
                minP.add(tail.next);
            }
        }
        return dummy.next;
    }
}
