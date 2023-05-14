package com.xu2022.day;

import com.mashibing.juc.c_001.T;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author xushichao
 * @date 2022/11/13 19:40
 * @desc
 */
public class Test {

    public boolean halvesAreAlike(String s) {
        Set<Character> set = new HashSet<>();
        set.addAll(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        int l=0, r=0;
        int len = s.length();
        for(int i=0; i<len/2; i++){
            if(set.contains(s.charAt(i))) {
                l++;
            }
        }
        for(int i=len/2; i<len; i++){
            if(set.contains(s.charAt(i))) {
                r++;
            }
        }
        return l==r;
    }

    public static void main(String[] args) {
        Test test = new Test();
        String str = "book";
        boolean res = test.halvesAreAlike(str);
        System.out.println(res);
    }
}


