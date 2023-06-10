package com.xu2023;

/**
 * @author xushichao
 * @date 2023/5/27 19:05
 * @desc
 */
public class MaxMultiplySubarray {

    public int max(int[] arr) {
        if(null==arr || arr.length==0) {
            return 0;
        }
        int[] dpMax = new int[arr.length];
        int[] dpMin = new int[arr.length];
        dpMax[0] = arr[0];
        dpMin[0] = arr[0];

        int res = Integer.MIN_VALUE;

        for(int i=1; i<arr.length; i++) {
            dpMax[i] = Math.max(dpMax[i-1] * arr[i],  Math.max(dpMin[i-1] * arr[i], arr[i]));
            dpMin[i] = Math.min(dpMin[i-1] * arr[i], Math.min(dpMax[i-1]* arr[i], arr[i]));
            res = Math.max(res, dpMax[i]);
        }

        return res;
    }

    // 询问数据量，边界条件
    //
    public static void main(String[] args) {
        //
       int[] arr = new int[] {2,3,-2,4};

       MaxMultiplySubarray test = new MaxMultiplySubarray();
       int res = test.max(arr);
        System.out.println(res);

    }

}
