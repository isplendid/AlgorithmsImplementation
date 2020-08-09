package com.xu.leetcode.contest.c201;

import com.xu.leetcode.contest.Test;

/**
 * Created by sop on 2020/8/9.
 */
public class Test1 {

    public int minFlipsMonoIncr(String S) {

        int n = S.length();
        if(n==0) return 0;

        int[] l = new int[n];
        int[] r = new int[n];


        l[0] = S.charAt(0) - '0';
        r[n-1]= '1' - S.charAt(n-1);
        for(int i=1; i<n; i++){ //变成0
            l[i] = l[i-1] +  S.charAt(i) -'0';
        }
        for(int i=n-2; i>=0; i--){ //变成1
            r[i] = r[i+1] + '1' - S.charAt(i);
        }

        int res = r[0];
        for(int i=1; i<n; i++){
            res = Math.min(res,  l[i-1] + r[i]);
        }
        res = Math.min(res, l[n-1]);

        return res;


    }

    public static void main(String[] args) {
        String str = "0101100011";
        Test1 t = new Test1();
        System.out.println(t.minFlipsMonoIncr(str));

    }

}
