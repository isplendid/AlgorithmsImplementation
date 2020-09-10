package com.xu.leetcode.linkedlist;

/**
 * Created by sop on 2020/3/1.
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 k 是一个正整数，它的值小于或等于链表的长度。
 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 示例 :
 给定这个链表：1->2->3->4->5
 当 k = 2 时，应当返回: 2->1->4->3->5
 当 k = 3 时，应当返回: 3->2->1->4->5

 */
public class ReverseKGroupList_25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k<=1) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = head;
        int count=0;
        while(cur!=null){
            cur=cur.next;
            count++;
        }

        int groups = count/k; // groups组 ，与  leetcode 92 类似，整合分组
        cur = head;
        ListNode prev = dummy,next;
        while(groups -- > 0){
            for(int i=1; i<k; i++){
                next= cur.next;
                cur.next = next.next;
                next.next = prev.next;
                prev.next = next;
            }
            prev = cur;
            cur = cur.next;
        }//while

        return dummy.next;
    }

}
