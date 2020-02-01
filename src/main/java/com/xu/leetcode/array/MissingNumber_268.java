package com.xu.leetcode.array;

import java.util.Arrays;

/**
 * Created by sop on 2020/1/18.
 *
 *
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

 Example 1:

 Input: [3,0,1]
 Output: 2
 Example 2:

 Input: [9,6,4,2,3,5,7,0,1]
 Output: 8
 Note:
 Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */
public class MissingNumber_268 {

    /***
     *  Java Bit Manipulate: use XOR operation
     * @param nums
     * @return
     */
    public int missingNumber1(int[] nums) {
        int res = nums.length;
        for(int i=0; i<nums.length; i++){
            res = res ^ i ^ nums[i]; // a^b^b = a
        }
        return res;
    }

    /***
     * SUM
     * @param nums  :this method will cause overflow;
     *              to avoid overflow, can use long instead of int;
     * @return
     */
    public int missingNumber2(int[] nums) {
        int len = nums.length;
        int sum = (0 + len) * (len + 1)/2;
        for(int i=0; i< nums.length; i++){
            sum -= nums[i];
        }
        return sum;
    }

//
//    /***
//     * map table: O(n) time, O(1) space
//     * @param nums
//     * @return
//     */
//    public int missingNumber3(int[] nums) {
//        for(int i=0; i<nums.length; i++){
//
//        }
//
//    }


}
