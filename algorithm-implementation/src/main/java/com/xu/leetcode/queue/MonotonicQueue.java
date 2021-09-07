package com.xu.leetcode.queue;

/**
 * @author xushichao
 * @date 2021/9/6 8:29 AM
 * @desc
 */
public interface MonotonicQueue {
    // 在队尾添加元素 n
    void push(int n);
    // 返回当前队列中的最大值
    int max();
    // 队头元素如果是 n，删除它
    void pop(int n);
}
