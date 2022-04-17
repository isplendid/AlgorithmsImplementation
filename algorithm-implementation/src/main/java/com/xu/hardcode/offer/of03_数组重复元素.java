package com.xu.hardcode.offer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xushichao
 * @date 2022/3/19 6:45 PM
 * @desc
 */
public class of03_数组重复元素 {


    /***
     * 方法二：原地交换， 时间O(N), 空间O(1);
     * 在一个长度为n的数组nums里所有数字都在0—n-1的范围内
     * 数组元素的索引和值是一对多的关系，因此可建立索引与值的映射关系
     *
     * 关键点：nums[i]==i 则i++;   若nums[nums[i]]=nums[i] 则找到重复值，否则交换nums[i]与nums[nums[i]]的值
     *
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber_2(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i) {
                i++;
                continue;
            }
            if (nums[nums[i]] == nums[i]) {
                return nums[i];
            } else {
                int tmp = nums[i];
                nums[i] = nums[tmp];
                nums[tmp] = tmp;
            }
        }
        return -1;

    }

    /***
     * 方法一：集合
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) return num;
            set.add(num);
        }
        return -1;
    }

}

