package com.xu.leetcode.heap;

/**
 * Created by sop on 2020/8/16.
 *
 * 快速排序算法 topK 第K大的数
 */
public class FindKthLargest_215 {
//    public int findKthLargest(int[] nums, int k) {
//
//    }

    public int findKthLargest_Quick(int[] nums, int k) {
        //if(nums.length <k) return -1;
        partitionArr(nums, 0, nums.length -1, nums.length-k);
        return nums[nums.length - k];
    }

    private void partitionArr(int[] arr, int lo, int hi, int k){
        int m =  partition(arr, lo, hi);
        if(k == m){
            return;
        } else if(k < m){
            partitionArr(arr, lo, m-1, k);
        }else {
            partitionArr(arr, m+1, hi, k);
        }
    }

    //查找枢轴位置
    private int partition(int[] arr, int lo, int hi){
        int pivot = arr[lo];
        while(lo < hi){
            while(lo<hi && arr[hi] >= pivot){
                hi--;
            }
            arr[lo] = arr[hi];
            while(lo<hi && arr[lo] <= pivot){
                lo++;
            }
            arr[hi] = arr[lo];
        }
        arr[lo] = pivot;
        return lo;
    }

}
