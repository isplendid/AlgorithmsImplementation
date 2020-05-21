package com.xu.leetcode.str.biginteger;

/**
 * Created by sop on 2020/4/1.
 */
public class BigIntegerMinus {

    /***
     * 大数据相减
     * @param a
     * @param b
     * @return
     */
    public static  String minus(String a, String b){
        int lenA = a.length();
        int lenB = b.length();
        if(lenA > lenB){
            return  sub(a, b);
        }else if(lenA < lenB) {
            return "-" + sub(b, a);
        }else if(lenA == lenB){
            if(a.compareTo(b)>=0){
                return sub(a,b);
            }else {
                return "-"+sub(b,a);
            }
        }
        return null;
    }

    private static String  sub(String a, String b){
        StringBuffer sb = new StringBuffer();
        int carry = 0;
        for(int i=a.length() -1, j=b.length()-1; i>=0||j>=0; i--, j--){
            int ca = i >= 0 ? a.charAt(i) - '0' : 0;
            int cb = j >= 0 ? b.charAt(j) - '0' : 0;
            int cur;
            if(ca + carry - cb >= 0){
                cur = ca + carry - cb ;
                carry = 0;
            } else {
                cur = ca + carry - cb  + 10;
                carry = -1;
            }
            sb.insert(0, (char)(cur +'0'));
         }
        int index=0; //去除前面的0
        while(sb.charAt(index) == '0'){
            index ++;
        }
        return sb.substring(index,sb.length()).toString();
    }

    public static void main(String[] args) {
        String a = "1090";
        String b = "978";   //minus(a,b) = 112
        System.out.println(minus(a,b));
    }

}
