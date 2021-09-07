package com.xu.leetcode.queue;

import java.util.Stack;

/**
 * @author xushichao
 * @date 2021/9/5 10:12 PM
 * @desc 两个栈实现一个队列
 * 保持两个原则
 * 1）StackPush和StackPop, 如果要往StackPop中压数据，必须一次性全部从StackPush倒入
 * 2）StackPop不为空，则不能往StackPop压数据
 */
public class MyQueue_232 {
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    /**
     * Initialize your data structure here.
     */
    public MyQueue_232() {
        stackPush = new Stack<Integer>();
        stackPop = new Stack<Integer>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stackPush.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
       if(stackPop.isEmpty() && stackPush.isEmpty()) {
           throw new RuntimeException("Queue is empty!");
       } else if(stackPop.isEmpty()) {
           while(!stackPush.isEmpty()){
               stackPop.push(stackPush.pop());
           }
       }
       return stackPop.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if(stackPop.isEmpty() && stackPush.isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        } else if(stackPop.isEmpty()) {
            while(!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stackPop.isEmpty();
    }


    /**
     * Your MyQueue object will be instantiated and called as such:
     * MyQueue obj = new MyQueue();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.peek();
     * boolean param_4 = obj.empty();
     */

    public static void main(String[] args) {

    }
}
