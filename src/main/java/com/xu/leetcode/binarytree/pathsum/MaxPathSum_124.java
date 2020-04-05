package com.xu.leetcode.binarytree.pathsum;

import com.xu.leetcode.binarytree.TreeNode;

/**
 * Created by sop on 2020/3/8.
 *
 * 给定一个非空二叉树，返回其最大路径和。
 * 路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点
 */
public class MaxPathSum_124 {
    private int ans= Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return ans;
    }

    private int maxPath(TreeNode root){
        if(root ==null) return 0;
        int left = Math.max(0, maxPath(root.left) );
        int right = Math.max(0, maxPath(root.right));
        ans = Math.max(ans, left + right + root.val);
        return Math.max(left, right) + root.val;
    }

}
