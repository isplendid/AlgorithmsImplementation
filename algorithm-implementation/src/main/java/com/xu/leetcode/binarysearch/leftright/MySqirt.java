package com.xu.leetcode.binarysearch.leftright;

import com.mashibing.juc.c_022_RefTypeAndThreadLocal.M;

/**
 * @author xushichao
 * @date 2023/5/18 17:59
 * @desc
 */
public class MySqirt {
    public int mySqrt(int x) {
        int low = 1;
        int high = x;
        //最后一个小于等于
        while(low <= high) {
            int mid = low + (high -low)/2;
            if((long )mid  * mid > x) {
                high = mid -1;
            } else {
                low = mid +1;
            }

        }
        return high;
    }


    public static void main(String[] args) {
        MySqirt sqirt = new MySqirt();
        int val = 2147395599;
       int res = sqirt.mySqrt(val);
        System.out.println(res);


    }
}
