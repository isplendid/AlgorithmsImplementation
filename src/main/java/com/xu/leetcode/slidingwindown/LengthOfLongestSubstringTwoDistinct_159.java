package com.xu.leetcode.slidingwindown;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sop on 2020/2/22.
 *
 * 给定一个字符串 s ，找出 至多 包含两个不同字符的最长子串 t 。
 示例 1:
 输入: "eceba"
 输出: 3
 解释: t 是 "ece"，长度为3。
 示例 2:
 输入: "ccaabbb"
 输出: 5
 解释: t 是 "aabbb"，长度为5。
 链接：https://leetcode-cn.com/problems/longest-substring-with-at-most-two-distinct-characters

 */
public class LengthOfLongestSubstringTwoDistinct_159 {

    /***
     * 解题思路
     * 1.为了遍历一遍就得到答案，我们使用一个左指针和一个右指针表示滑动窗口的边界。

     一开始，让两个指针都指向 0 ，当窗口包含的字符不超过 2 个不同的字符时，就不断将右指针往右边移动。
     如果在某一个位置有 3 个不同的字符，就开始移动左指针，直到窗口内包含不超过 2 个不同字符

     只有一个问题还没解决 - 如何移动左指针确保窗口内只有 2 种不同的字符？
     我们使用一个 hashmap ，把字符串里的字符都当做键，在窗口中的每个相同字符的最右边的字符位置作为值。每一个时刻，这个 hashmap 包括不超过 3 个元素。
     *
     *
     *
     现在我们可以写出如下算法：
     1）如果 N 的长度小于 3 ，返回 N 。
     2）将左右指针都初始化成字符串的左端点 left = 0 和 right = 0 ，且初始化最大子字符串为 max_len = 2
     3）当右指针小于 N 时：
     如果 hashmap 包含小于 3 个不同字符，那么将当前字符 s[right] 放到 hashmap 中并将右指针往右移动一次。
     如果 hashmap 包含 3 个不同字符，将最左边的字符从 哈希表中删去，并移动左指针，以便滑动窗口只包含 2 个不同的字符。
     更新 max_len
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int n  = s.length();
        if(n<3) return n;
        //sliding window left and right pointers
        int left =0;
        int right =0;
        //hashmap character ->its rightmost position
        Map<Character, Integer> map = new HashMap<>();
        int maxLen =2;
        while(right < n){
            //slide window contains less than 3 characters
            if(map.size() < 3){
                map.put(s.charAt(right), right++);
            }
            //slide window contains 3 characters
            if(map.size() == 3){
                //delete the leftmost character
                int deleteIndex = Collections.min(map.values());
                map.remove(s.charAt(deleteIndex));
                left = deleteIndex + 1;
            }
            maxLen = Math.max(maxLen, right - left); //right++了

        }
        return maxLen;
    }
}
