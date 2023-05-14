package com.xu.leetcode.binarytree.traversal;

import com.xu.leetcode.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by sop on 2019/4/20.
 *
 *
 */
public class LevelTraversalTree_102 {
    /***
     * Given binary tree [3,9,20,null,null,15,7],
     3
     / \
     9  20
     /  \
     15   7
     return its level order traversal as:
     [
     [3],
     [9,20],
     [15,7]
     ]
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        TreeNode node;
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> list = new ArrayList<Integer>();
            while(levelNum--  > 0){   //新的一层遍历
                node = queue.poll();
                list.add(node.val);
                if(node.left !=null){
                    queue.offer(node.left);
                }
                if(node.right !=null){
                    queue.offer(node.right);
                }
            }

            result.add(list);    // 逆序打印： result.add(0,list);; 注意使用LinkedList, 插入头部的时间复杂度为O(1)
        }
        return result;
    }


    /***
     * Average of Levels in Binary Tree
     *
     * Input:
     3
     / \
     9  20
     /  \
     15   7
     Output: [3, 14.5, 11]
     * @param root
     * @return
     */
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

}
