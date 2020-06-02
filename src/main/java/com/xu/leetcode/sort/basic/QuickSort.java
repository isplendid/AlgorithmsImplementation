package com.xu.leetcode.sort.basic;

/**
 * Created by sop on 2020/5/31.
 */
public class QuickSort {
     public void quickSort(int[] A, int low, int high){
         if(low >= high) {
             return;
         }
         int pos = partition(A, low, high);//快速排序的切分
         quickSort(A, low, pos-1); //排序左半部分 A[low..pos-1]
         quickSort(A, pos+1, high); //排序由半部分 A[pos+1..high]
     }

    private int partition(int[] A, int low, int high){
         int pivot = A[low];
        while(low < high){
            while(low < high && A[high] >= pivot){
                high--;
            }
            A[low] = A[high];

            while(low < high && A[low] <= pivot){
                low++;
            }
            A[high] = A[low];
        }
        //最终 low = high
        A[low] = pivot;
        return low;
    }

    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        int[] A = new int[]{10,9,3,8, 4,7,2};
        qs.quickSort(A,0,A.length-1);
        for(int a:A){
            System.out.println(a);
        }

    }

}
