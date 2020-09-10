package com.xu.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by sop on 2020/2/15.
 * 给你 root1 和 root2 这两棵二叉搜索树。
 请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。
 输入：root1 = [2,1,4], root2 = [1,0,3]
 输出：[0,1,1,2,3,4]
 示例 2：

 */
public class TwoSortedBST_1305 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        return mergeSortedList(inorderTraversal(root1), inorderTraversal(root2));
    }
    private List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while(cur!=null || !stack.empty()){
            while(cur!=null){
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
    }

    private List<Integer> mergeSortedList(List<Integer> l1, List<Integer> l2){
        List<Integer> res = new ArrayList<>();
        int i=0, j=0;
        while( i<l1.size() && j <l2.size()){
            if(l1.get(i) <= l2.get(j)) {
                res.add(l1.get(i++));
            }else {
                res.add(l2.get(j++));
            }
        }
        while(i<l1.size()){
            res.add(l1.get(i++));
        }
        while(j<l2.size()){
            res.add(l2.get(j++));
        }
        return res;
    }

}
