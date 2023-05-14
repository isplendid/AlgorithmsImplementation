package com.xu.leetcode.linkedlistarray;

/**
 * @author xushichao
 * @date 2023/5/13 11:53
 * @desc
 */
public class AddStrings_415 {
    public String addStrings(String num1, String num2) {

        int i=num1.length()-1, j=num2.length()-1;
        int carry =0;
        StringBuilder sb = new StringBuilder();
        while(i>=0 || j >=0 || carry > 0) {
            int n1 = i ==  -1 ? 0: (int) num1.charAt(i) - '0';
            int n2 = j == -1  ? 0: (int) num2.charAt(j) - '0';
            int sum = n1 + n2 + carry;
            carry = sum/10;
            sb.insert(0,  sum % 10);

            if(i >=0) {
                i--;
            }
            if(j >=0) {
                j--;
            }
        }

        return sb.toString();

    }
}
