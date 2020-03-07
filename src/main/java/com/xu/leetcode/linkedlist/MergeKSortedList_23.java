package com.xu.leetcode.linkedlist;

import java.util.PriorityQueue;

/**
 * Created by sop on 2020/2/23.
 *
 * 最小堆，优先队列
 */
public class MergeKSortedList_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null || lists.length==0) return null;

        //优先级队列
        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.length, (a, b)-> a.val-b.val);

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        for(ListNode node: lists){
            if(node!=null){
                queue.add(node);
            }
        }

        while(!queue.isEmpty()){
            tail.next = queue.poll();
            tail = tail.next;
            if(tail.next != null){
                queue.add(tail.next);
            }
        }

        return dummy.next;
    }
}
