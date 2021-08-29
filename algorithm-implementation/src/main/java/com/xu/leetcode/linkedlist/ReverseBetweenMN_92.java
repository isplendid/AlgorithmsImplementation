package com.xu.leetcode.linkedlist;

/**
 * Created by sop on 2020/3/1.
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 说明:
 1 ≤ m ≤ n ≤ 链表长度。
 */
public class ReverseBetweenMN_92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head ==null ) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        for(int i=1; i<m; i++){
            prev = prev.next;
        }
       //精髓： prev一直指向m前一个的节点， cur一直指向第m个节点，往后位移  （prev,cur指向的节点都不变    ）
        ListNode cur = prev.next;
        //next是cur的下一个节点
        ListNode next= null;
        for(int i =m; i<n; i++){
            next = cur.next;
            cur.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }
        return dummy.next;
    }
}
