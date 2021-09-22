package com.xu.leetcode.dynamic.subseq;

import java.util.Arrays;

/**
 * @author xushichao
 * @date 2021/9/20 11:08 AM
 * @desc 最长递增子序列的个数
 */
public class FindNumberOfLIS_673 {
    /**
     * dp[i] 表示以 nums[i]结尾的最长上升子序列的长度，cnt[i]表示以nums[i]结尾的最长上升子序列的个数。
     * dp[i] = max(dp[i], dp[j] + 1), 0<=j<i 且 nums[j] < nums[i]
     * cnt[i] 等于所有满足dp[j] + 1 = dp[i] 之和
     * @param nums
     * @return
     */
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] cnt = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(cnt, 1);
        int res =1;
        int maxLength = 1;


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if(dp[j] + 1 > dp[i]) { //直接更新，重置计数
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                    } else if( dp[j] + 1 == dp[i]){ //说明找到了一个新的符合条件的前驱，此时将值继续累加到方案数当中
                        cnt[i] += cnt[j];
                    }
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        for(int i=0; i<n; i++) {
            if (dp[i] == maxLength) {
                res += cnt[i];
            }
        }

        return res;

    }

    public static void main(String[] args) {

        FindNumberOfLIS_673 find = new FindNumberOfLIS_673();
        int[] nums = new int[]{1, 3, 5,5, 4, 7,7};
        int[] nums2 = new int[]{1,2,4,3,5,4,7,2};

        int res = find.findNumberOfLIS(nums2);
        System.out.println(res);

    }
}
