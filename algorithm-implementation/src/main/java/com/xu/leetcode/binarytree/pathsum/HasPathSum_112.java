package com.xu.leetcode.binarytree.pathsum;

import com.xu.leetcode.binarytree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by sop on 2020/3/8.
 *
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 */
public class HasPathSum_112 {


    /***
     * 后续遍历实现的代码：
     * 当访问到根节点的时候，它的右子树可能访问过了，那就把根节点输出。
     * 它的右子树可能没访问过，我们需要去遍历它的右子树。
     * 所以我们要用一个变量pre保存上一次遍历的节点，
     * 用来判断当前根节点的右子树是否已经遍历完成
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> toVisit = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        int curSum = 0; //记录当前的累计的和
        while (cur != null || !toVisit.isEmpty()) {
            while (cur != null) {
                toVisit.push(cur); // 添加根节点
                curSum += cur.val;
                cur = cur.left; // 递归添加左节点
            }
            cur = toVisit.peek(); // 已经访问到最左的节点了
            //判断是否满足条件
            if (curSum == sum && cur.left == null && cur.right == null) {
                return true;
            }
            // 在不存在右节点或者右节点已经访问过的情况下，访问根节点
            if (cur.right == null || cur.right == pre) {
                TreeNode pop = toVisit.pop();
                curSum -= pop.val; //减去出栈的值
                pre = cur;
                cur = null;
            } else {
                cur = cur.right; // 右节点还没有访问过就先访问右节点
            }
        }
        return false;
    }


    public boolean hasPathSum_BFS(TreeNode root, int sum){
        if(root == null)    return false;
        boolean res = false;
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        q1.offer(root);
        q2.offer(root.val);
        while(!q1.isEmpty())
        {
            TreeNode cur = q1.poll();
            int temp = q2.poll();
            if(cur.left == null && cur.right == null && temp == sum)
                res = true;
            if(cur.left != null)
            {
                q1.offer(cur.left);
                q2.offer(cur.left.val + temp);
            }
            if(cur.right != null)
            {
                q1.offer(cur.right);
                q2.offer(cur.right.val + temp);
            }
        }
        return res;
    }


    /***
     * 像BFS一样，再增加一个栈，去保存从根节点到当前节点累计的和就可以了
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum_Inorder(TreeNode root, int sum) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> stackSum = new Stack<>();
        TreeNode cur = root;
        int curSum = 0;
        while (cur != null || !stack.isEmpty()) {
            // 节点不为空一直压栈
            while (cur != null) {
                stack.push(cur);
                curSum += cur.val;
                stackSum.push(curSum);
                cur = cur.left; // 考虑左子树
            }
            // 节点为空，就出栈
            cur = stack.pop();
            curSum = stackSum.pop();
            //判断是否满足条件
            if (curSum == sum && cur.left == null && cur.right == null) {
                return true;
            }
            // 考虑右子树
            cur = cur.right;
        }
        return false;
    }


    /***
     * 递归解决 判断是否是pathsum;
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum_recursive(TreeNode root, int sum) {
        if(null == root) return false;
        if(null == root.left && null == root.right) return root.val == sum;
        boolean l = hasPathSum_recursive(root.left, sum - root.val);
        boolean r = hasPathSum_recursive(root.right, sum - root.val);
        return l||r;
    }
}
