package com.xu.leetcode.binarytree.count;

import com.xu.leetcode.binarytree.TreeNode;

/**
 * Created by sop on 2020/08/2020/8/25 10:23
 * 给你一棵二叉树，它的根为 root 。请你删除 1 条边，使二叉树分裂成两棵子树，且它们子树和的乘积尽可能大。
 *
 * 由于答案可能会很大，请你将结果对 10^9 + 7 取模后再返回。
 * 链接：https://leetcode-cn.com/problems/maximum-product-of-splitted-binary-tree

 * @Description:
 */
public class MaxProduct_1339 {
    long res = Long.MIN_VALUE;
    long nodeSum;
    long allSum;
    public int maxProduct(TreeNode root) {
        allSum = sum(root);
        System.out.println(allSum);
        dfs(root);
        return (int)(res % (int)(1e9 + 7));
    }

    private long sum(TreeNode root){
        if(root==null) return 0;
        return sum(root.left) + sum(root.right) + root.val;
    }

    private long dfs(TreeNode root){
        if(root == null) return 0;
        nodeSum = root.val + dfs(root.left) + dfs(root.right);
        System.out.println("nodeSum: "+nodeSum);
        res = Math.max(nodeSum * (allSum - nodeSum), res);
        return nodeSum;
    }

    public static void main(String[] args) {
         TreeNode root = new TreeNode(1);
         root.left = new TreeNode(2);
         root.right = new TreeNode(3);
         root.left.left = new TreeNode(4);
         root.left.right = new TreeNode(5);
         root.right.left = new TreeNode(6);

        MaxProduct_1339 maxProduct = new MaxProduct_1339();
        System.out.println(maxProduct.maxProduct(root));
    }
}
