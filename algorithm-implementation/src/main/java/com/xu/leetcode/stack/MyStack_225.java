package com.xu.leetcode.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xushichao
 * @date 2021/9/6 8:10 AM
 * @desc 用队列实现栈
 */
public class MyStack_225 {
    Queue<Integer> q;

    /**
     * Initialize your data structure here.
     */
    public MyStack_225() {

        q = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        q.offer(x);
        int size = q.size();
        while (size > 1) {
            q.offer(q.poll());
            size--;
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return q.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return q.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

