package com.xu.leetcode.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xushichao
 * @date 2021/9/6 8:33 AM
 * @desc
 */
public class MaxWindow_239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue queue = new MonotonicQueueImpl();

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                queue.push(nums[i]);
            } else {
                //窗口向前移动，移入新元素
                queue.push(nums[i]);
                list.add(queue.max());
                //移出最后的元素
                queue.pop(nums[i - k + 1]);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
