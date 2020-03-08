package com.xu.leetcode.binarytree.traversal;

import com.xu.leetcode.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by sop on 2020/3/7.
 * 二叉树非递归中序遍历
 */
public class InorderTraversal_94 {

    /**
     * 中序遍历  非递归
     * 时间o(n)
     * 空间o(h):栈消耗，h 是二叉树的高度
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal_simple(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            //节点不为空一直压栈
            while (cur != null) {
                stack.push(cur);
                cur = cur.left; //考虑左子树
            }
            //节点为空，就出栈
            cur = stack.pop();
            //当前值加入
            ans.add(cur.val);
            //考虑右子树
            cur = cur.right;
        }
        return ans;
    }


    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack =new Stack<>();
        if(root == null) return res;
        while(!stack.isEmpty() || root != null) {
            if(root != null) { //一直向左，并压入栈
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }


}
