package com.xu.leetcode.bits;

/**
 * @author xushichao
 * @date 2022/4/17 6:23 PM
 * @desc
 */
public class MaxProduct_Bit_318 {
    public int maxProduct(String[] words) {
        int n = words.length;
        // 将字符串转换为bit数组
        int[] bits = new int[n];
        for(int i=0; i<n; i++){
            String word = words[i];
            for (int j = 0; j <word.length(); j++) {
                bits[i] |=  1 << (word.charAt(j) - 'a');
            }
        }
        //双重for循环找到最大
        int res =0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if((bits[i] & bits[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }

        }

       return res;
    }

    public static void main(String[] args) {

    }

}
