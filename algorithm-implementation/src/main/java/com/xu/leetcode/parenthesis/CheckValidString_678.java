package com.xu.leetcode.parenthesis;

import java.util.Stack;

/**
 * @author xushichao
 * @date 2021/9/18 8:20 PM
 * @desc
 */
public class CheckValidString_678 {

    /**
     * 令左括号的得分为 1；右括号的得分为 -1。那么对于合法的方案而言，必定满足最终得分为 0
     * 具体的，使用两个变量 l 和 h 分别表示「最低得分」和「最高得分」
     *
     * @param s
     * @return
     */
//    public boolean checkValidString_2(String s) {
//
//    }


    /***
     * 继续用栈操作
     * 1）如果遇到左括号，则将当前下标存入左括号栈。
     * 2)如果遇到星号，则将当前下标存入星号栈。
     * 3)  如果遇到右括号，则需要有一个左括号或星号和右括号匹配，由于星号也可以看成右括号或者空字符串，因此当前的右括号应优先和左括号匹配，没有左括号时和星号匹配：
     * 3.1 如果左括号栈不为空，则从左括号栈弹出栈顶元素；
     * 3.2 如果左括号栈为空且星号栈不为空，则从星号栈弹出栈顶元素；
     * 3.3 如果左括号栈和星号栈都为空，则没有字符可以和当前的右括号匹配，返回 false。
     * @param s
     * @return
     */
//    public boolean checkValidString(String s) {
//
//    }

    /**
     * 该方法理解错误，*不是最后处理的
     * 左括号 stack,
     * 星号 stack
     *
     * @param s
     * @return
     */
    public boolean checkValidString(String s) {
        Stack<Integer> left = new Stack<>();
        Stack<Integer> star = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left.push(i);
            } else if (c == '*') {
                star.push(i);
            } else if (c == ')') {
                if (left.isEmpty() && star.isEmpty()) {
                    return false;
                } else if (!left.isEmpty()) {
                    left.pop();
                } else if (!star.isEmpty()) {
                    star.pop();
                }
            }
        }
        //遍历结束之后，左括号栈和星号栈可能还有元素
        // 注意：以"*(((*)" 为例子，遍历完成后，左括号栈和星号栈可能还有元素。
        // 为了将每个左括号匹配，需要将星号看成右括号，且每个左括号必须出现在其匹配的星号之前。
        while (!left.isEmpty() && !star.isEmpty()) {
            int leftIndex = left.pop();
            int starIndex = star.pop();
            if (leftIndex > starIndex) {
                return false;
            }
        }
        return left.isEmpty();
    }

    public static void main(String[] args) {
        CheckValidString_678 check = new CheckValidString_678();
        String s = "(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())";
        boolean res = check.checkValidString(s);
        System.out.println(res); //结果false
    }
}
