package com.xu2023.december;

public class PeakIndexInMountainArray_852 {


    /***
     * [0,1,0]
     * @param arr
     * @return
     */
    public int peakIndexInMountainArray(int[] arr) {

        int l = 0;
        int r = arr.length  -1;

        while(l < r) {
            int mid = l + (r-l)/2;

            if(arr[mid] > arr[mid + 1]) {  //固定右边界，左边移动
                r = mid ;
            } else {
                l = mid+1;
            }
        }


        return r;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,10,8,5, 2};

        PeakIndexInMountainArray_852 p = new PeakIndexInMountainArray_852();
        int res = p.peakIndexInMountainArray(arr);
        System.out.println(res);
    }



}
