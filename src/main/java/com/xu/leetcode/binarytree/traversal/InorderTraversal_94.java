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

    /***
     * 二叉树Morrris遍历
     * 时间 O(n) 每个节点遍历常数次
     * 空间 O(1)
     * 方法：https://leetcode.wang/leetCode-94-Binary-Tree-Inorder-Traversal.html
     * 记当前遍历的节点为cur
     * 1. cur.left为null, 保存cur的值，更新cur=cur.right
     * 2. cur.left 不为null, 找到 cur.left这棵子树的最右边节点记为last
     *   2.1) last.right为null,那么将last.right = cur, 更新 cur = cur.left
     *   2.2) last.right不为null(说明之前已经访问过，第二次来到这里)，表明当前子树遍历完成，保存cur的值，更新cur=cur.right
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        while(cur!=null){
            if(cur.left == null){ //情况1
                res.add(cur.val);
                cur = cur.right; // 可能指向根节点 7-> 4 (父节点）
            } else {
              //找到左子树最右边的节点
                TreeNode prev = cur.left;
                while(prev.right != null && prev.right != cur){
                    prev = prev.right;
                }
                //情况2.1
                if(prev.right == null){
                    prev.right = cur;
                    cur = cur.left;
                }
                //情况2.2
                if(prev.right == cur){   //  这里cur就是父节点
                    prev.right = null;  //这里可以恢复为null
                    res.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return res;
    }


}
