package com.xu.leetcode.linkedlist;

import com.xu.leetcode.binarytree.TreeNode;

/**
 * @author xushichao
 * @date 2021/8/29 9:25 AM
 * @desc
 */
public class SortedList2BST_109 {


    /**
     * 分治法+中序遍历
     * 方法一的时间复杂度的瓶颈在于寻找中位数节点。由于构造出的二叉搜索树的中序遍历结果就是链表本身，因此我们可以将分治和中序遍历结合起来，减少时间复杂度。
     * @param head
     * @return
     */
    public TreeNode sortedListToBST_opt(ListNode head) {
        return buildTree(head, null);
    }

    /***
     *
     * 分治法
     * 设当前链表的左端点为 left，右端点 right，包含关系为「左闭右开」，即 left 包含在链表中而right 不包含在链表中
     * 时间O(nlogn), n是链表长度， T（n) = 2* T(n/2) + n; 根据主定理
     * 空间O(logn), 递归过程栈的最大深度 ，平衡二叉树的高度为O(logn)
     *
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head, null);
    }

    private TreeNode buildTree(ListNode left, ListNode right) {
        if(left == right){
            return null;
        }
        ListNode mid = getMedian(left, right);
        TreeNode root = new TreeNode(mid.val);
        root.left = buildTree(left, mid);
        root.right = buildTree(mid.next, right);
        return root;
    }

    private ListNode getMedian(ListNode left, ListNode right) {
        ListNode fast = left;
        ListNode slow = left;
        while(fast!=right && fast.next != right){
            fast = fast.next.next;
            slow = slow.next;
        }
        return  slow;
    }





}
