package com.xu.leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author xushichao
 * @date 2021/9/6 10:59 PM
 * @desc
 */
public class DailyTemperatures_739 {

    /***
     * 逆序遍历，单调栈，存索引下标
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int len = temperatures.length;
        int[] res = new int[len];
        for(int i=len -1; i>=0; i--) {
            while(!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i] ){
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return  res;
    }

    public static void main(String[] args) {
        int[] temp = new int[]{73,74,75,71,69,72,76,73};
        DailyTemperatures_739 d = new DailyTemperatures_739();
        int[] res = d.dailyTemperatures(temp);
        Arrays.stream(res).asLongStream().forEach(System.out::println);
    }
}
