package com.xu.leetcode.slidingwindown;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sop on 2020/2/19.
 *
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/wu-zhong-fu-zi-fu-de-zui-chang-zi-chuan-by-leetcod/
 * 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

 示例 1:

 输入: "abcabcbb"
 输出: 3
 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestSubString_3 {

    /***
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int res =0;
        int[] index = new int[128]; //current index of character
        //try to extend the range of range(i,j)
        for(int j=0, i=0; j<n; j++){
            i = Math.max(i, index[s.charAt(j)] +1);
            res = Math.max(res, j-i +1);
            index[s.charAt(j)] = j;
        }
        return res;
    }

    /***
     * i: points to the left of same character last found
     * j: scan the string
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstringMap(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)) + 1, i);  //the same element +1,the left pointer move forward;
            }
            ans = Math.max(ans, j - i + 1);
           // map.put(s.charAt(j), j + 1);
            map.put(s.charAt(j), j);
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "abcabcbb";
        int res = lengthOfLongestSubstringMap(str);
        System.out.println(res);
    }

}
