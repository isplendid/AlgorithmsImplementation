package com.xu.leetcode.str.palindrome_214;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sop on 2020/3/14.
 * 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 */
public class LongestPalindrome_5 {

    /***
     *   扩展中心
     *
     *   时间复杂度：O(n²）
     *   空间复杂度：O(1）
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int len = 0;
        int start = 0;
        for (int i = 0; i < s.length(); ++i) {
            int cur = Math.max(getLen(s, i, i),  //奇数
                    getLen(s, i, i + 1)); //偶数
            if (cur > len) {
                len = cur;
                start = i - (cur - 1) / 2;    //len-1 为长度偶数和奇数区别
            }
        }
        return s.substring(start, start + len);
    }

    private int getLen(String s, int l, int r) {
        while (l >= 0 && r < s.length()
                && s.charAt(l) == s.charAt(r)) {
            --l;
            ++r;
        }
        return r - l - 1;  // r-l+1 -2, 回文长度
    }

    /**
     * 动态规划
     * 时间复杂度：不变 O(n²）
     * 空间复杂度： O(n²）
     * @param s
     * @return
     */
    public static String longestPalindrome_dp(String s) {
        int n = s.length();
        String res = "";
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                int len = j-i+1;
                dp[i][j] = s.charAt(i) == s.charAt(j) && (len ==1 || len==2 || dp[i + 1][j - 1]);
                if (dp[i][j] &&  len > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

    public String longestPalindrome7(String s) {
        int n = s.length();
        String res = "";
        boolean[] P = new boolean[n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= i; j--) {
                P[j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || P[j - 1]);
                if (P[j] && j - i + 1 > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }



    public static void main(String[] args) {
        String str = "babad";
        System.out.println(longestPalindrome_dp(str));
       Map<String, String> map = new HashMap<>();
    }
}
