package com.xu.leetcode.linkedlist;

/**
 * @author xushichao
 * @date 2021/4/3 9:44 PM
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * @desc
 */
public class OtateRight_61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        //先计算节点数据量,再对k取余
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        int n = k % count;
        //定位倒数第n个元素的前一个元素
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        for (int i = 1; i <= n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        fast.next = dummy.next;
        dummy.next = slow.next;
        //一定要释放该节点的next置为null,否则成环
        slow.next = null;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        OtateRight_61 ot = new OtateRight_61();
        ot.printList(head);
        ListNode res = ot.rotateRight(head, 2);
        ot.printList(res);
    }

    private void printList(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode cur = head;
        if (cur != null) {
            sb.append(cur.val);
            cur = cur.next;
        }
        while (cur != null) {
            sb.append("->").append(cur.val);
            cur = cur.next;
        }
        System.out.println(sb.toString());
    }
}
