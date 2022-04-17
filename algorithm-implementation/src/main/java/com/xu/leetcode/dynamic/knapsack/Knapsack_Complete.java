package com.xu.leetcode.dynamic.knapsack;

/**
 * @author xushichao
 * @date 2021/10/4 5:28 PM
 * @desc 完全背包问题
 * 1) LeetCode_322 零钱兑换问题
 */
public class Knapsack_Complete {

    /***
     * 完全背包最值问题 ,外循环coin,内循环amount也可以
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i < amount + 1; i++) {
            //为了最后判断是否能填满amount
            dp[i] = amount + 1;
        }
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];

    }

}
