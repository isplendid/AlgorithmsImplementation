package com.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xushichao
 * @date 2022/9/10 19:43
 * @desc
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int[] res = new int[2];

        for(int i=0; i<n; i++){
            int idx = target-nums[i];
            if(map.containsKey(idx) ){
                if(map.get(idx) != i) {
                    res[0]= i;
                    res[1]= map.get(idx);
                    break;
                }
            }
            map.put(nums[i], i);
        }

        return res;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{2,7,11,15};
        int target = 9;
        TwoSum sum = new TwoSum();
        int[] res =  sum.twoSum(arr, target);
        Arrays.stream(res).forEach(System.out::println);
    }
}
