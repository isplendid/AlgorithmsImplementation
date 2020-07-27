package com.xu.leetcode.dynamic.stringp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sop on 2020/7/9.
 */
public class RespaceBlank_17_13 {

    public int respace(String[] dictionary, String sentence) {

        Set<String> dict = new HashSet<>(Arrays.asList(dictionary));
        int n = sentence.length();
        int[] dp = new int[n + 1];  //dp代表 字符串 的前i的字符的 最少未匹配数
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int idx = 0; idx < i; idx++) {
                if (dict.contains(sentence.substring(idx, i))) {
                    dp[i] = Math.min(dp[i], dp[idx]);
                }
            }
        }
        return dp[n];
    }
}
