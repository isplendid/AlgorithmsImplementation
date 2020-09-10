package com.xu.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by sop on 2020/2/15.
 *
 */
public class BinaryTreeTravesal {


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while(cur!=null || !stack.empty()){
            while(cur!=null){
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
    }
}
