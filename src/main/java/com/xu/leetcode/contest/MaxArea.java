package com.xu.leetcode.contest;

import java.util.Arrays;

/**
 * Created by sop on 2020/5/31.
 */
public class MaxArea {

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        long maxH = Integer.MIN_VALUE;
        long maxV = Integer.MIN_VALUE;

        for(int i=0; i<=horizontalCuts.length; i++){
            if(i==0){
                maxH = Math.max(horizontalCuts[i] - 0, maxH);
                continue;
            }
            if(i==horizontalCuts.length){
                maxH = Math.max(h- horizontalCuts[i-1], maxH);
                continue;
            }
            maxH = Math.max(horizontalCuts[i] - horizontalCuts[i-1], maxH);
        }

        for(int j=0; j<=verticalCuts.length; j++){
            if(j==0){
                maxV = Math.max(verticalCuts[j] - 0, maxV);
                continue;
            }
            if(j==verticalCuts.length){
                maxV = Math.max(w- verticalCuts[j-1], maxV);
                continue;
            }
            maxV = Math.max(verticalCuts[j] - verticalCuts[j-1], maxV);
        }

        long div = (long)Math.pow(10,9) + 7;
        long multify = maxH * maxV;
        return (int) (multify % div);
    }

    public static void main(String[] args) {
        MaxArea a = new MaxArea();
        int h = 50;
        int w = 15;
        int[] hs = {37,40,41,30,27,10,31};

        int[] ws = {2,1,9,5,4,12,6,13,11};
        System.out.println(a.maxArea(h,w, hs,ws));

        long n1= (int)Math.pow(10,9);
        long n2=(int) Math.pow(10,9)-0;
        long  did = (int)Math.pow(10,9) + 7;
        int res =  (int)((n1*n2) % did);
        System.out.println(n1);
        System.out.println(n2);
        System.out.println(res);
    }
}
