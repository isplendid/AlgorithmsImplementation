package com.xu.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sop on 2020/3/7.
 *
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 * 给定 BST [1,null,2,2],
 * 提示：如果众数超过1个，不需考虑输出顺序
 */
public class MajorityEleInBST_501 {
    private List<Integer> nodes = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        if(root==null) return new int[0];
        inorderTraversalBST(root);
        List<Integer> res = new ArrayList<Integer>();
        int maxCount=1;
        int curCount=1;
        res.add(nodes.get(0));
        for(int i=1; i<nodes.size();i++){
            if(nodes.get(i).intValue() == nodes.get(i-1).intValue()){
                curCount++;
            } else {
                curCount =1;
            }

            if(curCount == maxCount) {
                res.add(nodes.get(i));
            } else if(curCount > maxCount){
                res = new ArrayList<Integer>();
                res.add(nodes.get(i));
                maxCount = curCount;
            }
        }
        int[] finalRes = new int[res.size()];
        for(int j=0; j<res.size(); j++) {
            finalRes[j] = res.get(j);
        }
        return finalRes;



    }
    private void inorderTraversalBST(TreeNode root){
        if(root == null) return;
        inorderTraversalBST(root.left);
        nodes.add(root.val);
        inorderTraversalBST(root.right);
    }

}
