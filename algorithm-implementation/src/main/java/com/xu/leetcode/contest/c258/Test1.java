package com.xu.leetcode.contest.c258;

/**
 * @author xushichao
 * @date 2021/9/12 10:44 AM
 * @desc
 */
public class Test1 {

    public String reversePrefix(String word, char ch) {
       char[] chars = word.toCharArray();
       int idx = 0;

       for( idx=0; idx<chars.length; idx++){
           if(chars[idx] == ch) {
               break;
           }
       }
       if(idx < word.length()){
           reverse(chars, 0, idx);
       }
       return new String(chars);
    }
    private void reverse(char[] chs, int l, int r) {
        while(l <= r) {
            char temp = chs[l];
            chs[l] = chs[r];
            chs[r] = temp;
            l++;
            r--;
        }
    }
    public static void main(String[] args) {
      String   word = "abcd";
        char ch = 'z';
        Test1 test1 = new Test1();
        System.out.println(test1.reversePrefix(word, ch));
    }
}
