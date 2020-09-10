package com.xu.leetcode.contest.c200;

import javafx.util.Pair;

import java.util.HashMap;

/**
 * Created by sop on 2020/6/21.
 */
public class Test1 {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
       if(arr.length<=2) return 0;
        int res =0;
        for(int i=0; i<arr.length-2; i++){
            for(int j=i+1; j<arr.length-1; j++) {
                for(int k=j+1; k<arr.length; k++){
                    if(Math.abs(arr[i]-arr[j]) <= a && Math.abs(arr[j] - arr[k]) <= b &&
                            Math.abs(arr[i] - arr[k])<=c) {
                        //System.out.println("i: "+i +", j: "+j+", k: "+k);
                        res ++;
                    }
                }
            }
        }
        return res;
    }



    public static void main(String[] args) {
       int[] arr = new int[]{1,1,2,2,3};
       int a = 0, b = 0, c = 1;
        Test1 t= new Test1();
        System.out.println(t.countGoodTriplets(arr, a, b, c));

    }
}
