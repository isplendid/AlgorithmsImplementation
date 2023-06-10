package com.xu;

/**
 * @author xushichao
 * @date 2023/5/13 16:21
 * @desc
 *
 * 4,5,6,7,9,10
 * 7,9,4,5,10
 *
 *
 * n
 * n/2 大的数
 * n-1/2 , n+1/2
 */
public class Main {


    public int findMedium(int[] arr) {
        int k = arr.length / 2;
        return topK(arr, k, 0, arr.length - 1);
    }

    private int topK(int[] arr, int k, int l, int r) {

        int p = partition(arr, l, r);
        if (p == k) {
            return arr[p];
        } else if (p < k) {
            return topK(arr, k, p + 1, r);
        } else {
            return topK(arr, k, l, p - 1);
        }
    }


    private int partition(int[] arr, int lo, int hi) {
        int pivot = arr[lo];
        while (lo < hi) {
            while (lo < hi && arr[hi] >= pivot) {
                hi--;
            }
            arr[lo] = arr[hi];
            while (lo < hi && arr[lo] < pivot) {
                lo++;
            }
            arr[hi] = arr[lo];
        }

        arr[lo] = pivot;
        return lo;
    }

    public static void main (String[] args){
        Main main = new Main();
        int[] arr = new int[]{17, 9, 4, 5, 10};
        int res = main.findMedium(arr);
        System.out.println(res);
    }

}
