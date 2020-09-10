package com.xu.leetcode.binarytree.count;

import com.xu.leetcode.binarytree.TreeNode;

/**
 * Created by sop on 2020/7/7.
 * 222. 完全二叉树的节点个数
 *  利用完全二叉树的性质
 */
public class CountCompleteBTNodes_222 {


    /***
     * 时间复杂度的话，因为使用了类似二分的思想，每次都去掉了二叉树一半的节点，
     * 所以总共会进行 O(log(n)) 次。每次求高度消耗 O(log(n))
     * 因此总的时间复杂度也是 O(log²(n))
     *
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }

        int height = getHeight(root);
        int rightHeight = getHeight(root.right);
        //左子树是满二叉树
        if(rightHeight == height -1 ) {
            // 左子树高度和右子树高度相等
            // 左子树加右子树加根节点
            //return (1 << rightHeight) - 1  + countNodes(root.right) + 1;
            return (1 << rightHeight) + countNodes(root.right);
            // 右子树是 满二叉树
        } else {
            // 左子树加右子树加根节点
            //return countNodes(root.left) + (1 << rightHeight) - 1 + 1;
            return countNodes(root.left) + 1<<rightHeight;
        }
    }

    private int getHeight(TreeNode root){  //求高度 log(N)
        if(root==null) {
            return 0;
        }else {
            return getHeight(root.left) + 1;
        }
    }
}
