package com.xu.leetcode.linkedlist;

import java.util.PriorityQueue;

/**
 * Created by sop on 2020/2/23.
 *
 * 最小堆，优先队列
 */
public class MergeKSortedList_23 {
    /***
     * 优先级队列，复杂度分析
     * 时间复杂度：O（NlogK）， N=kn, n为单个链表长度
     * 空间复杂度：O(n): 创建一个新的链表空间开销为O(n),
     * 采用重复利用原节点，只要O(1)的空间了，优先队列只需要O(k)的空间
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null || lists.length==0) return null;

        //优先级队列，从小到大
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
     * 1) 逐一比较:
     * 时间复杂度，O（kN），其中k是聊表的数目, N
     * 几乎最终有序链表中每个节点的时间开销都为O(k),(k-1次比较）；总共有N个节点在最后的列表中
     * 空间复杂度：O(N)如果创建一个新的链表空间，O(1) 重复利用已有的链表节点
     * 2）两两归并， 分治： 自顶向下
     *
     * 下面使用：分治算法，归并排序； 两两合并，最后归并一起
     * 时间：O(Nlogk), N是所有节点数量
     * 空间： O(1)  ；递归会使用到 O(logk) 空间代价的栈空间
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
