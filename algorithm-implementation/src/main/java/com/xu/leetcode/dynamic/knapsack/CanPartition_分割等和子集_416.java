package com.xu.leetcode.dynamic.knapsack;

import java.util.Arrays;

/**
 * @author xushichao
 * @date 2021/9/21 10:51 AM
 * @desc
 */
public class CanPartition_分割等和子集_416 {


    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) {
            return false;
        }
        return canPart(nums, sum / 2);
    }

    /**
     * 状态压缩处理： dp[i][j] 都是通过上一行 dp[i-1][..] 转移过来的；可以进行状态压缩，将二维 dp 数组压缩为一维，节约空间复杂度
     * @param nums
     * @param sum
     * @return
     */
    private boolean canPart_compress(int[] nums, int sum) {
        boolean[] dp = new boolean[sum+1];
        Arrays.fill(dp,false);
        // base case
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = sum; j >= 0; j--) {
                if (j - nums[i] >= 0) {
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
            }
        }
        return dp[sum];
    }


        private boolean canPart(int[] nums, int sum) {
        //base case: 因为背包没有空间的时候，就相当于装满了，而当没有物品可选择的时候，肯定没办法装满背包
        boolean[][] dp = new boolean[nums.length + 1][sum + 1];
        Arrays.fill(dp[0], false);
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }
        //nums数组索引
        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (j - nums[i - 1] < 0) {
                    // 背包容量不足，不能装入第 i 个物品
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 装入或不装入背包
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[nums.length][sum];

    }

    public static void main(String[] args) {
        CanPartition_分割等和子集_416 solution = new CanPartition_分割等和子集_416();
        int[] nums = new int[]{1, 5, 11, 5, 12};
        System.out.println(solution.canPartition(nums));

    }
}
