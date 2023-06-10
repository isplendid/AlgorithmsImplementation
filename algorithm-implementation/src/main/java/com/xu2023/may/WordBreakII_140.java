package com.xu2023.may;


import java.util.*;

/**
 * @author xushichao
 * @date 2023/5/22 11:23
 * @desc
 *
 * leetcode
 * idx =0;
 * l
 *   n!
 */
public class WordBreakII_140 {

    private List<String> res = new ArrayList<>();
    public  List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);

        Stack<String> path = new Stack<>();
        dfs(s, 0, set, path);
        return res;
    }

    private void dfs(String s, int idx,  Set<String> set,  Stack<String> path) {
        if(idx == s.length()) {
            res.add(String.join(" ", path));
            return;
        }
        for(int i =idx; i<s.length(); i++) {
            String sub = s.substring(idx, i + 1);
            if(set.contains(sub)){
                path.push(sub);
                dfs(s, i + 1, set, path);
                path.pop();
            }

        }
    }




    public static void main(String[] args) {
        WordBreakII_140 wordBreakII_140 = new WordBreakII_140();
        String s = "catsanddog";
        List<String> wordDict = Arrays.asList("cat","cats","and","sand","dog");
        //"cats and dog","cat sand dog"

        List<String> strings = wordBreakII_140.wordBreak(s, wordDict);
        System.out.println(strings);

    }


}
