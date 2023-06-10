package com.xu.leetcode.linkedlist;

import com.mashibing.disruptor.v4.Main;

/**
 * @author xushichao
 * @date 2023/6/7 17:21
 *
 * l1: 1 -> 2 -> 2 -> 3 -> 4
 * l2: 2 -> 4 -> 4 -> 6
 *
 * res:  1->2->3->4->6
 * @desc
 */
public class MergeTwoSortedListWithoutDuplicates {

    public ListNode mergeTwoListWithoutDup(ListNode l1,  ListNode l2) {


        return null;
    }

    private ListNode removeDup(ListNode l1) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        ListNode prev=null;
        while (l1!=null) {
            if(prev!=null && prev.val == l1.val) {
                l1 =l1.next;
                continue;
            }
            cur.next= l1;
            prev = l1;
            cur= cur.next;
            l1 = l1.next;
        }
        return dummy.next;
    }




    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l11= new ListNode(2);
        ListNode l12 = new ListNode(2);
        ListNode l13=  new ListNode(3);
        ListNode l14=  new ListNode(4);
        l1.next=l11;
        l11.next = l12;
        l12.next = l13;
        l13.next = l14;


        ListNode l2 = new ListNode(2);
        ListNode l21= new ListNode(4);
        ListNode l22 = new ListNode(4);
        ListNode l23=  new ListNode(6);
        l2.next = l21;
        l21.next = l22;
        l22.next = l23;

        ListUtil.printList(l1);
        ListUtil.printList(l2);


        MergeTwoSortedListWithoutDuplicates main = new MergeTwoSortedListWithoutDuplicates();
        ListNode remove= main.removeDup(l1);
        ListUtil.printList(remove);


    }
}
