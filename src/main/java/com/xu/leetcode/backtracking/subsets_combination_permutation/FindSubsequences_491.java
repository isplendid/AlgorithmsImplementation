package com.xu.leetcode.backtracking.subsets_combination_permutation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sop on 2020/08/2020/8/25 21:22
 *
 * @Description:
 */
public class FindSubsequences_491 {
    List<List<Integer>> res =new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<Integer> path = new ArrayList<>();
        backtrack(nums,0,path);
        return res;
    }

    private void backtrack(int[] nums, int start, List<Integer> path){
        if(path.size() >=2 ){
            res.add(new ArrayList<Integer>(path));
        }
        for(int i=start; i<nums.length; i++){
            path.add(nums[start]);
            if (i > start && nums[i] >= nums[i - 1]) {
                path.add(nums[i]);
            }

            backtrack(nums, i+1, path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 6, 7, 7};
        FindSubsequences_491 fnd = new FindSubsequences_491();
        System.out.println(fnd.findSubsequences(nums));
        // 正确答案： [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
    }
}
