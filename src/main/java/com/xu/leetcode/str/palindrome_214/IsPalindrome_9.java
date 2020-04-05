package com.xu.leetcode.str.palindrome_214;

/**
 * Created by sop on 2020/3/14.
 *
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数
 * 输入: 121  输出: true
 * 输入: -121  输出: false
 */
public class IsPalindrome_9 {

    //通过取整和取余操作获取整数中对应的数字进行比较。

    /***
     * 举个例子：1221 这个数字。

     通过计算 1221 / 1000， 得首位1
     通过计算 1221 % 10， 可得末位 1
     进行比较
     再将 22 取出来继续比较
     * @param x
     * @return
     */

    public boolean isPalindrome_int(int x) {
        //边界判断
        if (x < 0) return false;
        int div = 1;
        //
        while (x / div >= 10) div *= 10;
        while (x > 0) {
            int left = x / div;
            int right = x % 10;
            if (left != right) return false;
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }


    //转为字符串
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        String s = String.valueOf(x);
        return isPalindrome(s);

    }
    boolean isPalindrome(String s){
        int l=0;
        int r=s.length()-1;

        while(l<r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
