package com.xu.leetcode.desgin;

import com.xu.algs.basic.In;

import java.util.*;

/**
 * @author xushichao
 * @date 2022/11/30 12:38
 * @desc
 */
public class FreqStack {
    private Map<Integer, Integer> map;
    private List<Stack<Integer>> freqLists;

    public FreqStack() {
        map = new HashMap<>();
        freqLists = new ArrayList<>();
    }

    public void push(int val) {

        int freq = map.getOrDefault(val, 0) + 1;
        map.put(val, freq);
        if(freq > freqLists.size()) {
            Stack<Integer> stack = new Stack<>();
            stack.push(val);
            freqLists.add(stack);
        } else {
            freqLists.get(freq-1).push(val);
        }
    }

    public int pop() {
        Stack<Integer> stack = freqLists.get(freqLists.size()-1);
        int val = stack.pop();
        if(stack.isEmpty()) {
            freqLists.remove(freqLists.size()-1);
        }
        map.put(val, map.get(val) -1);
        return val;
    }

    public static void main1(String[] args) {
        FreqStack freqStack = new FreqStack();
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(4);
        freqStack.push(5);

        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
    }

    public static void main(String[] args) {
        FreqStack freqStack = new FreqStack();
        freqStack.push(1);
        freqStack.push(1);
        freqStack.push(1);
        freqStack.push(2);

        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());

        freqStack.push(2);
        freqStack.push(2);
        freqStack.push(1);

        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
    }

}
