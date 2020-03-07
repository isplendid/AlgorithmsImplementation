package com.xu.leetcode.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sop on 2020/3/1.
 */
public class ZigzagLevelOrder_103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        TreeNode node;
        boolean isLeft2Right = false;
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            List<Integer> list = new ArrayList<Integer>();
            while (levelNum-- > 0) {   //新的一层遍历
                node = queue.poll();
                if (isLeft2Right) {
                    list.add(0, node.val);
                } else {
                    list.add(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            isLeft2Right = !isLeft2Right;
            result.add(list);    // 逆序打印： result.add(0,list);
        }
        return result;


    }
}
