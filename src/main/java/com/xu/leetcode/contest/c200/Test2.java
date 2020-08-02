package com.xu.leetcode.contest.c200;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by sop on 2020/8/2.
 */
public class Test2 {


    public int getWinner(int[] arr, int k) {
        Stack<Integer> stack = new Stack<>();
        int i=0;
        stack.push(arr[i]);
        Map<Integer, Integer> map = new HashMap<>();
        while(!stack.isEmpty() && i<arr.length-1){
            int top = stack.peek();
            int cnt = map.getOrDefault(top,0);
            if(cnt == k ) {
                return top;
            }
            if(top < arr[++i]){
                map.put(arr[i], 1);
                stack.pop();
                stack.push(arr[i]);
            }else { //top > arr[i]
                map.put(top, map.getOrDefault(top, 0) + 1);
            }
        }
      return stack.peek();
    }
    public static void main(String[] args) {
        Test2 t = new Test2();
        //int[] arr = new int[]{2,1,3,5,4,6,7};
        int[] arr = new int[]{1,11,22,33,44,55,66,77,88,99};
        int k=1000000000;
        System.out.println(t.getWinner(arr, k));

    }
}
