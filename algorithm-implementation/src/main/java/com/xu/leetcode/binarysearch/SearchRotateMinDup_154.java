package com.xu.leetcode.binarysearch;

/**
 * Created by sop on 2020/3/12.
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。

 ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 请找出其中最小的元素。
 注意数组中可能存在重复的元素。
 */
public class SearchRotateMinDup_154 {
    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length -1;
        int min = Integer.MAX_VALUE;
        while(left <= right){
            int mid = left + (right - left)/2;

            if(nums[left] < nums[mid]){
                min = Math.min(min, nums[left]);
                left = mid + 1;
            } else if(nums[left] == nums[mid]){
                min = Math.min(min, nums[left]);
                left++;

            }else {
                min = Math.min(min, nums[mid]);
                right = mid -1;
            }
        }
        return min;

    }
}
