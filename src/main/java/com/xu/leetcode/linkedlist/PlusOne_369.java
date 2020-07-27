package com.xu.leetcode.linkedlist;

/**
 * Created by sop on 2020/7/19.
 *链接：https://leetcode-cn.com/problems/plus-one-linked-list/solution/gei-dan-lian-biao-jia-yi-by-leetcode/
 初始化哨兵节点 ListNode(0)，同时将它设为新的头节点：sentinel.next = head。

 1) 找到最靠右的数值不为 9 的节点。 notNine

 2) 将该节点的数值加 1。

 3)将该节点之后所有节点数值改为 0。

 4) 如果哨兵节点的数值为 1，直接返回哨兵节点，否则返回原始头节点 sentinel.next
 */
public class PlusOne_369 {

    public ListNode plusOne(ListNode head) {
        // sentinel head
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode notNine = sentinel;

        // find the rightmost not-nine digit
        while (head != null) {
            if (head.val != 9) notNine = head;
            head = head.next;
        }

        // increase this rightmost not-nine digit by 1
        notNine.val++;
        notNine = notNine.next;

        // set all the following nines to zeros
        while (notNine != null) {
            notNine.val = 0;
            notNine = notNine.next;
        }

        return sentinel.val != 0 ? sentinel : sentinel.next;
    }

}
