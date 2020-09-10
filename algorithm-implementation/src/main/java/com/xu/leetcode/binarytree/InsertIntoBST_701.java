package com.xu.leetcode.binarytree;

/**
 * Created by sop on 2020/6/7.
 *
 * 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。
 * 返回插入后二叉搜索树的根节点。 保证原始二叉搜索树中不存在新值。
  time: O(H)  ,平均O(logN), 最快O(N)
 space: 0(H), 平均O(logN), 最快O(N)
 */
public class InsertIntoBST_701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        if(root.val < val){
            root.right = insertIntoBST(root.right, val);
        } else if(root.val > val){
            root.left = insertIntoBST(root.left, val);
        }

        return root;
    }
}
