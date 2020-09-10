package com.xu.leetcode;

/**
 * Created by sop on 2020/3/14.
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */
public class TrapRainWater_42 {





    //空间换时间，记忆化最大值 解法
    //DP ,prefix max
    //Time: O(n), Space: O(n)
    public static int trap_1(int[] height) {
        int res=0;
        int n = height.length;
        int[] lmax = new int[n];
        int[] rmax  = new int[n];

        for(int i=0; i<n; i++){
            lmax[i] = i==0 ? height[i] : Math.max(height[i], lmax[i-1]);
        }
        for(int i=n-1; i>=0; i--){
            rmax[i] = i==n-1 ? height[i] : Math.max(height[i], rmax[i+1]);
        }
        for(int i=0; i<n; i++){
            res += Math.min(lmax[i], rmax[i]) - height[i];
        }
        return res;

    }


    //暴力解法
    public int trap_0(int[] height) {

        int res=0;
        int n = height.length;
        for(int i=0; i<n; i++){
            int lmax = getMax(height, 0, i);
            int rmax = getMax(height, i, n-1);
            res += Math.min(lmax,rmax) - height[i];
        }
        return res;

    }
    int getMax(int[] height, int start, int end){
        int max = Integer.MIN_VALUE;
        for(int i=start; i<=end; i++){
            max = Math.max(max, height[i]);
        }
        return max;
    }

    //双指针:two pointers
    //Time:O(n),  Space: O(1)


    //栈也可以



    public static void main(String[] args) {
        int[] height = new int[]{1};
        System.out.println(trap_1(height));
    }
}
