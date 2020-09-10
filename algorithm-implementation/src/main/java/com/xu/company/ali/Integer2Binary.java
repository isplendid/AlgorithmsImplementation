package com.xu.company.ali;

/**
 * Created by sop on 2020/09/2020/9/2 16:02
 *
 * @Description:
 *  题目1：编码实现，把这个整型转成二进制字符串。
 */
public class Integer2Binary {

    public static void main(String[] args) {
        int a=2020; //11111100100
        System.out.println(int2Binary(a));
        System.out.println(int2Binary(6));
        System.out.println(int2Binary(7));

    }

    public static String int2Binary(int a){
        StringBuilder sb = new StringBuilder();
        while (a != 1){
            sb.insert(0, a %2);
            a = a/2;
        }
        sb.insert(0,1);
        return sb.toString();
    }
}
