package com.xu.leetcode.contest.c200;

/**
 * Created by sop on 2020/8/2.
 */
public class Test4_maxSum {

    public int maxSum(int[] nums1, int[] nums2) {
        long sum1 = 0, sum2 = 0;
        int i = 0, j = 0;
        long res = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                res += Math.max(sum1, sum2) + nums1[i];
                sum1 = 0;
                sum2 = 0;
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                sum2 += nums2[j];
                j++;
            } else {
                sum1 += nums1[i];
                i++;
            }
        }

        while (i < nums1.length) {
            sum1 += nums1[i];
            i++;
        }

        while (j < nums2.length) {
            sum2 += nums2[j];
            j++;
        }

        res += Math.max(sum1, sum2);
        return (int) (res % (Math.pow(10, 9) + 7));
    }

    public static void main(String[] args) {

    }
}
