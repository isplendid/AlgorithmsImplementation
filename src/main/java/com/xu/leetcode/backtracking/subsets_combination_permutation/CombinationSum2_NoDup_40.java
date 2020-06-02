package com.xu.leetcode.backtracking.subsets_combination_permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by sop on 2020/5/30.
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *  (元素有重复，且元素只能使用一次)
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 *
 * 所求解集为:
 [
 [1, 7],
 [1, 2, 5],
 [2, 6],
 [1, 1, 6]
 ]
 *
 * */
public class CombinationSum2_NoDup_40 {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Stack<Integer> path = new Stack<>();
        Arrays.sort(candidates);
        process(candidates,0, target, path);
        return res;
    }

    private void process(int[] candidates, int start, int target, Stack<Integer> path){
        if(target <0) {
            return;
        }
        if(target == 0){
            res.add(new ArrayList<Integer>(path));
        }else {

            for(int i=start; i<candidates.length; i++){
                if(i>start && candidates[i] == candidates[i-1]){  //判断重复
                    continue;
                }
                path.push(candidates[i]);
                process(candidates, i+1, target - candidates[i], path); //只能从下一个元素开始，不能再重复使用本元素
                path.pop();
            }

        }
    }
}
