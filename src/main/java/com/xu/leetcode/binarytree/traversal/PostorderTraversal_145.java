package com.xu.leetcode.binarytree.traversal;

import com.xu.leetcode.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by sop on 2020/3/7.
 */
public class PostorderTraversal_145 {

    /***
     * 然后把 根 -> 右 -> 左 逆序，就是 左 -> 右 -> 根，也就是后序遍历了。
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> res = new LinkedList<>();
        if(root == null) return res;
        stack.push(root);
        while(!stack.isEmpty() ){
            root = stack.pop();
            res.addFirst(root.val); //逆序加入，先序遍历：左->右->根
            if(root.left != null){
                stack.push(root.left);
            }
            if(root.right != null){
                stack.push(root.right);
            }
        }
        return res;
    }



    /***
     * 一个栈实现非递归后续遍历
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode last = null;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode temp = stack.peek();
                //是否变到右子树
                if (temp.right != null && temp.right != last) {  //此时未遍历，加入栈中
                    cur = temp.right;
                } else {
                    list.add(temp.val); //此时才 访问到，弹出栈，last 访问的元素更新下
                    last = temp;
                    stack.pop();
                }
            }
        }
        return list;
    }

    /***
     * 一个栈实现非递归后续遍历
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal_post(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> toVisit = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;

        while (cur != null || !toVisit.isEmpty()) {
            while (cur != null) {
                toVisit.push(cur); // 添加根节点
                cur = cur.left; // 递归添加左节点
            }
            cur = toVisit.peek(); // 已经访问到最左的节点了
            // 在不存在右节点或者右节点已经访问过的情况下，访问根节点
            if (cur.right == null || cur.right == pre) {
                toVisit.pop();
                result.add(cur.val);
                pre = cur;
                cur = null;
            } else {
                cur = cur.right; // 右节点还没有访问过就先访问右节点
            }
        }
        return result;
    }
}
