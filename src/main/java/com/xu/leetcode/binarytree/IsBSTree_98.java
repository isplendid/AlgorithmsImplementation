package com.xu.leetcode.binarytree;

import java.util.Stack;

/**
 * Created by sop on 2020/3/7.
 *
 * 验证是否二叉搜索树
 * 输入为: [5,1,4,null,null,3,6]。  false
 */
public class IsBSTree_98 {

    private boolean helper(TreeNode root, Integer lower, Integer upper){
        if(root == null) return true;
        int val = root.val;
        if(lower != null && val <= lower) return false;
        if(upper != null && val >= upper) return false;
        if(!helper(root.left, lower, val)) return false;
        if(!helper(root.right, val, upper)) return false;
        return true;
    }

    public boolean isValidBST_Recursive(TreeNode root) {
         return helper(root, null, null);
    }


    //方法三：中序遍历
    public boolean isValidBST(TreeNode root){
        if(root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        double last = - Double.MAX_VALUE;  //溢出考虑
        while(root != null || !stack.isEmpty()){
            if(root != null){
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if(last >= root.val) return false;
                last = root.val;
                root = root.right;
            }
        }

        return true;

    }

}
