package com.xu.leetcode.binarytree.traversal;

import com.xu.leetcode.binarytree.TreeNode;

/**
 * Created by sop on 2020/6/19.\
 * 展开二叉树
 *  如果左子树为null,则 root =root.right
 * 1.将根节点 右子树插入到 左子树最右边节点下
 * 2.将根节点 左子树调到 右子树 ，左子树置为null
 * 3. root=root.right.重复下一个节点
 */
public class FlattenBT_114 {
    public void flatten(TreeNode root){
        while(root != null) {
            //左子树为null,直接考虑下一个节点
            if(root.left == null){
                root = root.right;
            }else {
                //找到左子树最右边节点
                TreeNode prev = root.left;
                while(prev.right != null){
                    prev = prev.right;
                }
                //将原来的右子树接到左子树的最右边节点
                prev.right = root.right;
                //将左子树插入到右子树的地方
                root.right = root.left;
                root.left = null;

                //考虑下一个节点
                root =root.right;
            }
        }
    }
}
