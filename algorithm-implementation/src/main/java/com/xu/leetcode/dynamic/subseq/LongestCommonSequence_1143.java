package com.xu.leetcode.dynamic.subseq;

/**
 * Created by sop on 2020/3/10.
 *
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列。
 * 输入：text1 = "abcde", text2 = "ace"
 * 解释：最长公共子序列是 "ace"，它的长度为 3。
 *
 * https://labuladong.gitbook.io/algo/dong-tai-gui-hua-xi-lie/zui-chang-gong-gong-zi-xu-lie
 */
public class LongestCommonSequence_1143 {
    public  static int longestCommonSubsequence(String text1, String text2) {
        int m= text1.length();
        int n= text2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0; i<m+1; i++){
            dp[i][0] = 0; //第0列初始化为0;
        }
        for(int j=0; j<n+1; j++){
            dp[0][j] = 0; //第0行初始化为0;
        }
        for(int i=1; i<m+1; i++){
            for(int j=1; j<n+1; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1]+1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String str1="abc";
        String str2="edf";
        int res = longestCommonSubsequence(str1, str2);
        System.out.println(res);

    }
}
