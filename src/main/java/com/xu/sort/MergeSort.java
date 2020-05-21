package com.xu.sort;

/**
 * Created by sop on 2020/3/23.
 */
public class MergeSort {

    /***
     * 归并排序算法
     * @param arr
     */
    public void sort(int[] arr){
        int len = arr.length;
        int[] temp = new int[len];
        mergeSort(arr, 0, len-1, temp);
    }


    //两路归并算法，两个排好序的子序列合并为一个子序列
    public void merge2(int[] nums,int left,int mid,int right, int[] temp){
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {

            if (i == mid + 1) {   //左子区间 遍历完毕
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {  //右子区间 遍历完毕
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
            }
        }

    }


    //两路归并算法，两个排好序的子序列合并为一个子序列
    public void merge(int []a,int left,int mid,int right, int[] temp){
        int p1=left,p2=mid+1,k=left;//p1、p2是检测指针，k是存放指针

        while(p1<=mid && p2<=right){
            if(a[p1]<=a[p2])
                temp[k++]=a[p1++];
            else
                temp[k++]=a[p2++];
        }

        while(p1<=mid) temp[k++]=a[p1++];//如果第一个序列未检测完，直接将后面所有元素加到合并的序列中
        while(p2<=right) temp[k++]=a[p2++];//同上

        //复制回原数组
        for (int i = left; i <=right; i++){
            a[i]=temp[i];
        }

    }

    public void mergeSort(int [] a,int start,int end, int[] temp){
        if(start < end){//当子序列中只有一个元素时结束递归
            int mid= start + (end -start)/2;//划分子序列
            mergeSort(a, start, mid, temp);//对左侧子序列进行递归排序
            mergeSort(a, mid+1, end, temp);//对右侧子序列进行递归排序
            merge(a, start, mid, end, temp);//合并
        }
    }

}
