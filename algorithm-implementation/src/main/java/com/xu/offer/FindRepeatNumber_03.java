package com.xu.offer;

import java.util.Arrays;

/**
 * Created by sop on 2020/09/2020/9/1 11:09
 *
 * @Description:
 */
public class FindRepeatNumber_03 {

    /***
     * 原地数组排序，
     *
     * 1) 条件：数组长度为n,元素值为0-n-1: 没有重复的情况：
     * 2,3,1,0,4,5,6
     * 0,1,2,3,4,5,6
     *
     *  交换的条件： i != nums[i] 做交换
     *  遍历完所有的元素
     *
     *  2) 考虑重复的情况： 元素 0-n-1范围内
     *  2,3，1,0,2,5,3
     *
     *  重复条件： i != nums[i] && nums[i] = nums[nums[i]]
     *
     * 时间复杂度是 O(n)
     * 空间复杂度是 O(1)
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
         for(int i=0; i<nums.length; i++){
             while(i != nums[i]){
                 if(nums[i] == nums[nums[i]]){
                     return nums[i];
                 }
                 int tmp = nums[nums[i]];
                 nums[nums[i]] = nums[i];
                 nums[i] = tmp;
             }
         }
         return -1;
    }


    // 数组代替哈希表
    // 数组 索引处理  space: O(N), time:O(N)  (类似于hashMap,但是比hashmap效率高）
    public int findRepeatNumber2(int[] nums) {
       int[] bucket = new int[nums.length];
        Arrays.fill(bucket, -1);
       for(int i=0; i< nums.length; i++){
           if(bucket[nums[i]] != -1){
               return nums[i];
           }
           bucket[nums[i]] = i;
       }
       return -1;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 0, 2, 5, 3};
        FindRepeatNumber_03 find = new FindRepeatNumber_03();
        System.out.println(find.findRepeatNumber(arr));
    }
}
