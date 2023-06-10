package com.xu.task;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author xushichao
 * @date 2022/9/5 20:19
 * @desc
 */
public class LinearParallelerTest {

    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int maxValue = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            maxValue = Math.max(maxValue, nums[i]);
        }
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            int curCnt=0;
            while(i<n && nums[i] == maxValue) {
                curCnt++;
                max = Math.max(curCnt, max);
                i++;
            }

        }
        return max;
    }
    public static void main(String[] args) {
//        Integer[] heights = new Integer[]{1,2,3};
//        Arrays.sort(heights, Collections.reverseOrder());
        int[] heights = new int[]{1,2,3,3,2,2};
       // Arrays.sort(heights, );
        LinearParallelerTest test = new LinearParallelerTest();
       int res = test.longestSubarray(heights);
        System.out.println(res);

    }
}
