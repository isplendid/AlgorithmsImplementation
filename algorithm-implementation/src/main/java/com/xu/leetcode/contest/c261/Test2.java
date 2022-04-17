package com.xu.leetcode.contest.c261;

import java.util.Arrays;

/**
 * @author xushichao
 * @date 2021/10/3 10:27 AM
 * @desc
 */
public class Test2 {

    public int[] missingRolls(int[] rolls, int mean, int n) {
        int lm = rolls.length;
        int sumM = Arrays.stream(rolls).sum();
        int len = lm + n;
        int sum = mean * len;
        int sumN = sum - sumM;
        if(sumN < n*1 || sumN > n*6){
            return new int[0];
        }
        int[] res = new int[n];
        //sumN分配个n个元素
        int val = sumN / n;
        int left = sumN % n;
        int minus1 = 0;
        for(int i=0; i<n; i++){
            if(minus1<left) {
                res[i] = val+1;
                minus1++;
            } else {
                res[i] = val;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        int[] rolls = new int[]{1};
        int mean =3 ;
        int n = 1;
        int[] res = test2.missingRolls(rolls, mean, n);
        Arrays.stream(res).forEach(System.out::println);

    }
}
