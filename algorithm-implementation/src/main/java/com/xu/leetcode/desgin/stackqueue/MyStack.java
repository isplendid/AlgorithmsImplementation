package com.xu.leetcode.desgin.stackqueue;

import com.xu.algs.basic.In;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sop on 2020/6/14.
 */
public class MyStack {
    Queue<Integer> q;

    /** Initialize your data structure here. */
    public MyStack() {

        q = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
      q.offer(x);
      int size = q.size();
      while(size > 1){
          q.offer(q.poll());
          size --;
      }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
      return q.poll();
    }

    /** Get the top element. */
    public int top() {
         return q.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
       return q.isEmpty();
    }
}
