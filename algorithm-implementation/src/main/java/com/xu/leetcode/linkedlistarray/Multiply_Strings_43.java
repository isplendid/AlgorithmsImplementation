package com.xu.leetcode.linkedlistarray;

/**
 * @author xushichao
 * @date 2023/5/13 11:54
 * @desc
 *
 * 1 2 3
 * 4 5 6
 */
public class Multiply_Strings_43 {

    public String multiply(String num1, String num2) {

        if(num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String ans = "0";

        int m = num1.length();
        int n = num2.length();

        for(int i=n-1; i>=0; i--) {
            StringBuilder cur = new StringBuilder();
            int carry = 0;

            //末尾补充0的数量;
            for(int j=1; j<=n-(i+1); j++) {
                cur.append(0);
            }

            //计算num1的每一位 乘以 nums[i]
            for(int j= m-1; j >=0; j--) {
                int x = num1.charAt(j) - '0';
                int y = num2.charAt(i) - '0';
                int sum = x * y + carry;

                cur.insert(0, sum % 10);

                carry = sum /10;

            }

            if(carry != 0) {
                cur.insert(0, carry);
            }
            ans = this.addStrings(ans, cur.toString());

        }

        return ans;

    }


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

    public static void main(String[] args) {
        String n1 = "123";
        String n2 = "456";

        Multiply_Strings_43 multiply_strings_43 = new Multiply_Strings_43();
        String res = multiply_strings_43.multiply(n1, n2);
        System.out.println(res);
    }
}
