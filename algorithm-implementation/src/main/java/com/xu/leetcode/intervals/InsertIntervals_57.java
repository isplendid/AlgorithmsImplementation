package com.xu.leetcode.intervals;

import java.util.Arrays;

/**
 * Created by sop on 2020/5/31.
 * 出一个无重叠的 ，按照区间起始端点排序的区间列表
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。

 示例 1:
 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
 输出: [[1,5],[6,9]]
 */
public class InsertIntervals_57 {
    //方法一：合并 newInterval ,然后调用merge 合并 重叠区间即可
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] intervalArr = new int[intervals.length + 1][2];
        int i=0;
        while(i < intervals.length && intervals[i][0] < newInterval[0]){
            intervalArr[i] = intervals[i];
            i++;
        }
        intervalArr[i] = newInterval;
        for(int j= i; j<intervals.length; j++){
            intervalArr[j+1] = intervals[j];
        }
        return merge(intervalArr);
    }


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
