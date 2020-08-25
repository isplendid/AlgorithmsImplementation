package com.xu.leetcode.binarytree;

/**
 * Created by sop on 2020/08/2020/8/24 22:58
 * 给定一个二叉树，找出其最小深度。
 * @Description:
 *
 * 另外这道题的关键是搞清楚递归结束条件
 *
 * 叶子节点的定义是左孩子和右孩子都为 null 时叫做叶子节点
 * 当 root 节点左右孩子都为空时，返回 1
 * 当 root 节点左右孩子有一个为空时，返回不为空的孩子节点的深度
 * 当 root 节点左右孩子都不为空时，返回左右孩子较小深度的节点值
 */
public class MinDepth_111 {
    public int minDepth(TreeNode root) {

        if(root == null) return 0;
        if(root.left ==null && root.right == null) return 1;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        
        if(root.left == null || root.right == null) {
            return 1+ left + right;
        }
        return Math.min(left, right) + 1;

    }

}
