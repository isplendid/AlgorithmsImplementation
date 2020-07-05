package com.xu.leetcode.binarysearch.classic;

/**
 * Created by sop on 2020/6/21.
 * 给你一个整数数组 bloomDay，以及两个整数 m 和 k 。
 * 现需要制作 m 束花。制作花束时，需要使用花园中 相邻的 k 朵花
 * 花园中有 n 朵花，第 i 朵花会在 bloomDay[i] 时盛开，恰好 可以用于 一束 花中
 * 请你返回从花园中摘 m 束花需要等待的最少的天数。如果不能摘到 m 束花则返回 -1
 */
public class FlowerMinDays_1482 {
    /***
     * 如果第p天的时候无法制作m束花, 那么第1...p天的时候也都不满足,
     * 如果第p天的时候可以制作m束花, 那么第p, p+1, p+2, ...天都可以;
     * 所以可以在天数上采用二分查找的方式
     * @param bloomDay
     * @param m
     * @param k
     * @return
     */
    public int minDays(int[] bloomDay, int m, int k) {
        if(m * k > bloomDay.length){
            return -1;
        }
        int max = 0;
        for(int i=0; i<bloomDay.length; i++){
            max = Math.max(max, bloomDay[i]);
        }
        int min =0;
        while(min < max ){
            int mid = min + (max -min)/2;
            int count = getCount(bloomDay, mid, k);
            if(count >= m){
                max = mid;
            }else {
                min = mid + 1;
            }
        }
        return min;
    }

    /***
     * 第day天 有多少组 连续k天
     * @param arr
     * @param day
     * @param k
     * @return
     */
    private int getCount(int[] arr, int day, int k){
        int count = 0;
        int group = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] <=day){
                count ++;
            }else {
                count = 0;
            }
            if(count == k){
                group ++;
                count = 0;
            }
        }
        return group;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7,7,7,7,12,7,7};
        int m = 2;
        int k = 3;

        FlowerMinDays_1482  f = new FlowerMinDays_1482();
        System.out.println(f.minDays(arr, m, k));

    }


}
