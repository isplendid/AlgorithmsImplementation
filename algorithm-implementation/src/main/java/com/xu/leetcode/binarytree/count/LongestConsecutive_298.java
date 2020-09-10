package com.xu.leetcode.binarytree.count;

import com.xu.leetcode.binarytree.TreeNode;

/**
 * Created by sop on 2020/6/6.
 * 给你一棵指定的二叉树，请你计算它最长连续序列路径的长度。

 一个自顶向下的搜索方法与中序遍历类似。我们用一个变量 length 保存当前连续的路径长度并将这个变量沿着树传递。
 当我们遍历的时候，我们比较当前节点和父节点是否是连续的。
 如果不是，我们将长度重置为 1 。
 */
public class LongestConsecutive_298 {

    private int maxLength = 0;
    public int longestConsecutive(TreeNode root) {
       dfs(root, null, 0);
        return maxLength;
    }
    private  void dfs(TreeNode p, TreeNode parent, int length){
        if(p == null) return;
         length = (parent!=null && p.val == parent.val + 1) ?  length +1 : 1;
        maxLength = Math.max(maxLength, length);
        dfs(p.left, p, length);
        dfs(p.right, p, length);
    }
}
