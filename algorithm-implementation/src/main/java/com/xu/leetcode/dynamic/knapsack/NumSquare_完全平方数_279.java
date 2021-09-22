package com.xu.leetcode.dynamic.knapsack;

import java.util.Arrays;

/**
 * @author xushichao
 * @date 2021/9/21 10:20 AM
 * <p>
 * 0-1背包问题
 * @desc 求完全平方数的最小数量
 * 类似于 零钱兑换
 */
public class NumSquare_完全平方数_279 {


    /**
     * 参考零钱兑换的解法：给你 k 种面值的硬币，面值分别为 c1, c2 ... ck，每种硬币的数量无限，再给一个总金额 amount，问你最少需要几枚硬币凑出这个金额，如果不可能凑出，算法返回 -1
     * <p>
     * 时间复杂度： n* sqrt(n)
     * 空间复杂度： n
     *
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int m = 100;
        int[] nums = new int[m];
        for (int i = 0; i < m; i++) {
            nums[i] = (i + 1) * (i + 1);
        }

        int[] dp = new int[n + 1];
        //数组大小为n+1, 初始化为n+1;
        Arrays.fill(dp, n + 1);
        dp[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            //内层for 循环 nums的值选择
            for (int j = 0; j < m; j++) {
                if (i - nums[j] < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - nums[j]]);
            }
        }

        return (dp[n] == n + 1) ? -1 : dp[n];


    }

    public static void main(String[] args) {
        NumSquare_完全平方数_279 solution = new NumSquare_完全平方数_279();
        int n = 13;
        int res = solution.numSquares(n);
        System.out.println(res);

    }
}
