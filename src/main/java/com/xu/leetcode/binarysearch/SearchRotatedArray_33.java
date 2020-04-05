package com.xu.leetcode.binarysearch;

/**
 * Created by sop on 2020/3/12.
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 算法基于一个事实，数组从任意位置劈开后，至少有一半是有序的，什么意思呢？
 比如 [ 4 5 6 7 1 2 3] ，从 7 劈开，左边是 [ 4 5 6 7] 右边是 [ 1 2 3]，左边是有序的。

 基于这个事实。
 我们可以先找到哪一段是有序的 (只要判断端点即可)，然后看 target 在不在这一段里，如果在，那么就把另一半丢弃。如果不在，那么就把这一段丢弃。
 */
public class SearchRotatedArray_33 {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            //左半段是有序的
            if (nums[start] <= nums[mid]) {
                //target 在这段里
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
                //右半段是有序的
            } else {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

        }
        return -1;
    }

}
