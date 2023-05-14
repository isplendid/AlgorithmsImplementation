package com.xu.leetcode.binarysearch;

import com.xu.leetcode.binarytree.TreeNode;

/**
 * @author xushichao
 * @date 2022/10/5 19:45
 * @desc
 *  逆序 1）相邻：一个，  2）不相邻：两个
 *
 * Example1:
 * 6, 3, 4, 5, 2
 *
 * firstElement: 6 > 3;  =>  (6)
 * secondElement: 5>2;   => (2)
 *
 * 2,4,3,5,6
 * Example2:
 *
 *
 */
public class recoverBSTree_99 {

    TreeNode firstElement = null;
    TreeNode secondElement = null;

    //[5,3,9,-2147483648,-2147483648]:
    // TreeNode prevElement = new TreeNode(Integer.MIN_VALUE);

    TreeNode prevElement = null;


    public void recoverTree(TreeNode root) {

        traverse(root);
        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;

    }

    private void traverse(TreeNode root){
        if(root==null){
            return;
        }
        traverse(root.left);

        // If first element has not been found, assign it to prevElement (refer to 6 in the example above)
        if(prevElement != null) {
            if(firstElement==null && prevElement.val >= root.val){
                firstElement = prevElement;
            }
        }

        // If first element is found, assign the second element to the root (refer to 2 in the example above)
        if(firstElement != null && prevElement.val >= root.val) {
            secondElement = root;
        }

        prevElement = root;

        traverse(root.right);
    }

}

