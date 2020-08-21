//package com.xu.nowcode.arr;
//
///**
// * Created by sop on 2020/8/17.
// */
//public class PrintArray_主对角线打印 {
//
//    //方法一：
//    // 规律：先考虑一共生成几组结果（2*N -1），第 K行的 列号-行号=N-1-k
//    public int[] arrayPrint(int[][] arr, int n) {
//        int len = 2 * n - 1;//一共生成几行结果
//        int[] res = new int[n * n];
//        int index = 0;
//        for (int k = 0; k < len; k++) {
//            //规律是第 K的 列号-行号=size-1-k
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < n; j++) {
//                    if (j - i == n - 1 - k) {
//                        res[index++] = arr[i][j];
//                    }
//                }
//            }
//
//        }
//        return res;
//    }
//
//
//}
