package com.xu.leetcode.binarytree;


/**
 * Created by sop on 2020/6/3.
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1
 */
public class SortedListToBST_109 {

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        ListNode prevSlow = null;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            prevSlow = slow; //放在前面，否则报错
            slow = slow.next;
        }

        TreeNode root = new TreeNode(slow.val);
        if(prevSlow != null){
            prevSlow.next = null;
            root.left = sortedListToBST(head);
            root.right = sortedListToBST(slow.next);
        }
        return root;
    }

    public static void main(String[] args) {
        SortedListToBST_109 sl = new SortedListToBST_109();
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);
        sl.sortedListToBST(head);
        System.out.println("over!");
    }

}
