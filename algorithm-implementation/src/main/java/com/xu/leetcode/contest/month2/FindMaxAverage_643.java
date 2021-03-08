package com.xu.leetcode.contest.month2;

/**
 * @author xushichao
 * @date 2021/2/4 10:48 PM
 * @desc
 */
public class FindMaxAverage_643 {
    public static double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;
        for (int i = k; i < n; i++) {
            sum = sum - nums[i - k] + nums[i];
            maxSum = Math.max(maxSum, sum);
        }
        return 1.0 * maxSum / k;
    }

    public static void main(String[] args) {
        int[] nums = {5};
        int k = 1;
        System.out.println(findMaxAverage(nums,k));

    }
}
