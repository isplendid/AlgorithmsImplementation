package com.xu.leetcode.str.parentheses;

import java.util.Stack;

/**
 * Created by sop on 2020/3/14.
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 */
public class IsValid_20 {
    public boolean isValid(String s) {
        Stack<Character> left = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c == '['|| c == '{') {
                left.push(c);
            }else { //字符c是右括号
                if(!left.isEmpty() && leftOf(c) == left.peek()){
                    left.pop();
                } else { //和最近的左括号不匹配
                    return false;
                }
            }
        }
        return left.empty();

    }

    char leftOf(char c){
        if(c=='}') return '{';
        else if (c==']') return '[';
        else return '(';
    }


    /**
     * 2021.08.24
     * @param s
     * @return
     */
    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        boolean res = true;
        for(char c: s.toCharArray()){
            switch (c) {
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;
                case ']':
                    if(!stack.isEmpty() && stack.peek() == '['){
                        stack.pop();
                    } else {
                        res = false;
                    }
                    break;
                case '}':
                    if(!stack.isEmpty() && stack.peek() == '{'){
                        stack.pop();
                    } else {
                        res = false;
                    }
                    break;

                case ')':
                    if(!stack.isEmpty() && stack.peek() == '('){
                        stack.pop();
                    } else {
                        res = false;
                    }
                    break;
            }
            if(!res){
                return res;
            }

        }
        if(!stack.isEmpty()) {
            res = false;
        }
        return res;

    }
}
