package com.xu.leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by sop on 2020/2/12.
 * 实现 FreqStack，模拟类似栈的数据结构的操作的一个类。

 FreqStack 有两个函数：

 push(int x)，将整数 x 推入栈中。
 pop()，它移除并返回栈中出现最频繁的元素。
 如果最频繁的元素不只一个，则移除并返回最接近栈顶的元素。
 链接：https://leetcode-cn.com/problems/maximum-frequency-stack


 解题思路：
 Hash map freq will count the frequence of elements.
 Hash map m is a map of stack.
 If element x has n frequence, we will push x n times in m[1], m[2] .. m[n]

 */
public class FreqStack {
    HashMap<Integer, Integer> freq = new HashMap<>();
    HashMap<Integer, Stack<Integer>> map = new HashMap<>();
    int maxFreq = 0;
    public FreqStack() {

    }

    public void push(int x) {
        int f = freq.getOrDefault(x, 0) + 1;
        freq.put(x, f);
        maxFreq = Math.max(maxFreq, f);
        if(!map.containsKey(f)) {
            map.put(f, new Stack<Integer>());
        }
        map.get(f).add(x);
    }

    public int pop() {
        int x = map.get(maxFreq).pop();
        freq.put(x, maxFreq -1);
        if(map.get(maxFreq).size() == 0) maxFreq --;
        return x;
    }
}
