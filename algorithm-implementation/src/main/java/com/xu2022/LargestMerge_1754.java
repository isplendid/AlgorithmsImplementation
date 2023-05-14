package com.xu2022;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xushichao
 * @date 2022/12/24 20:12
 * @desc
 * 时间： O(N平方）
 *
 * 空间： O(N)
 */
public class LargestMerge_1754 {
    public String largestMerge(String w1, String w2) {
        StringBuilder sb = new StringBuilder();
        while(w1.length() + w2.length() > 0) {
            if(w1.compareTo(w2) > 0) {
                sb.append(w1.charAt(0));
                w1=w1.substring(1);
            } else {
                sb.append(w2.charAt(0));
                w2 = w2.substring(1);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String word1 = "cabaa";
        String word2 = "bcaaa";
        LargestMerge_1754 merge_1754 = new LargestMerge_1754();
        String res = merge_1754.largestMerge(word1, word2);
        System.out.println(res);
        Map<String, List<Integer>> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

    }

}
