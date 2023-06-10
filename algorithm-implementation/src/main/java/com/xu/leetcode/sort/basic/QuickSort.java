package com.xu.leetcode.sort.basic;

import java.util.Random;

/**
 * Created by sop on 2020/5/31.
 * <p>
 * T(N) = 2T(N/2) + O(N)
 */
public class QuickSort {
    public void quickSort(int[] A, int low, int high) {
        if (low >= high) {
            return;
        }
        int pos = partition(A, low, high);//快速排序的切分
        quickSort(A, low, pos - 1); //排序左半部分 A[low..pos-1]
        quickSort(A, pos + 1, high); //排序右半部分 A[pos+1..high]
    }

    /**
     * 时间复杂度 O(N)
     *
     * @param A
     * @param low
     * @param high
     * @return
     */
    private int partition(int[] A, int low, int high) {
        int pivot = A[low]; //随机选择  pivot = A[left + random.nextInt(right - left + 1)];
        while (low < high) {
            while (low < high && A[high] >= pivot) {  //挖坑A[low] , 将A[high]填上 A[low]上
                high--;
            }
            A[low] = A[high];

            while (low < high && A[low] < pivot) { // A[low]的值 填到 A[high]的坑上
                low++;
            }
            A[high] = A[low];   //或者直接swap(A,low,high)亦可
        }
        //最终 low = high
        A[low] = pivot;
        return low;
    }


    //随机选择枢轴元素
    private int randomPartition(int[] arr, int low, int high) {
        int i = new Random().nextInt(high - low + 1) + low;
        swap(arr, i, low);
        return partition(arr, low, high);
    }



    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }




    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        int[] A = new int[]{10, 9, 3, 8, 4, 7, 2};
        qs.quickSort(A, 0, A.length - 1);
        for (int a : A) {
            System.out.println(a);
        }
        Random random = new Random();
        int l = 10, r = 10;
        int res = random.nextInt(r - l + 1);
    }

}
