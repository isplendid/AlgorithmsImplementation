package com.xu.leetcode.binarytree.pathsum;

import com.xu.leetcode.binarytree.TreeNode;

/**
 * Created by sop on 2020/3/10.
 *
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
 * 给定二叉树

 1
 / \
 2   3
 / \
 4   5
 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 */
public class DiameterOfBinaryTree_543 {
    int maxDep = 0;
    public int diameterOfBinaryTree(TreeNode root) {

        maxDepth(root);
        return maxDep;

    }
    private int maxDepth(TreeNode root){
        if(root==null) return 0;
        int r= maxDepth(root.right);
        int l = maxDepth(root.left);
        maxDep = Math.max(l+r, maxDep);
        return Math.max(l,r) + 1;
    }
}
