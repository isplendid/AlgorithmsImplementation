package com.xu.leetcode.contest.c256;

import com.mashibing.juc.c_001.T;

import java.util.Arrays;

/**
 * @author xushichao
 * @date 2021/8/29 10:24 AM
 * @desc
 */
public class Test1 {

    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for(int i=0; i<=nums.length -k ; i++){
            min = Math.min(min, nums[i+k-1] - nums[i]);
        }
        return min;
    }


    public static void main(String[] args) {
        Test1 test1 = new Test1();
        int[] nums = new int[]{9,4,1,7};
        int k =2;
        int[] nums2 = new int[90];
        int k2 = 1;
        int res = test1.minimumDifference(nums2,k2);
        System.out.println(res);

    }
}
