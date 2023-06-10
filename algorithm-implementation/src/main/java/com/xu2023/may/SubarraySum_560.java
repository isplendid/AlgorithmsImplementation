package com.xu2023.may;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xushichao
 * @date 2023/5/27 22:29
 * @desc
 */
public class SubarraySum_560 {

    public int subarraySum(int[] nums, int k) {

        int count = 0; //统计
        int sum =0 ; //前缀和

        //前缀和，出现次数
        Map<Integer, Integer> map = new HashMap<>();
        for(int num:nums) {
            sum += num; //累加
//            if(sum == k) { //从下标 0 累加到 i 刚好等于 k
//                count++;
//            }

            if(map.containsKey(sum - k)) {
                count +=  map.get(sum -k);
            }
            map.put(sum,  map.getOrDefault(sum, 0) + 1);

        }

        return count;

    }


    public static void main(String[] args) {
        int[] arr= new int[]{1, 2, 3, 6};
        SubarraySum_560 sum = new SubarraySum_560();
        int k = 6;
        int res = sum.subarraySum(arr, k);
        System.out.println(res);

    }
}
