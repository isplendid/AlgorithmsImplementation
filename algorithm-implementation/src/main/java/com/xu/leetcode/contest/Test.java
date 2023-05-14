package com.xu.leetcode.contest;

import com.xu.algs.basic.In;

/**
 * Created by sop on 2020/8/3.
 */
public class Test {
    public String addStrings(String num1, String num2) {
        int l1 = num1.length() - 1;
        int l2 = num2.length() -1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while(l1 >= 0 || l2 >= 0 || carry > 0) {
            int n1 = l1 == -1 ? 0 : (int) num1.charAt(l1) - '0';
            int n2 = l2 == -1 ? 0 : (int) num2.charAt(l2) - '0';
            int sum = n1 +n2 +carry;
            carry = sum /10;
            sb.insert(0, String.valueOf(sum % 10));
            if(l1 >=0 ) {
                l1--;
            }
            if(l2 >= 0) {
                l2--;
            }
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        String a = "9133";
        String b = "0";
       Test t = new Test();
        System.out.println(t.addStrings(a,b));

    }
}
