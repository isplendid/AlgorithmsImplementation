package com.xu.leetcode.contest.c199;

import com.xu.algs.basic.In;
import com.xu.leetcode.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by sop on 2020/7/26.
 */
public class Test3 {
//    private  int maxDepth = -1;
//    public int countPairs(TreeNode root, int distance) {
//        int[] leafCount = levelLeafCount(root);
//        if(maxDepth >= distance){
//            return 0;
//        }
//    }
//
//
//    //层次遍历
//    public int[] levelLeafCount(TreeNode root) {
//        int[] leafCount = new int[100];
//        if(root == null) {
//            return new int[0];
//        }
//        Queue<TreeNode> queue = new LinkedList<TreeNode>();
//        queue.offer(root);
//        TreeNode node = null;
//        int level =0;
//        while(!queue.isEmpty()){
//            level ++;
//            maxDepth = level;
//            int levelNum = queue.size();
//            while(levelNum--  > 0){   //新的一层遍历
//                node = queue.poll();
//                if(node.left !=null){
//                    queue.offer(node.left);
//                }
//                if(node.right !=null){
//                    queue.offer(node.right);
//                }
//                if(node.left == null && node.right == null){
//                    leafCount[level] ++ ;
//                }
//            }
//        }
//        return leafCount;
//    }

//    private void dfs(int index, int depth){
//        if(paths.get(index).size() == 0){
//            leaftCount[depth]++;
//            maxDepth = Math.max(depth, maxDepth);
//            return;
//        } else {
//            for(int i=0; i<paths.get(index).size(); i++){
//                dfs(paths.get(index).get(i), depth +1);
//            }
//
//        }
//
//    }


}
