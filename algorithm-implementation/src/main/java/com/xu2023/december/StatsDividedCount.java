package com.xu2023.december;

/***
 * 牛牛想在 [a, b] 区间内找到一些数，满足可以被整数 c 整除。现在你需要帮助牛牛，统计区间内一共有多少个这样的数？
 *
 *
 * -5 * 10^8 <= a <= b <= 5 * 10 ^8
 *
 * 1<= c <= 1000
 *
 * 时间复杂度相对低点
 * eg:
 * 输入： 0 14 5
 * 输出： 3
 */
public class StatsDividedCount {

    public static  int statsCount(int a, int b, int c) {
        int i = a/c;
        int j = b/c;

        int modA = a % c;
        int modB = b % c;

        // (i<0 && j> 0)  ||  (i==0 || j==0)
        if((modA == 0 || modB == 0) || (i<0 && j> 0)){
            return j-i+1;
        } else {
            return j-i;
        }
    }



    public static void main(String[] args) {
        int a = -12;
        int b = -1;
        int c = 5;

        int r1 = statsCount(a, b, c);
        System.out.println(r1);


    }

}
