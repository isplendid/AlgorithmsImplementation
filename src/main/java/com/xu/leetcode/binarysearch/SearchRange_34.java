package com.xu.leetcode.binarysearch;

/**
 * Created by sop on 2020/3/11.
 * 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 你的算法时间复杂度必须是 O(log n) 级别。
 */
public class SearchRange_34 {


    /***
     * 时间: O(logN)
     * 空间：O(1)
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int[] ans = { -1, -1 };
        if (nums.length == 0) {
            return ans;
        }
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target == nums[mid]) {
                end = mid - 1;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        //考虑 tartget 是否存在，判断我们要找的值是否等于 target 并且是否越界
        if (start == nums.length || nums[ start ] != target) {
            return ans;
        } else {
            ans[0] = start;
        }
        ans[0] = start;
        start = 0;
        end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target == nums[mid]) {
                start = mid + 1;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        ans[1] = end;
        return ans;
    }


   public int[] searchRange_ON(int[] nums, int target){
       int[] res = {-1, -1};
       int n = nums.length;
       if(n == 0) return res;
       int left = 0;
       int right = n-1;
       while(left<=right){
           int mid = (right - left)/2 + left;
           if(nums[mid] == target){
               left = mid;
               right = mid;
               while(left > 0 && nums[left] == nums[left-1]) left--;
               while(right < n -1 && nums[right] == nums[right + 1]) right++;
               res[0] = left;
               res[1] = right;
               return res;
           } else if(nums[mid] > target){
               right = mid -1;
           }else if(nums[mid] < target){
               left = mid + 1;
           }
       }
       return res;
   }



}
