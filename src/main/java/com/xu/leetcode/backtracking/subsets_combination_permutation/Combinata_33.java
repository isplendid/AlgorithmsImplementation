package com.xu.leetcode.backtracking.subsets_combination_permutation;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *给定一个无重复元素的数组 candidates 和一个目标数 target ，
 * 找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 *   [7],
 *   [2,2,3]
 * ]
 *
 * Created by sop on 2020/08/2020/8/25 19:48
 *
 * @Description:
 */
public class Combinata_33 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<Integer> path = new ArrayList<>();
        backtrack(candidates, 0, target, path);
        return res;
    }

    private void backtrack(int[] candidates, int start, int target, List<Integer> path) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(path));
            return;
        } else if (target < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            path.add(candidates[i]);
            backtrack(candidates, i, target - candidates[i], path); // 调用i 而不是i+1, 包括了自己
            path.remove(path.size() - 1);
        }
    }



    public static void main(String[] args) {
        int[] candiates = new int[]{2, 3, 6, 7};
        int target = 7;
        Combinata_33 c = new Combinata_33();
        System.out.println(c.combinationSum(candiates, target));
    }

}
