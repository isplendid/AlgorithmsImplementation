package com.xu.leetcode.backtracking.subsets_combination_permutation;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by sop on 2020/5/28.
 *
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 解集不能包含重复的子集。
 *  输入: nums = [1,2,3]
 输出:
 [
 [3],
   [1],
   [2],
   [1,2,3],
   [1,3],
   [2,3],
   [1,2],
   []
 ]

 链接：https://leetcode-cn.com/problems/subsets
 *
 */
public class Subsets_78 {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        Stack<Integer> path = new Stack<Integer>();
        dfs(nums,0, path);
        return res;

    }

    private void dfs(int[] nums, int start, Stack<Integer> path){
        res.add(new ArrayList<>(path));
        for(int i=start; i<nums.length; i++){
            path.push(nums[i]);
            dfs(nums, i+1, path);
            path.pop();
        }
    }

    public static void main(String[] args) {

    }

}
