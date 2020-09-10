package com.xu.leetcode.backtracking.subsets_combination_permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by sop on 2020/5/30.
 */
public class SubsetsDup_90 {


    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Stack<Integer> path = new Stack<>();
        Arrays.sort(nums); //排序

        dfs(nums, 0, path);
        return res;

    }

    private void dfs(int[] nums, int start, Stack<Integer> path){
        res.add(new ArrayList<>(path));
        for(int i=start; i<nums.length; i++){

            //和上个数字相等就跳过
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            path.push(nums[i]);
            dfs(nums, i+1, path);
            path.pop();
        }
    }
}
