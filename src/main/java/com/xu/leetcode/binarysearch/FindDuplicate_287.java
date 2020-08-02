package com.xu.leetcode.binarysearch;

/**
 * Created by sop on 2020/8/1.
 * 给定一个包含 n + 1 个整数的数组 nums，
 其数字都在 1 到 n 之间（包括 1 和 n），
 可知至少存在一个重复的整数。
 假设只有一个重复的整数，找出这个重复的数
 *
 *
 *
 */
public class FindDuplicate_287 {

    /***
     * 题解： 二分查找
     * 关键点： 用cnt[i] 表示 nums 数组 中小于等于 i的元素个数
     * 二分查找： 假设重复数target, 那么[1,target-1] 里的所有数满足 cnt[i] <= i,  [target, n]里的所有数满足cnt[i] > i, 具有单调性，
     * 目标：找到第一个大于 i > cnt的值；
     * eg: [1,3,4,2,2]
     * i         1     2    3    4
     * cnt[i]    1     3    4    5
     *
     * 该性质证明：
     * 1）target 出现两次，小于target的 cnt[i] = i, 大于等于target的数j 满足 cnt[j]= j + 1;
     * 2) target出现三次及以上，有一些数不在nums数组，相当于我们用target去替换了这些数
     *     如果替换的i小于target, 那么 [i, target-1]的cnt值减1，其他不变；
     *     如果替换的j大于等于target, 那么[target, j-1]的cnt均加 1，满足条件；
     *
     *
     */
    public int findDuplicate_BinarySearch(int[] nums) {
        int n  = nums.length;
        int l =1, r = n-1;
        while(l <=r ){
           int mid = l + (r -l)/2;
            int cnt = cntLessEqual(nums, mid);
            if(cnt > mid){//查找第一个满足条件的
                r = mid -1;
            } else {
                l = mid +1;
            }
        }
        return l;
    }

    private int cntLessEqual(int[] nums, int target){
        int cnt = 0;
        for(int n:nums){
            if(n <= target){
                cnt++;
            }
        }
        return cnt;
    }
}
