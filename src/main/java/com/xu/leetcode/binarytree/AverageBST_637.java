package com.xu.leetcode.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by sop on 2020/2/15.
 *
 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
 Example 1:
 Input:
 3
 / \
 9  20
 /  \
 15   7
 Output: [3, 14.5, 11]
 Explanation:
 The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
 */
public class AverageBST_637 {
    //层次遍历
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<Double>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        TreeNode node;
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> levelList = new ArrayList<Integer>();
            while(levelNum--  > 0){   //新的一层遍历
                node = queue.poll();
                levelList.add(node.val);
                if(node.left !=null){
                    queue.offer(node.left);
                }
                if(node.right !=null){
                    queue.offer(node.right);
                }
            }
            result.add(averageList(levelList));
        }
        return result;

    }
    private Double averageList(List<Integer> list)  {
        if(null == list || list.size() == 0) return 0.0;
        Double sum = 0.0;
        for(Integer li: list){
            sum += li;
        }
        return  sum/list.size();
    }
    //深度优先遍历二叉树
    public List<Double> averageOfLevels2(TreeNode root) {
        List<List<Integer>> res =new ArrayList<>();
        List<Double> ans = new ArrayList<>();
        dfs(root, 0, res);
        for(List<Integer> list:res){
            long sum = 0;
            for(Integer i:list){
                sum += i;
            }
            ans.add((Double)(sum*1.0/list.size()));
        }
        return ans;

    }

    /**
     * 核心dfs代码
     * @param root
     * @param level
     * @param res
     */
    private void dfs(TreeNode root, int level, List<List<Integer>> res){
        if(root==null) return;
        while(res.size() <= level) res.add(new ArrayList<Integer>());
        res.get(level).add(root.val);
        dfs(root.left, level+1, res);
        dfs(root.right, level+1, res);
    }

}
