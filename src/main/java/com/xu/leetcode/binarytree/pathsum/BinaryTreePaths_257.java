package com.xu.leetcode.binarytree.pathsum;

import com.xu.leetcode.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by sop on 2020/3/8.
 *
 * 输出: ["1->2->5", "1->3"]
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 */
public class BinaryTreePaths_257 {

    /***
     *  DFS
     */

    public List<String> binaryTreePaths_DFS(TreeNode root) {
        List<String> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        binaryTreePaths(root, "", result);
        return result;
    }

    private void binaryTreePaths(TreeNode root, String temp, List<String> result) {
        if (root.left == null && root.right == null) {
            temp = temp + root.val;
            result.add(temp);
            return;
        }
        if (root.left != null) {
            binaryTreePaths(root.left, temp + root.val + "->", result);
        }
        if (root.right != null) {
            binaryTreePaths(root.right, temp + root.val + "->", result);
        }
    }


    /**
     * 后续遍历，迭代 算入所有的值
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<List<Integer>> tempRes = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        List<Integer> tmpList = new ArrayList<>();
        while(cur != null || !stack.isEmpty()){
            if(cur != null){
                stack.push(cur);
                tmpList.add(cur.val);
                cur = cur.left;
            } else {
                TreeNode temp  = stack.peek();
                if(temp.left == null && temp.right == null){
                    tempRes.add(new ArrayList<>(tmpList));
                }
                if(temp.right != null && temp.right != prev){
                    cur = temp.right;
                } else {
                    tmpList.remove(tmpList.size()-1);
                    prev = temp;
                    stack.pop();
                }
            }
        }

        return transfer(tempRes);
    }

    private List<String>  transfer(List<List<Integer>> ints){
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        String join = "->";
        for(List<Integer>  list : ints){
            sb.delete(0,sb.length());
            for(int i=0; i<list.size(); i++){
                sb.append(list.get(i));
                if(i!=list.size() -1 ){
                    sb.append(join);
                }
            }
            res.add(sb.toString());
        }
        return res;
    }


}
