package com.xu.leetcode.binarytree;

/**
 * Created by sop on 2020/6/3.
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 */
public class SortedArrayToBST_108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length-1);
    }

    private TreeNode buildBST(int[] nums, int left, int right) {
        if(left > right) return  null;
        int mid = left + (right - left) /2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBST(nums,left,mid-1);
        root.right = buildBST(nums,mid+1, right);
        return root;
    }
}
