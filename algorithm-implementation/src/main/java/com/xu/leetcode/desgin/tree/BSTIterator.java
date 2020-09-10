package com.xu.leetcode.desgin.tree;

import java.util.Stack;

/**
 * Created by sop on 2020/6/14.
 */
public class BSTIterator {
    Stack<TreeNode>  stack;

    public BSTIterator(TreeNode root) {
         this.stack = new Stack<>();
         this.leftMostInorder(root);
    }

    private void leftMostInorder(TreeNode root){
        while(root !=null){
            this.stack.push(root);
            root = root.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
       TreeNode topNode = this.stack.pop();
        if(topNode.right != null){
            this.leftMostInorder(topNode.right);
        }
        return topNode.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
         return this.stack.size() > 0;
    }

    public static void main(String[] args) {

    }
}
