package com.xu.leetcode.str.biginteger;

/**
 * Created by sop on 2020/4/1.
 */
public class BigIntegerMultiple {

    /*多位数与多位数相乘（（正数乘以正数））*/
    public String mutiMultiply(String a,String b){

        String sum = "0";
        for(int i = b.length()-1;i>=0;i--){
            String tmp = singleMultipy(a,b.substring(i, i+1));
            for(int j=i;j<b.length()-1;j++){//tmp末尾要补0（乘以10），才能与上次结果相加
                tmp+="0";
            }
            sum = plus(sum,tmp);
        }

        return sum.toString();
    }


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


    /*一个多位数乘以一个个位数（正数乘以正数）*/
    public String singleMultipy(String a,String b){
        int carry = 0;
        int cb = b.charAt(0)-'0';
        StringBuffer sb = new StringBuffer();
        for(int i = a.length()-1;i>=0;i--){
            int ca = i>=0?a.charAt(i)-'0':0;
            int cv = (ca*cb+carry)%10;
            carry = (ca*cb+carry)/10;
            sb.insert(0, (char)(cv+'0'));
        }
        if(carry>0)
            sb.insert(0, (char)(carry+'0'));
        return sb.toString();

    }
}
