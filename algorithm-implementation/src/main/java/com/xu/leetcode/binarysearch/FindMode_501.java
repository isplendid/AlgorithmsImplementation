package com.xu.leetcode.binarysearch;

import com.xu.leetcode.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author xushichao
 * @date 2022/10/5 17:16
 * @desc
 * 二叉搜索树 返回众数数组
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 */

public class FindMode_501 {
    List<Integer> answer = new ArrayList<Integer>();
    /**
     * base 记录当前的数字
     * count 记录当前数字重复的次数
     * 用 maxCount 来维护已经扫描过的数当中出现最多的那个数字的出现次数，
     * 用 answer 数组记录出现的众数
     */
    int base, count, maxCount;

    public int[] findMode(TreeNode root) {
        dfs(root);
        int[] res = new int[answer.size()];
        for(int i=0; i<res.length; i++){
            res[i] = answer.get(i);
        }
        return res;
    }
    private void dfs(TreeNode root){
        if(root==null){
            return;
        }
        dfs(root.left);
        update(root.val);
        dfs(root.right);
    }
    private void update(int val) {
        if(val == base) {
            count++;
        } else {
            count = 1;
            base = val;
        }

        if(count== maxCount) {
            answer.add(count);
        } else if(count > maxCount ) {
            answer.clear();
            answer.add(base);
        }
    }





//    while (cur != null || !stack.isEmpty()) {
//        //节点不为空一直压栈
//        while (cur != null) {
//            stack.push(cur);
//            cur = cur.left; //考虑左子树
//        }
//        //节点为空，就出栈
//        cur = stack.pop();
//        //当前值加入
//        if(cur.val == pev) {
//
//        }
//
//        //考虑右子树
//        cur = cur.right;
//    }

}
