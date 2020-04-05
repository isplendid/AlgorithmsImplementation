package com.xu.leetcode.binarytree.pathsum;

import com.xu.leetcode.binarytree.TreeNode;

/**
 * Created by sop on 2020/3/8.
 *
 *
 */
public class PathSumIII_437 {




    /***
     * 递归实现
     * @param root
     * @param sum
     * @return
     */
    public int pathSum(TreeNode root, int sum) {
        if (root==null)
            return 0;
        return pathSum(root.left, sum) + pathSum(root.right, sum) + dfs(root, sum);
    }

    public int dfs(TreeNode node, int sum) {
        if (node==null)
            return 0;

        int count = 0;
        if (node.val == sum)
            count = 1;

        return count + dfs(node.left, sum - node.val) + dfs(node.right, sum - node.val);
    }

}
