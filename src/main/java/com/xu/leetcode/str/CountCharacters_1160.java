package com.xu.leetcode.str;

import java.util.Arrays;

/**
 * Created by sop on 2020/3/17.
 *
 * . 拼写单词
 * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 * 输入：words = ["cat","bt","hat","tree"], chars = "atach"
 * 可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
 */
public class CountCharacters_1160 {
    public static int countCharacters(String[] words, String chars) {
        int[] arr = new int[26];
        for(int i=0; i<chars.length();i++){
            arr[chars.charAt(i) - 'a']++;
        }

        int sum=0;
        for(String word: words){
            int[] temp = Arrays.copyOf(arr,26);
            int j=0;
            for(; j<word.length(); j++){
                if(--temp[word.charAt(j) -'a'] <0){
                    break;
                }
            }
            if(j==word.length()){
                sum += word.length();
            }

        }
        return sum;
    }

    public static void main(String[] args) {
        String[] word = new String[]{"cat","bt","hat","tree"};
        String chars = "atach";
        System.out.println(countCharacters(word, chars));
     }

}
