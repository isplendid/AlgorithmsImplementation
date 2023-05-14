package com.xu.leetcode.backtracking.subsets_combination_permutation;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by sop on 2020/5/28.
 *
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * 输入: [1,2,3]   n!
 *
 *
 * 但是必须说明的是，不管怎么优化，都符合回溯框架，而且时间复杂度都不可能低于 O(N!)，
 * 因为穷举整棵决策树是无法避免的。
 * 这也是回溯算法的一个特点，不像动态规划存在重叠子问题可以优化，回溯算法就是纯暴力穷举，复杂度一般都很高
 */
public class Permutation_46 {


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Stack<Integer> path = new Stack<Integer>();
        backtrack(nums, path, res);
        return res;
    }
    // 路径：记录在 path 中
    // 选择列表：nums 中不存在于 path 的那些元素
    // 结束条件：nums 中的元素全都在 path 中出现
    private void backtrack(int[] nums, Stack<Integer> path, List<List<Integer>> res) {
        //触发结束条件
        if(path.size() == nums.length){
            res.add(new ArrayList(path));
            return;
        }
        for(int i=0; i<nums.length; i++){
            //排除不合法的选择
            if(path.contains(nums[i])){  //used or not   boolean[] used 数组处理
                continue;
            }
            //做选择
            path.push(nums[i]);

            //进入下一层决策树
            backtrack(nums, path, res);
            //取消选择
            path.pop();
        }


    }


}
