package com.xu.leetcode.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sop on 2020/3/7.
 * 二叉搜索树中第K小的元素
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 *
 *  进阶：
 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
 */
public class kthSmallestInBST_230 {

    /***
     * Moriris遍历
     * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--48/
     */



    /***
     * 分治法：
     * 如果不知道解法一中二叉搜索树的性质，用分治法也可以做，分享 这里 的解法。
     我们只需要先计算左子树的节点个数，记为 n，然后有三种情况。
     n 加 1 等于 k，那就说明当前根节点就是我们要找的。
     n 加 1 小于 k，那就说明第 k 小的数一定在右子树中，我们只需要递归的在右子树中寻找第 k - n - 1 小的数即可。
     n 加 1 大于 k，那就说明第 k 小个数一定在左子树中，我们只需要递归的在左子树中寻找第 k 小的数即可。
、
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest_divide(TreeNode root, int k) {
        int n = nodeCount(root.left);
        if(n + 1 == k) {
            return root.val;
        } else if (n + 1 < k) {
            return kthSmallest(root.right, k - n - 1);
        } else {
            return kthSmallest(root.left, k);
        }
    }

    private int nodeCount(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return 1 + nodeCount(root.left) + nodeCount(root.right);
    }



    /**
     * 迭代法：
     *  时间复杂度：O(H + k)
     *  空间： O(H+k)
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();

        while (true) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();
            if (--k == 0) return root.val;
            root = root.right;
        }
    }

    /***
     * 中序遍历二叉树，再求第k小的值
     * O(N)
     * O(N)
     */
    private List<Integer> nodes = new ArrayList<>();
    public int kthSmallest_DFS(TreeNode root, int k) {
        inorderTraversalBST(root);
        if(nodes.size() ==0 || k<=0 || k>nodes.size()) return -1;
        int prev=-1;
        for(int node:nodes){
            if(node != prev) {
                k--;
                prev = node;
            }
            if(k==0) return node;
        }
        return -1;

    }

    private void inorderTraversalBST(TreeNode root){
        if(root == null) return;
        inorderTraversalBST(root.left);
        nodes.add(root.val);
        inorderTraversalBST(root.right);
    }
}
