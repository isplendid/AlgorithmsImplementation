package com.xu.leetcode.binarytree.pathsum;

import com.xu.leetcode.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by sop on 2020/3/8.
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * https://leetcode.wang/leetcode-113-Path-SumII.html
 * [
 [5,4,11,2],
 [5,8,4,5]
 ]
 */
public class PathSumII_113 {
    /***
     * BFS不划算， DFS可以
     * 对于这道题由于我们要保存一条一条的路径，而BFS是一层一层的进行的，
     * 到最后一层一次性会得到很多条路径。这就导致遍历过程中，
     * 我们需要很多list来保存不同的路径，对于这道题是不划算的
     *
     *
     * 我们需要ans变量和temp变量，同样需要注意temp是对象，是引用传递
     *
     *
     * 为何不是 中序遍历：
     * 原因就是我们进行的是中序遍历，当我们还没访问右边的节点的时候，
     * 根节点已经出栈了，再访问右边节点的时候，curSum就会少一个根节点的值。
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        Stack<TreeNode> stack = new Stack<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        TreeNode cur = root;
        TreeNode last = null;
        int curSum =0;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);   //入栈 加入
                curSum += cur.val;
                temp.add(cur.val);
                cur = cur.left;  // 一直添加左节点
            } else {
                cur = stack.peek();  // 已经访问到最左的节点了
                //是否变到右子树
                if(curSum == sum && cur.left == null && cur.right == null){
                    ans.add(new ArrayList<>(temp));
                }
                // 在不存在右节点或者右节点已经访问过的情况下，访问根节点
                if (cur.right != null && cur.right != last) {  //此时未遍历，加入栈中
                    cur = cur.right;
                } else {   //此时才 访问到，弹出栈，last 访问的元素更新下
                    TreeNode pop = stack.pop();   //出栈 减去 该值
                    curSum -= pop.val; //减去出栈的值
                    temp.remove(temp.size() - 1);
                    last = cur;
                    cur= null;
                }
            }
        }
        return ans;
    }



    //递归解法
    public List<List<Integer>> pathSum_recursive(TreeNode root, int sum) {
        List<List<Integer>> res  = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(root, sum, temp,res);
        return res;
    }

    private void helper(TreeNode root, int sum, List<Integer> temp , List<List<Integer>> res){
        if(root == null) return;
        if(root.left == null && root.right == null){
            if(root.val == sum){
                temp.add(root.val);
                res.add(new ArrayList<>(temp));
                temp.remove(temp.size()-1);
            }
            return;
        }
        temp.add(root.val); // 加在路径上
        helper(root.right, sum - root.val, temp, res); //右子树
        temp.remove(temp.size() - 1);

        temp.add(root.val);
        helper(root.left, sum - root.val, temp, res); //左子树
        temp.remove(temp.size() - 1);

    }
}
