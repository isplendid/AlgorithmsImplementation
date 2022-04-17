package com.xu.leetcode.contest.c285;

/**
 * @author xushichao
 * @date 2022/3/20 10:36 AM
 * @desc
 */
public class Test1 {
    public static int countHillValley(int[] nums) {
        int sum = 0;
        boolean upFlag = false;
        boolean down = true;
        for (int i = 0; i < nums.length - 1; i++) {
            int left = nums[i];
            int right = nums[i + 1];

            if (left > right) {
                if (upFlag) {
                    sum++;
                    upFlag = false;
                }
            } else if (left < right) {
                if (!upFlag) {
                    sum++; //i为波谷
                    upFlag = true;
                    down = false;
                }
            } //相等不做啥
        }
        return !down ? sum - 1 : sum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 4, 1, 1, 6, 5};
        int[] nums2 = new int[]{6, 6, 5, 5, 4, 1};
        int[] nums3 = new int[]{6, 5, 10};

        System.out.println(countHillValley(nums));
        System.out.println(countHillValley(nums2));
        System.out.println(countHillValley(nums3));
    }
}
