package com.xu.leetcode.contest.month8;

import java.util.Arrays;

/**
 * @author xushichao
 * @date 2021/8/2 10:49 PM
 * @desc
 */
public class KWeakestRows_1337 {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        if(m == 0 ) {
            return new int[0];
        }
        int[] res = new int[k];
        int n = mat[0].length;

        int[] nums = new int[m];
        int sum = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(mat[i][j] == 1) {
                    sum ++;
                } else {
                    break;
                }
            }
            nums[i] = sum;
            sum =0;
        }

        for(int i=0; i<k; i++) {
            int min=Integer.MAX_VALUE;
            int index=0;
            for(int j=i; j<m; j++) {
                if(min > nums[j]) {
                    min = nums[j];
                    index = j;
                }
            }
            res[i] = index;
        }

        return res;
    }

    public static void main(String[] args) {
        KWeakestRows_1337 main = new KWeakestRows_1337();
        int[][] mat = new int[][]{{1,0,0,0},{1,1,1,1},{1,0,0,0},{1,0,0,0}};
        int k=2;
        int[] res = main.kWeakestRows(mat,k);
        Arrays.stream(res).forEach(System.out::println);
    }
}
