package com.xu.leetcode.backtracking.subsets_combination_permutation;

import com.xu.algs.basic.In;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author xushichao
 * @date 2022/10/30 17:12
 * @desc
 */
public class Permutation_duplicate_47 {

    List<List<Integer>> res = new ArrayList<>();
    boolean[] visited;
    public List<List<Integer>> permuteUnique(int[] nums) {
        visited = new boolean[nums.length];
        Arrays.sort(nums);
        Stack<Integer> stack = new Stack<>();
        dfs(nums,  stack);
        return res;
    }

    /***
     * 1, 1, 2
     * @param nums
     * @param path
     *
     * 排完序后，肯定是先访问的 [i-1] 再访问 [i], 如果 [i-1]没访问，先访问的i说明 重复访问了；
     * 比如排完序后： 1, 1', 2
     * 正常的话 访问 1，1';  如果访问到了1', 1 说明重复了， 可以continue
     */
    private void dfs(int[] nums,  Stack<Integer> path) {
        if (path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=0; i<nums.length; i++) {
            if(visited[i] || (i> 0 && nums[i-1] == nums[i] && !visited[i-1])){  //确保 1a 1b的顺序，只有前面的visit后才 visit后面相同的元素 （相当于去重）;
                continue;
            }
            visited[i]= true;
            path.push(nums[i]);
            dfs(nums, path);
            visited[i]= false;
            path.pop();
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        Permutation_duplicate_47 permu = new Permutation_duplicate_47();
        List<List<Integer>> res = permu.permuteUnique(nums);
        res.stream().forEach(System.out::println);
    }
}
