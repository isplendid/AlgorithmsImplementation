package com.xu.leetcode.queue;

import java.util.LinkedList;

/**
 * Created by sop on 2020/6/7.
 * 单调队列数据结构
 * https://labuladong.gitbook.io/temp/readme-2
 */
public class MonotonicQueueImpl implements MonotonicQueue{

    //双链表，支持头部和尾部删除元素
    private LinkedList<Integer> q = new LinkedList<>();
    @Override
    public void push(int n) {
        //将前面小于自己的元素都删除
        while (!q.isEmpty() && q.getLast() < n) {
            q.pollLast();
        }
        q.addLast(n);
    }

    @Override
    public int max() {
        return q.getFirst();
    }

    @Override
    public void pop(int n) {
        //之所以要判断 data.front() == n，是因为我们想删除的队头元素 n 可能已经被「压扁」了，
        // 可能已经不存在了，所以这时候就不用删除了：
        if(n == q.getFirst()) {
            q.pollFirst();
        }
    }
}
