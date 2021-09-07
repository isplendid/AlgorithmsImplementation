package com.xu.leetcode.binarytree.traversal;

import com.xu.leetcode.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by sop on 2020/3/7.
 * 前序 与中序结构一样，不同的是  add List的地方不一致
 */
public class PreorderTraversal_144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<>();

        while(!stack.isEmpty() || root != null){
            while(root != null){
                //先序遍历
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            //中序遍历
            root = root.right;
        }
        return res;
    }

    public List<Integer> preorderTraversal1(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() ){
            root = stack.pop();
            res.add(root.val);
            if(root.right != null){
                stack.push(root.right);
            }
            if(root.left != null){
                stack.push(root.left);
            }

        }
        return res;
    }

    /***
     * 递归方法
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal_recursive(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        preorder(root, res);
        return res;
    }

    public void preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }

}
