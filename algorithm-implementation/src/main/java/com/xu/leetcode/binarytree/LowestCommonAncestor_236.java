package com.xu.leetcode.binarytree;

import java.util.*;

/**
 * Created by sop on 2020/2/26.
 */
public class LowestCommonAncestor_236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // Stack for tree traversal
        //双端队列也可用作 LIFO（后进先出）堆栈。应优先使用此接口而不是遗留 Stack 类
        Deque<TreeNode> stack = new ArrayDeque<>();
        // HashMap for parent pointers
        Map<TreeNode, TreeNode> parent = new HashMap<>();

        parent.put(root, null);
        stack.push(root);

        // Iterate until we find both the nodes p and q
        while (!parent.containsKey(p) || !parent.containsKey(q)) {

            TreeNode node = stack.pop();

            // While traversing the tree, keep saving the parent pointers.
            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }

        // Ancestors set() for node p.
        Set<TreeNode> ancestors = new HashSet<>();

        // Process all ancestors for node p using parent pointers.
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }

        // The first ancestor of q which appears in
        // p's ancestor set() is their lowest common ancestor.
        while (!ancestors.contains(q))
            q = parent.get(q);
        return q;
    }



    //递归功能处理

    public TreeNode lowestCommonAncestor_recusive(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor( root.left,  p,  q);
        TreeNode right = lowestCommonAncestor( root.right,  p,  q);

        if(left != null && right != null){
            return root;
        }

        return left == null ? right : left;

    }

}
