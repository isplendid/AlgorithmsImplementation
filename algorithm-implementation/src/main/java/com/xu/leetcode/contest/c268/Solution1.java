package com.xu.leetcode.contest.c268;

/**
 * @author xushichao
 * @date 2021/11/21 10:35 AM
 * @desc
 */
public class Solution1 {
    public int maxDistance(int[] colors) {
        int res = 0;
        for(int i=1; i<=colors.length-1; i++){
            for(int j=0; j<i; j++ ){
                if(colors[i] != colors[j]) {
                    res = Math.max(res, Math.abs(i-j));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,8,3,8,3};
        Solution1 solution1 = new Solution1();
        int res = solution1.maxDistance(arr);
        System.out.println(res);
    }
}
