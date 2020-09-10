package com.xu.leetcode.contest.c194;

import java.util.Arrays;

/**
 * Created by sop on 2020/6/21.
 */
public class Test2 {
    public int getLastMoment(int n, int[] left, int[] right) {
        Arrays.sort(left);
        Arrays.sort(right);
        int maxLeft = left.length == 0 ? -1: left[left.length -1];
        int minRight = right.length == 0 ? -1: right[0];
        if(maxLeft == -1 && minRight != -1) {
            return n-minRight;
        } else if( maxLeft != -1 && minRight == -1){
            return maxLeft;
        }
        return Math.max(maxLeft, n-minRight);
    }

    public static void main(String[] args) {
        int[] left = new int[]{0};
        int[] right = new int[]{};
        int n = 1000;
        Test2 t  = new Test2();
        System.out.println(t.getLastMoment(n,left, right));
    }
}
