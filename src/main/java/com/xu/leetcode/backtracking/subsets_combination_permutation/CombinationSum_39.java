package com.xu.leetcode.backtracking.subsets_combination_permutation;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by sop on 2020/5/30.
 *
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，
 * 找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 *
 * 所有数字（包括 target）都是正整数。
 解集不能包含重复的组合。
 */
public class CombinationSum_39 {

    private  List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Stack<Integer> path = new Stack<>();
        process(candidates, 0, target, path);
        return res;

    }

    private void process(int[] candidates, int start, int target, Stack<Integer> path){
        if(target < 0) {
            return;
        }
        if(target == 0){
            res.add(new ArrayList<Integer>(path));
        } else {
            for(int i= start; i<candidates.length; i++){
                path.push(candidates[i]);
                //注意：  因为每个数字都可以使用无数次，所以递归还可以从当前i元素开始, 而不是i+1
                process(candidates, i, target - candidates[i], path);
                path.pop();
            }
        }
    }
}
