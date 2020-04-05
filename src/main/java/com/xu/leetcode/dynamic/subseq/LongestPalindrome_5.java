package com.xu.leetcode.dynamic.subseq;

/**
 * Created by sop on 2020/3/14.
 * 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 */
public class LongestPalindrome_5 {
    public static  String longestPalindrome(String s) {

        int n = s.length();
        int[][] dp = new int[n][n];
        int max = 1;
        int maxI = 0;
        int maxJ = 0;
        for(int len=1; len<=n; len++){
            for(int i=0; i<=n-len; i++){
                int j= i+len-1;
                if(i==j) {
                    dp[i][j]=1;
                    continue;
                }
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] + 2;
                    if(dp[i][j] > max){
                        max = dp[i][j];
                        maxI = i;
                        maxJ = j;
                    }
                }
            }
        }
        return s.substring(maxI,maxJ+1);
    }

    public static void main(String[] args) {
        String str = "babad";
        System.out.println(longestPalindrome(str));

    }
}
