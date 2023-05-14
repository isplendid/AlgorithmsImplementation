package com.xu.leetcode.backtracking.subsets_combination_permutation;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author xushichao
 * @date 2022/10/30 21:58
 * @desc
 *
 * Time Complexity
 * Space Complexity
 */
public class Permutation_46_2 {

    List<List<Integer>> res = new ArrayList<>();
    /***
     * 标记是否访问过，比 contains的时间复杂度低
     */
    boolean[] visited;

    public List<List<Integer>> permute(int[] nums) {
        visited = new boolean[nums.length];
        Stack<Integer> path = new Stack<Integer>();
        backtrack(nums, path);
        return res;
    }

    // 路径：记录在 path 中
    // 选择列表：nums 中不存在于 path 的那些元素
    // 结束条件：nums 中的元素全都在 path 中出现
    private void backtrack(int[] nums, Stack<Integer> path) {
        //触发结束条件
        if (path.size() == nums.length) {
            res.add(new ArrayList(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //排除不合法的选择
            if (visited[i]) {
                continue;
            }
            //做选择
            path.push(nums[i]);
            visited[i] = true;

            //进入下一层决策树
            backtrack(nums, path);
            //取消选择
            path.pop();
            visited[i] = false;
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        Permutation_46_2 permu = new Permutation_46_2();
        List<List<Integer>> res = permu.permute(nums);
        res.stream().forEach(System.out::println);
    }

}
