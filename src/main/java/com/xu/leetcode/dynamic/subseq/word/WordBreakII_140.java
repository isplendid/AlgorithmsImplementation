package com.xu.leetcode.dynamic.subseq.word;

import java.util.*;

/**
 * Created by sop on 2020/5/30.
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，
 * 使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 说明：
 分隔时可以重复使用字典中的单词。
 你可以假设字典中没有重复的单词
 链接：https://leetcode-cn.com/problems/word-break-ii

 */
public class WordBreakII_140{

    Map<Integer, List<String>> memo = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        return wordBreak2(s, wordDict, 0);
    }

    private List<String> wordBreak2(String s, List<String> wordDict, int start){
        if(memo.containsKey(start)){
            return memo.get(start);
        }
        List<String> res = new ArrayList<>();
        if(start == s.length()){
            res.add("");
        }
        for(int end = start +1; end <= s.length() ; end++){
            if(wordDict.contains(s.substring(start, end))){
                List<String> list = wordBreak2(s, wordDict, end);
                for(String l: list){
                    res.add(s.substring(start, end) + (l.equals("") ? "" : " ") + l);
                }
            }
        }
        memo.put(start, res);
        return res;
    }

    public static void main(String[] args) {
        String s = "pineapplepenapple";
        List<String> wordDict = new ArrayList<>(Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"));
        WordBreakII_140 w = new WordBreakII_140();
        System.out.println(w.wordBreak(s, wordDict));
    }
}
