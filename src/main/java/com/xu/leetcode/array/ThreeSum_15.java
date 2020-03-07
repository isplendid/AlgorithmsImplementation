package com.xu.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sop on 2020/3/1.
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],

 A solution set is:
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]
 *
 * a+b+c=0;
 *
 */
public class ThreeSum_15 {

    /***
     * Time: O(N*N)
     * @param nums
     * @return
     */
    List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<nums.length -2; i++){
            if(i==0 || i>0 && nums[i] != nums[i-1]){
                int lo = i+1, hi = nums.length -1, sum = 0 - nums[i];
                while(lo<hi){
                    if(nums[lo] + nums[hi] == sum){
                        res.add(Arrays.asList(nums[i],nums[lo], nums[hi]));
                        while(lo<hi && nums[lo] == nums[lo+1]) lo++;
                        while(lo<hi && nums[hi] == nums[hi-1]) hi--;
                        lo++;
                        hi--;
                    }else if(nums[lo] + nums[hi] < sum){
                        lo++;
                    } else {
                        hi--;
                    }
                }//while
            }
        }
        return res;
    }
}
