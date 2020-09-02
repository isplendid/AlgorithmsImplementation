package com.xu.leetcode.binarytree;

/**
 * Created by sop on 2020/2/26.
 */
public class LowestCommonAncestorBST_235 {
    /***
     * 间复杂度：O(N)
     其中 N 为 BST 中节点的个数，在最坏的情况下我们可能需要遍历 BST 中所有的节点
     空间复杂度：O(1)
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Value of p
        int pVal = p.val;

        // Value of q;
        int qVal = q.val;

        // Start from the root node of the tree
        TreeNode node = root;

        // Traverse the tree
        while (node != null) {

            // Value of ancestor/parent node.
            int parentVal = node.val;

            if (pVal > parentVal && qVal > parentVal) {
                // If both p and q are greater than parent
                node = node.right;
            } else if (pVal < parentVal && qVal < parentVal) {
                // If both p and q are lesser than parent
                node = node.left;
            } else {
                // We have found the split point, i.e. the LCA node.
                return node;
            }
        }
        return null;
    }

    /***
     * 时间复杂度：O(N)O(N)
     其中 NN 为 BST 中节点的个数，在最坏的情况下我们可能需要访问 BST 中所有的节点。
     空间复杂度：O(N)O(N)
     所需开辟的额外空间主要是递归栈产生的，之所以是 NN 是因为 BST 的高度为 NN。
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor_recursive(TreeNode root, TreeNode p, TreeNode q) {
        // Value of current node or parent node.
        int parentVal = root.val;

        // Value of p
        int pVal = p.val;

        // Value of q;
        int qVal = q.val;

        if (pVal > parentVal && qVal > parentVal) {
            // If both p and q are greater than parent
            return lowestCommonAncestor(root.right, p, q);
        } else if (pVal < parentVal && qVal < parentVal) {
            // If both p and q are lesser than parent
            return lowestCommonAncestor(root.left, p, q);
        } else {
            // We have found the split point, i.e. the LCA node.
            return root;
        }
    }
}
