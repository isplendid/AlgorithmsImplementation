package com.xu.leetcode.contest.c194;

import java.util.Arrays;

/**
 * Created by sop on 2020/6/21.
 */
public class Test3 {
    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n= mat[0].length;
        int[][] dp = new int[m][n];   //f[i][j] 表示以 (i, j) 为右下角的正方形的最大边长,
        //我们只需记录以(i, j)为右下角的区域包含的最大全1正方形边长即可，这个最大边长也即以(i , j)为右下角的全1正方形的个数
        int res =0;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == 0 || j == 0) {
                    dp[i][j] = mat[i][j];
                }
                else if (mat[i][j] == 0) {
                    dp[i][j] = 0;
                }
                else {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                }
                res += dp[i][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7,7,7,7,12,7,7};

        int[] ar = new int[0];
        Arrays.sort(ar);
        //Test3 t = new Test3();

    }
}
