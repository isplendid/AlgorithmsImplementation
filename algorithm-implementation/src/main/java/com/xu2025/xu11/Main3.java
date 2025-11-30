package com.xu2025.xu11;

import java.util.HashMap;
import java.util.Map;

/**
 * @author alex xu
 * @date 2025/11/30
 * @desc
 */
public class Main3 {
    public int minMirrorPairDistance(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int minDist = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int rev = reverse(nums[i]);
            if (map.containsKey(rev)) {
                int j = map.get(rev);
                if (i < j) {
                    minDist = Math.min(minDist, Math.abs(i - j));
                }
            }
        }

        if (minDist == Integer.MAX_VALUE) {
            return -1;
        }

        return minDist;
    }


    /***
     * 翻转数字
     * @param val
     * @return
     */
    private int reverse(int val) {
        int rev = 0;
        while (val != 0) {
            rev = rev * 10 + val % 10;
            val /= 10;
        }
        return rev;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{120, 21};
        Main3 main3 = new Main3();
        int val = main3.minMirrorPairDistance(nums);
        System.out.println(val);
    }
}
