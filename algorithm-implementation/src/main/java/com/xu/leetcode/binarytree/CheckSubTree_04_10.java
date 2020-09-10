package com.xu.leetcode.binarytree;

/**
 * Created by sop on 2020/4/13.
 *
 * 检查子树。你有两棵非常大的二叉树：T1，有几万个节点；T2，有几万个节点。设计一个算法，判断 T2 是否为 T1 的子树。
 如果 T1 有这么一个节点 n，其子树与 T2 一模一样，则 T2 为 T1 的子树，也就是说，从节点 n 处把树砍断，得到的树与 T2 完全相同。
 链接：https://leetcode-cn.com/problems/check-subtree-lcci
 */
public class CheckSubTree_04_10 {
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if(t1== null){
            return t2 == null;
        }
        return isSame(t1,t2) ||checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);

    }
    private boolean isSame(TreeNode t1, TreeNode t2){
        if(t1== null && t2 == null) return true;
        if(t1==null || t2 == null) return false;

        return t1.val == t2.val && isSame(t1.right, t2.right) && isSame(t1.left, t2.left);
    }
}
