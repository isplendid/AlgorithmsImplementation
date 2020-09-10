package com.xu.leetcode.slidingwindown;

import java.util.Collections;
import java.util.HashMap;

/**
 * Created by sop on 2020/2/22.
 *  至多包含 K 个不同字符的最长子串
 *  给定一个字符串 s ，找出 至多 包含 k 个不同字符的最长子串 T。
 示例 1:
 输入: s = "eceba", k = 2
 输出: 3
 解释: 则 T 为 "ece"，所以长度为 3。
 链接：https://leetcode-cn.com/problems/longest-substring-with-at-most-k-distinct-characters
 */
public class LengthOfLongestSubstringKDistinct_340 {
    /***
     * 滑动窗口+hashmap
     * 我们可以使用一个哈希表，建立从字符到滑动窗口最右出现位置的映射，在任意时刻，哈希表不能包含 k+1 个元素。
     *
     *
     * @param s
     * @param k
     * @return
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length();
        if (n*k == 0) return 0;

        // sliding window left and right pointers
        int left = 0;
        int right = 0;
        // hashmap character -> its rightmost position
        // in the sliding window
        HashMap<Character, Integer> hashmap = new HashMap<Character, Integer>();
        int max_len = 1;

        while (right < n) {
            // add new character and move right pointer
            hashmap.put(s.charAt(right), right++);

            // slidewindow contains k characters
            if (hashmap.size() == k + 1) {
                // delete the leftmost character
                int del_idx = Collections.min(hashmap.values());
                hashmap.remove(s.charAt(del_idx));
                // move left pointer of the slidewindow
                left = del_idx + 1;
            }

            max_len = Math.max(max_len, right - left);
        }
        return max_len;
    }
}
