package com.xu.leetcode.binarysearch;

/**
 * Created by sop on 2020/3/12.
 *  寻找旋转排序数组中的最小值
 *  数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 */
public class SearchRotatedMin_153 {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length -1;
        int min = Integer.MAX_VALUE;
        while(left <= right){
            int mid = left + (right - left)/2;

            if(nums[left] <= nums[mid]){
                min = Math.min(min, nums[left]);
                left = mid + 1;
            } else {
                min = Math.min(min, nums[mid]);
                right = mid -1;
            }

        }
        return min;
    }
}
