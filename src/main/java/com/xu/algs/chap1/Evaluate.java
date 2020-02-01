package com.xu.algs.chap1;

import com.xu.algs.basic.StdIn;
import com.xu.algs.basic.StdOut;

import java.util.Stack;

/**
 * Created by sop on 2020/1/18.
 *
 * Dijkstra的双栈表达式求值算法
 */
public class Evaluate {
    public static void main(String[] args) {
        Stack<String> operatorStack = new Stack<>();
        Stack<Double> numberStack = new Stack<>();
        while(!StdIn.isEmpty()){
            String s = StdIn.readString();
            if(s.equals("("));
            else if(s.equals("+")) operatorStack.push(s);
            else if(s.equals("-")) operatorStack.push(s);
            else if(s.equals("*")) operatorStack.push(s);
            else if(s.equals("/")) operatorStack.push(s);
            else if(s.equals("sqrt")) operatorStack.push(s);
            else if(s.equals(")")) {
                String op = operatorStack.pop();
                double value = numberStack.pop();
                if(op.equals("+")) value = numberStack.pop() + value;
                else if(op.equals("-")) value = numberStack.pop() - value;
                else if(op.equals("*")) value = numberStack.pop() * value;
                else if(op.equals("/")) value = numberStack.pop() / value;
                else if(op.equals("sqrt")) value = Math.sqrt(value);
                numberStack.push(value);
            }
            else numberStack.push(Double.parseDouble(s));
        }
        StdOut.println(numberStack.pop()); 
    }
}
