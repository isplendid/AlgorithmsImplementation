package com.xu.leetcode.dynamic.subseq;

/**
 * Created by sop on 2020/3/14.
 *
 * 给定一个字符串s，找到其中最长的回文子序列。可以假设s的最大长度为1000。
 * "bbbab"
 * 一个可能的最长回文子序列为 "bbbb"。
 *
 * 对角遍历/从后向前遍历
 */
public class LongestPalindromeSubseq_516 {


    public static int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for(int len = 1; len <=n; len++){
           for(int i=0; i<= n-len; i++){
               int j= i+len -1;
               if(i==j) {
                   dp[i][j]=1;
                   continue;
               }
               if(s.charAt(i) == s.charAt(j)) {
                   dp[i][j] = dp[i+1][j-1] + 2;
               }else {
                   dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
               }
           }
        }
        return dp[0][n-1];
   }

    //反向遍历数组
    int longestPalindromeSubseq_Res(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++){
            dp[i][i] = 1;
        }
        for(int i = n-1; i>=0; i--){
            for(int j=i+1; j<n; j++){
                if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                }else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        //整个 s 的最长回文子串长度
        return dp[0][n-1];
    }

    public static void main(String[] args) {
        String str= "bbbab";
        System.out.println(longestPalindromeSubseq(str));
    }
}
