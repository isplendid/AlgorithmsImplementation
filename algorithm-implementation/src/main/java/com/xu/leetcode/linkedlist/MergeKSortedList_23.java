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

    /**
     * 1).两两归并
     * 2）分治： 自顶向下
     *
     * 分治算法，归并排序
     * @param lists
     * @return
     */
    public ListNode mergeKLists_division(ListNode[] lists){
        if(lists.length == 0){
            return null;
        }
        return  mergeHelper(lists, 0, lists.length-1);

    }

    private ListNode mergeHelper(ListNode[] lists, int start, int end){
        if(start == end){
            return lists[start];
        }
        int mid = start + (end -start)/2;

        ListNode left = mergeHelper(lists, start, mid);
        ListNode right = mergeHelper(lists, mid + 1, end);
        return mergeTwoLists(left,right);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while(l1 != null && l2 != null){
            if(l1.val <l2.val){
                tail.next = l1;
                tail = tail.next;
                l1 = l1.next;
            }else {
                tail.next = l2;
                tail = tail.next;
                l2 = l2.next;
            }
        }

        tail.next = l1 != null ? l1: l2;
        return dummy.next;
    }


}
