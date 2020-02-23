package com.xu.leetcode.linkedlist;

/**
 * Created by sop on 2020/2/23.
 *
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 示例：
 给定一个链表: 1->2->3->4->5, 和 n = 2.
 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 说明：
 给定的 n 保证是有效的。
 进阶：
 你能尝试使用一趟扫描实现吗？

 */
public class RemoveNthFromEnd_19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;

        //Move fast in front so that the gap between slow and fast becomes n
        for(int i=1; i<=n+1; i++)   {  //corner case : only one ListNode
            fast = fast.next;
        }
        //Move fast to the end, maintaining the gap
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //Skip the desired node
        slow.next = slow.next.next;
        return dummy.next;

    }
}
