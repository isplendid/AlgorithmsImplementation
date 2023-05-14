package com.xu2022.test;

import com.xu.algs.basic.In;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author xushichao
 * @date 2022/12/2 16:05
 * @desc
 */
public class Main {


    public static void main2(String[] args) {

//        Context.instance = new Context();
//        Context context = Context.instance;
//
//       context.a=20;
//        System.out.println(Context.instance);
//        System.out.println(context);
//
//        Arrays.equals()

//        char c= '1';
//        int cc = c - '0';
//        System.out.println(cc);
//
//        int[] arr =  new int[]{1,2,4};
//        Arrays.stream(arr).sum();

        String str ="";
        str  += 'z' - 'a' +1;
        System.out.println(str);

        String str3= "223";


    }
    public static int minElements(int[] nums, int limit, int goal) {
        int sum = Arrays.stream(nums).sum();
        int space = goal - sum;
        int val = Math.abs((int)Math.ceil(1.0*Math.abs(space)/limit));
        return val;
    }

    public static void main(String[] args) {
//        int a = -5;
//        int b =3;
//        int res = (int) Math.ceil( 1.0*Math.abs(a)/b);
//        System.out.println(res);
        int[] arr = new int[]{1,-1,1};
        int res = minElements(arr, 3, -4);
        System.out.println(res);
    }
}
