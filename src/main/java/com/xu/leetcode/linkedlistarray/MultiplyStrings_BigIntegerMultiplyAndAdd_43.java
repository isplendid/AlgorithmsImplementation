package com.xu.leetcode.linkedlistarray;

/**
 * Created by sop on 2019/2/17.
 * https://leetcode.com/problems/multiply-strings/
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

 Example 1:

 Input: num1 = "2", num2 = "3"
 Output: "6"
 Example 2:

 Input: num1 = "123", num2 = "456"
 Output: "56088"
 Note:

 The length of both num1 and num2 is < 110.
 Both num1 and num2 contain only digits 0-9.
 Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 You must not use any built-in BigInteger library or convert the inputs to integer


 415. Add Strings: https://leetcode.com/problems/add-strings/

 Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

 Note:

 The length of both num1 and num2 is < 5100.
 Both num1 and num2 contains only digits 0-9.
 Both num1 and num2 does not contain any leading zero.
 You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class MultiplyStrings_BigIntegerMultiplyAndAdd_43 {


    //https://www.cnblogs.com/Kobe10/p/6369960.html
    public String multiply(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        StringBuilder sb = new StringBuilder();
        int[] tmp = new int[n1+n2];
        for(int i=n1-1; i>=0; i--){
            for(int j=n2-1; j>=0; j--){
                tmp[i+j+1] += (num1.charAt(i)- '0') * (num2.charAt(j) - '0');
            }
        }
        int carrybit = 0;//从各位开始，进位
        for(int i=tmp.length -1; i>=0; i--){
            tmp[i] += carrybit;
            carrybit = tmp[i] /10;
            tmp[i] = tmp[i] % 10;
        }

        int left = 0;
        while(left < tmp.length -1 && tmp[left] == 0){
            left ++;
        }
        for(; left <tmp.length; left ++){
            sb.append(tmp[left]);
        }
        return sb.toString();

    }


    //leetcode opt
    public String multiplyLeetcode(String num1, String num2) {
        int n1 = num1.length(), n2 = num2.length();
        int[] products = new int[n1 + n2];
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                int d1 = num1.charAt(i) - '0';
                int d2 = num2.charAt(j) - '0';
                products[i + j + 1] += d1 * d2;
            }
        }
        int carry = 0;
        for (int i = products.length - 1; i >= 0; i--) {
            int tmp = (products[i] + carry) % 10;
            carry = (products[i] + carry) / 10;
            products[i] = tmp;
        }
        StringBuilder sb = new StringBuilder();
        for (int num : products) sb.append(num);
        while (sb.length() != 0 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        return sb.length() == 0 ? "0" : sb.toString();
    }



    public static String addStrings(String num1, String num2) {
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        int carry = 0;
        String sum = "";
        while(len1 >= 0 || len2 >= 0 || carry >0){   // carry >0 not including 0
            int flag = 0;
            if(len1 >= 0){
                flag += num1.charAt(len1) - '0';
                len1 --;
            }else{
                flag += 0;
            }

            if(len2 >= 0){
                flag += num2.charAt(len2) - '0';
                len2--;
            }else {
                flag += 0;
            }
            flag += carry;
            carry = flag/10;
            sum = String.valueOf(flag % 10 +'0') + sum;
        }
        return sum;
    }



    public static void main(String[] args) {
        String num1 = "0";
        String num2 = "0";
        System.out.println(addStrings(num1,num2));

        String sum ="";
        int flag  = 0;
        System.out.println((char)(flag % 10 +'0'));
        sum = String.valueOf(flag % 10 +'0') + sum;
        System.out.println(sum);

    }

}
