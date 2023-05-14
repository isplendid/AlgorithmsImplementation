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
 * 简单一句话，先固定第一个数a，然后b、c只能从两边向中间靠（在a之后）。  细节条件就是去重处理
 *
 * 双重循环  第一层： i=>[0, n-1]
 * 第二层： lo = i+1,  hi = n-1;
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
            if(i==0 || i>0 && nums[i] != nums[i-1]){   // 目的处理第一层循环a 跳过重复值
                int lo = i+1, hi = nums.length -1, sum = 0 - nums[i];
                while(lo<hi){
                    if(nums[lo] + nums[hi] == sum){
                        res.add(Arrays.asList(nums[i],nums[lo], nums[hi]));
                        while(lo<hi && nums[lo] == nums[lo+1]) lo++;   //去重
                        while(lo<hi && nums[hi] == nums[hi-1]) hi--;  //去重
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
