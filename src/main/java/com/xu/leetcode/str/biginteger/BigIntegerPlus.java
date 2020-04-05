package com.xu.leetcode.str.biginteger;

/**
 * Created by sop on 2020/4/1.
 */
public class BigIntegerPlus { //可类比链表相加减
    /*两个整数相加*/
    public static String plus(String a,String b){
        StringBuffer sb = new StringBuffer();
        int carry = 0;
        int i,j;
        for(i=a.length()-1,j=b.length()-1;i>=0||j>=0;i--,j--){
            int ca = i>=0?a.charAt(i)-'0':0;
            int cb = j>=0?b.charAt(j)-'0':0;
            int cv = (ca+cb+carry)%10;
            carry = (ca+cb+carry)/10;
            sb.insert(0, (char)(cv+'0'));
        }
        if(carry==1)
            sb.insert(0, 1);
        return sb.toString();
    }

    public static void main(String[] args) {
        String a ="123434";
        String b = "999999";
        System.out.println(plus(a,b)); //1123433
    }
}
