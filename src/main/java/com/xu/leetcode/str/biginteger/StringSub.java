package com.xu.leetcode.str.biginteger;

/**
 * Created by sop on 2020/4/1.
 */
public class StringSub {

    public static  String sub(String a, String b){
        int lenA = a.length();
        int lenB = b.length();
        boolean minusFlag = false;
        if(lenA > lenB){
          return  subp(a, b);
        }else if(lenA < lenB) {
            return "-" + subp(b, a);
        }else if(lenA == lenB){
            if(a.compareTo(b)>=0){
                return subp(a,b);
            }else {
                return "-"+subp(b,a);
            }
        }
       return null;
    }

    private static String  subp(String a, String b){
        int lenA = a.length();
        int lenB = b.length();
        String res = "";
        int carry = 0;
        while(--lenB >= 0) {
            int aTemp = a.charAt(--lenA) - '0' + carry ;
            int bTemp = b.charAt(lenB) - '0';
            carry = 0;
            int cur = aTemp - bTemp;
            if(cur < 0){
                carry -=1;
                cur =  cur + 10;
            }
            res = cur + res;
        }
        while(lenA-- > 0){
            int aLeft =  a.charAt(lenA) - '0' + carry;
            res = aLeft+res;
        }
        return res;
    }

    public static void main(String[] args) {
        String a= "88234";
        String b = "8234";
        //String b = "567";
        System.out.println(minus(a,b));
    }

    /*两个整数相减*/
    public static String minus(String a,String b){
        boolean minus_flag = false;
        int carry = 0;
        StringBuffer sb = new StringBuffer();
		/*变成大数减少数*/
        if(a.length()<b.length()||(a.length()==b.length()&&(a.compareTo(b)<0))){//a < b
            String temp = a;
            a = b;
            b = temp;
            minus_flag = true;
        }
        for(int i=a.length()-1,j=b.length()-1;i>=0||j>=0;i--,j--){

            int ca = i>=0?a.charAt(i)-'0':0;
            int cb = j>=0?b.charAt(j)-'0':0;
            int cv;
            if(ca-cb+carry>=0)
                cv = ca-cb+carry;
            else{
                cv = ca-cb+carry+10;
                carry = -1;
            }
            if(cv!=0)
                sb.insert(0, (char)(cv+'0'));
        }
        if(minus_flag)
            sb.insert(0, '-');
        return sb.toString();
    }
}
