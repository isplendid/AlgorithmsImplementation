package com.xu.leetcode.contest.month8;

/**
 * @author xushichao
 * @date 2021/8/20 8:26 AM
 * @desc
 */
public class ReverseStr_541 {

    /**
     * 简洁版: 精髓在于 reverse arr (i, Math.min(i+k,n)-1)
     * 反转每个下标从 2k的倍数开始的，长度为 k 的子串。若该子串长度不足 k，则反转整个子串。
     * @param s
     * @param k
     * @return
     */
    public String reverseStr_opt(String s, int k) {
        int n = s.length();
        char[] arr = s.toCharArray();
        for (int i = 0; i < n; i += 2 * k) {
            reverseString(arr, i, Math.min(i + k, n) - 1);
        }
        return new String(arr);
    }


    /**
     * my self method
     * @param s
     * @param k
     * @return
     */
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int len = arr.length;

        int k2Num = len / (2 * k);
        int remainder = len % (2 * k);
        if (k2Num < 1) {
            if (len >= k) {
                reverseString(arr, 0, k - 1);
            } else {
                reverseString(arr, 0, len - 1);
            }
        } else {
            for (int i = 0; i < k2Num; i++) {
                reverseString(arr, i * 2 * k, i * 2 * k + k - 1);
            }
            if (remainder >= k) {
                reverseString(arr, k2Num * 2 * k, k2Num * 2 * k + k - 1);
            } else {
                reverseString(arr, k2Num * 2 * k, k2Num * 2 * k + remainder - 1);
            }

        }
        return new String(arr);

    }


    /***
     * 翻转数组
     * @param s
     * @param l
     * @param r
     */
    public void reverseString(char[] s, int l, int r) {
       while(l<r) {
           char temp = s[l];
           s[l] = s[r];
           s[r] = temp;
           l++;
           r--;
       }
    }

    private void swap(char[] s, int l, int r) {
        if (l >= r) {
            return;
        }
        char temp = s[l];
        s[l] = s[r];
        s[r] = temp;
    }

    public static void main(String[] args) {
        ReverseStr_541 reverseStr541 = new ReverseStr_541();
        String s = "abcd";
        int k = 2;
        System.out.println(reverseStr541.reverseStr(s, k));
//        char[] arr = new char[]{'a','b','c','d'};
//        reverseStr541.reverseString(arr, 0,2);
//        System.out.println(new String(arr));
    }
}
