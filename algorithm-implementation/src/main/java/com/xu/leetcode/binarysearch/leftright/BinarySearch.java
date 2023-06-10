package com.xu.leetcode.binarysearch.leftright;

/**
 * @author xushichao
 * @date 2023/5/18 17:11
 * @desc
 */
public class BinarySearch {

    int leftBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 别返回，锁定左侧边界
                right = mid - 1;
            }
        }
        // 最后要检查 left 越界的情况 ， left超过数组最大值
        if (left >= nums.length || nums[left] != target)
            return -1;
        return left;
    }


    int rightBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 别返回，锁定右侧边界
                left = mid + 1;
            }
        }
        // 最后要检查 right 越界的情况, right <0 是 超过数组最小值
        if (right < 0 || nums[right] != target)
            return -1;
        return right;
    }

    public static void main(String[] args) {

        int[] nums = new int[] {1,2,3,3,3,3,9};
        int target = 0;

        BinarySearch search = new BinarySearch();
        search.rightBound(nums,target);

    }
}
