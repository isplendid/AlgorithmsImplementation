package com.xu2023.may;

import java.util.Stack;

/**
 * @author xushichao
 * @date 2023/5/19 21:26
 * @desc
 *
 *
 * num = "1432219", k = 3
 * num = "10200", k = 1
 *
 * 1） 移除K个数，剩余的数最小
 *
 *
 *  单调递减栈    4，3,  k--
 *  2）移除K个数，剩余的数最大
 *  4329
 *  1200   比他小的都移除
 *
 *
 */
public class RemoveMinNumber {

    static String leaveMinNumber(String number, int k) {
        if(k >= number.length()) {
            return "0";
        }
        Stack<Integer> stack = new Stack<>();
        //单调递增栈
        for(int i=0; i<number.length(); i++) {
            int c = number.charAt(i) - '0';
            while(!stack.isEmpty() && k>0 && c < stack.peek()) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        while( k> 0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }

        //去0
        String temp = sb.toString();

        int i=0;
        while(temp.charAt(i) == '0' && i < temp.length()-1) {
            i++;
        }

        return temp.substring(i, temp.length());
    }

    public static void main(String[] args) {
        String number = "11234567890";
        int k = 9;
        String result = leaveMinNumber(number, k);
        System.out.println(result);

    }
}
