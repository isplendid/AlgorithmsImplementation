package com.xu.leetcode.dynamic.swap;

/**
 * Created by sop on 2020/8/9.
 */
public class MinSwap_801 {
    public int minSwap(int[] A, int[] B) {


        int[][] dp = new int[A.length][2];
        dp[0][0] = 0;
        dp[0][1] = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1] && B[i] > B[i - 1]) {
                if (B[i] > A[i - 1] && A[i] > B[i - 1]) {
                    dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]);
                    dp[i][1] = Math.min(dp[i - 1][1] + 1, dp[i - 1][0] + 1);
                } else {
                    dp[i][0] = dp[i - 1][0];
                    dp[i][1] = dp[i - 1][1] + 1;
                }
            } else {
                dp[i][0] = dp[i-1][1];// 不交换，则上个位置必须交换
                dp[i][1] = dp[i-1][0]+1;// 交换，则上个位置不能交换
            }
        }
        return Math.min(dp[A.length - 1][0], dp[A.length-1][1]);
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{3,3,8,9,10};
        int[] arr2 = new int[]{1,7,4,6,8};

        MinSwap_801 t = new MinSwap_801();
        System.out.println(t.minSwap(arr1,arr2));

    }
}
