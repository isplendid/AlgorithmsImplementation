package com.xu2023.may;

import java.util.Stack;

/**
 * @author xushichao
 * @date 2023/5/15 17:32
 * @desc
 */
public class L227_Calculate {

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char preSign = '+';  //第一个数字是 '+' ，表示正数
        int num = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }

            if (!Character.isDigit(c) && c != ' ' || i == n - 1) {  //|| i == n-1 表示最后一个数字计算
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        stack.push(stack.pop() / num);
                        break;
                }
                preSign = c;
                num = 0;
            }

        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }


    public static void main(String[] args) {

        L227_Calculate calculate = new L227_Calculate();
        String s = " 3+5 / 2 ";
        int res = calculate.calculate(s);
        System.out.println(res);


    }
}
