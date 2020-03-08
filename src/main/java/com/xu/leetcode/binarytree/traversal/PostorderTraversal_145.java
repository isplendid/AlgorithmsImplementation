package com.xu.leetcode.binarytree.traversal;

import com.xu.leetcode.binarytree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by sop on 2020/3/7.
 */
public class PostorderTraversal_145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> res = new LinkedList<>();
        if(root == null) return res;
        stack.push(root);
        while(!stack.isEmpty() ){
            root = stack.pop();
            res.addFirst(root.val);
            if(root.left != null){
                stack.push(root.left);
            }
            if(root.right != null){
                stack.push(root.right);
            }
        }
        return res;
    }

}
