package com.xu.leetcode.slidingwindown;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sop on 2020/2/22.
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 * <p>
 * 示例：
 * <p>
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 。
 */
public class MinWindow_76 {

    /***
     * l, r 指针
     * HashMap<Character, Integer>, key: distinct char,  value: frequncy
     * minLen, startIndex 记录最左边指针
     * matchCount; 1->0  match one,  0->1 : need the match
     * Assumption: s and t are not null
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";
        //初始化map
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            int count = map.getOrDefault(t.charAt(i), 0);
            map.put(t.charAt(i), count + 1);
        }

        int l = 0, startIndex = 0, matchCount = 0, minLen = Integer.MAX_VALUE;
        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            Integer count = map.get(ch);
            if (count == null) {
                continue;
            }
            map.put(ch, count - 1);
            //match  the character
            if (count == 1) {
                matchCount++;
            }

            while(matchCount == map.size()){
                //find a valid substring
                int len = r-l+1;
                if(len < minLen){
                    minLen = len;
                    startIndex = l;
                }
                char leftMost = s.charAt(l++);
                Integer leftMostCount = map.get(leftMost);
                if(null == leftMostCount){
                    continue;
                }
                map.put(leftMost, leftMostCount+1);
                if(leftMostCount == 0){
                    //0 ->
                    matchCount--;
                }
            }

        }//for
       return minLen == Integer.MAX_VALUE ? "": s.substring(startIndex, startIndex + minLen);
    }

}
