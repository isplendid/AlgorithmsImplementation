package com.xu.leetcode.dynamic;

import java.util.Arrays;

/**
 * Created by sop on 2020/7/7.
 * 698. 划分为k个相等的子集
 * 给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 */
public class CanPartitionKSubsets_698 {
    public static boolean canPartitionKSubsets(int[] nums, int k) {

//        Arrays.sort(nums); //从小到大
//        long sum=0;
//        for(int n:nums){
//            sum +=n;
//        }
//        if(sum % k !=0 ){
//            return false;
//        }
//        long every =  (sum / k);
         return false;


    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 3, 2, 3, 5, 2, 1};
        int k = 4;

        System.out.println(canPartitionKSubsets(arr,k));

    }
}
