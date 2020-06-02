package com.xu.leetcode.intervals;

import java.util.Arrays;

/**
 * Created by sop on 2020/5/31.
 *
 * 给出一个区间的集合，请合并所有重叠的区间。
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 */
public class MergeIntervals_56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (int[] a, int[] b) -> {
            return a[0] -b[0];
        });
        // 遍历区间
        int[][] res = new int[intervals.length][2];
        int idx = -1;

        for(int[] interval:intervals){
            //如果结果数组是空，或者当前区间的起始位置 > 结果数组的最后区间的终止位置
            //则不合并，直接将当前区间合并到结果数组中;
            if(idx == -1 || interval[0] > res[idx][1]){
                res[++idx] = interval;
            }else {  // 反之将当前区间合并至结果数组的最后区间
                res[idx][1]=Math.max(res[idx][1], interval[1]);
            }
        }

      return Arrays.copyOf(res, idx+1);
    }



}
