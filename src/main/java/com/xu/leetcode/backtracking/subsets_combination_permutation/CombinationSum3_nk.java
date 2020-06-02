package com.xu.leetcode.backtracking.subsets_combination_permutation;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by sop on 2020/5/30.
 *
 *  找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，
 *  并且每种组合中不存在重复的数字。
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 *
 */
public class CombinationSum3_nk {

    private  List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        Stack<Integer> path = new Stack<>();
        process(k,n,1, path);
        return res;
    }

    private void process(int k, int n, int start, Stack<Integer> path){
        if(n<0 || path.size() > k){
            return;
        }
        if(path.size() == k && n==0){
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for(int i=start; i<=9; i++){
            path.push(i);
            process(k, n-i, i+1, path);
            path.pop();
        }
    }
}
