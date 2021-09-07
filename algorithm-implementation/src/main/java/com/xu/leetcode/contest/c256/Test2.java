package com.xu.leetcode.contest.c256;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author xushichao
 * @date 2021/8/29 10:24 AM
 * @desc
 */
public class Test2 {

    public String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return compareStr(o1,o2);
            }
        });

        return nums[nums.length-k];

    }
    private int compareStr(String s1, String s2){
       int l1 = s1.length();
       int l2 = s2.length();
       if(l1 > l2) {
           return 1;
       } else if(l1 < l2) {
           return -1;
       } else {
           return s1.compareTo(s2);
       }
    }

    public static void main(String[] args) {
        String[] nums = new String[] {"3","6","7","10"};
        int k = 4;
        Test2 test2 = new Test2();
        String res = test2.kthLargestNumber(nums,k);
        System.out.println(res);

    }
}
