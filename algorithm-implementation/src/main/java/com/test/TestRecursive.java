package com.test;

/**
 * @author xushichao
 * @date 2022/8/14 4:43 PM
 * @desc
 */
public class TestRecursive {

    public static void count1(int n) {
        if(n==11){
            return;
        }
        System.out.println(n);
        count1(n+1);
    }

    public static void count(int n ){
        if(n==11){
            return;
        }
        System.out.println(n);
        n = n+1;
        count(n);
        n = n-1;
        System.out.println(n);
    }

    public static void main(String[] args) {
        int n= 0;
        count(n);
    }
}
