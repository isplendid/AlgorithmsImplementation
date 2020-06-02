package com.xu.leetcode.sort;

/**
 * Created by sop on 2020/6/2.
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 *
 *
 */
public class Ksmallest_interview_17_14 {

    /***
     * Time: O(N)  ,数组就被分成了两部分。如果是快速排序算法，
     * 会在这里递归地对两部分进行快速排序，时间复杂度为 O(NlogN)
     * 由于知道要找的第 N - k 小的元素在哪部分中，我们不需要对两部分都做处理，
     * 这样就将平均时间复杂度下降到 O(N)
     * 本算法也适用于有重复的数组
     *
     *  时间复杂度 : 平均情况 O(N)，最坏情况 O(N2)
     *  因此时间复杂度是N + N/2 + N/4 + ... + N/N = 2N, 因此时间复杂度是O(N)
     空间复杂度 : O(1)。
     * @param arr
     * @param k
     * @return
     */
    public int[] smallestK(int[] arr, int k) {
        if( k==0) {
            return new int[0];
        } else if(arr.length <= k){
            return arr;
        }
        partitionArr(arr, 0, arr.length -1, k);

        int[] res = new int[k];
        for(int i=0; i<k; i++){
            res[i] = arr[i];
        }
        return res;
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
