package com.xu.leetcode.contest.c258;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xushichao
 * @date 2021/9/12 10:53 AM
 * @desc
 */
public class Test2 {
    public long interchangeableRectangles(int[][] rectangles) {
        if (rectangles.length <= 1 || rectangles[0].length != 2) {
            return 0L;
        }
        Map<Double, Long> map = new HashMap<>();
        for (int[] rec : rectangles) {
            Double rate = 1.0 * rec[0] / rec[1];
            if (map.containsKey(rate)) {
                map.put(rate, map.get(rate) + 1);
            } else {
                map.put(rate, 1L);
            }
        }
        long res = 0L;
        for (Map.Entry<Double, Long> entry : map.entrySet()) {
            res += combination(entry.getValue(), 2L);
        }
        return res;
    }

    private long combination(long n, long k) {
        if (n < k) {
            return 0;
        }
        long a = 1, b = 1;
        if (k > n / 2) {
            k = n - k;
        }
        for (long i = 1; i <= k; i++) {
            a *= (n + 1 - i);
            b *= i;
        }
        return a / b;
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        //System.out.println(test2.combination(4,2));
        int[][] recs = new int[][]{{4, 8}, {3, 6}, {10, 20}, {15, 30}};
        int[][] recs2 = new int[][]{{4, 7}, {8, 14}};
        System.out.println(test2.interchangeableRectangles(recs));
        System.out.println(test2.interchangeableRectangles(recs2));

    }


    private boolean considerSame(double v1, double v2) {
        return Math.abs(v1 - v2) <= 0.0000001;
    }

}
