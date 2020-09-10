package com.xu.leetcode.linkedlistarray;

/**
 * Created by sop on 2019/2/17.
 *  https://leetcode.com/problems/powx-n/
 */
public class PowXn_50 {

    public double myPow(double x, int n) {
        if(n == 0)
            return 1;
        // nteger: -2147483648～2147483647 （ -2^31 --- 2^31-1）
        //So if you try to get the abs(Min_Value), it is still Min_Value because it will go beyond the boundary 2^31-1 and become -2^31(Min), which means that "-Min_Value==Min_Value".
        if(n == Integer.MIN_VALUE){
            return myPow(x*x, n/2);          }
        if(n<0){
            n = -n;
            x = 1/x;
        }
        return (n%2 == 0) ? myPow(x*x, n/2) : x*myPow(x*x, n/2);
    }



//    public static double myPow(double x, int n) {
//        double res = 0;
//        if(n ==0) return 1;
//        int m = n<0?-n:n;
//        for(int i=0; i<m; i++){
//            res = res*x;
//        }
//        if(n<0) res = 1.0/res;
//        return res;
//    }
//    public static double pow(double x, int n) {
//        if(n<0) return 1.0/power(x,-n);
//        else return power(x,n);
//    }
//
//    public  static double power(double x, int n){
//        if(n==0) return 1;
//        double result = 0;
//        double temp = pow(x,n/2);
//        if(n%2==1){
//            result = x * temp * temp;
//        }else {
//            result = temp * temp;
//        }
//        return result;
//    }

    public static void main(String[] args) {
        double x = 2.00000 ;
        int n = -2147483648;
    }
}
