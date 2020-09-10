package com.xu.leetcode.binarytree.pathsum;

import com.xu.leetcode.binarytree.TreeNode;

/**
 * Created by sop on 2020/3/8.
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 * 找出路径和等于给定数值的路径总数。
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整
 * 链接：https://leetcode-cn.com/problems/path-sum-iii
 */
public class PathSumIII_437 {

    /***
     * 递归实现
     * <p>
     * 解法：
     * 接下来，我们来考虑再上升的一个层次，题目要求 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点） 。这就要求我们只需要去求三部分即可：
     * <p>
     * 1）以当前节点作为头结点的路径数量
     * 2）以当前节点的左孩子作为头结点的路径数量
     * 3）以当前节点的右孩子作为头结点的路径数量
     * <p>
     * 最后的问题是：我们应该如何去求以当前节点作为头结点的路径的数量？
     * 这里依旧是按照树的遍历方式模板，每到一个节点让 sum-root.val，并判断sum是否为0，
     * 如果为零的话，则找到满足条件的一条路径
     *
     * @param root
     * @param sum
     * @return
     */
    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        return pathSum(root.left, sum) + pathSum(root.right, sum) + dfs(root, sum);
    }

    public int dfs(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }
        int count = node.val == sum ? 1 : 0;
        return count + dfs(node.left, sum - node.val) + dfs(node.right, sum - node.val);
    }

}
