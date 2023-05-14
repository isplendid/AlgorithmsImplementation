package com.xu2023.april;

import java.util.*;

/**
 * @author xushichao
 * @date 2023/4/27 21:44
 * @desc
 * N和M分别为words的长度和 每个单词的平均长度
 *
 * 1)数组的排序时间复杂度 NlogN
 * 每个字符串的平均长度M
 * 排序字符串数组时间复杂度：M * N* logN
 * 2)遍历每个字符串，生成前身字符串
 *
 * N * M *M ( substring也需要 ）
 * O (N * M *  (logN + M)
 *
 *
 * 空间O（N*M)
 * 时间复杂度:  O(N * M (logN + M) )
 * 空间：O(N *M)
 */
public class LongestStrChain_1048 {

    public int longestStrChain(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        //每个字符串的最长字符串链长度。
        Map<String, Integer> map = new HashMap<>();
        int ans = 0;

        for(String word:words) {
            int maxLength = 0;
            for(int i=0; i<word.length(); i++){
                String sub = word.substring(0,i) + word.substring(i+1);
                maxLength = Math.max(map.getOrDefault(sub, 0) + 1, maxLength);
            }
            map.put(word, maxLength);
            ans = Math.max(ans, maxLength);
        }

       return ans;
    }

    public static void main(String[] args) {
        LongestStrChain_1048 strChain_1048 = new LongestStrChain_1048();

        String[] words =  {"xbc","pcxbcf","xb","cxbc","pcxbc"};

        int res = strChain_1048.longestStrChain(words);;
        System.out.println(res);

    }
}
