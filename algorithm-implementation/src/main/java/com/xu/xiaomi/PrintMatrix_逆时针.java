//package com.xu.xiaomi;
//
//import java.util.ArrayList;
//
///**
// * Copyright (c) 2020 XiaoMi Inc. All Rights Reserved.
// * Authors: Xu Shichao <xushichao@xiaomi.com> on 2020/8/11.
// * Description:
// * <p>
// * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。例如如果输入如下4 X 4矩阵， 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
// * 1    2    3   4
// * 5   6    7    8
// * 9   10  11  12
// * 13 14  15 16
// * <p>
// * <p>
// * 技术点： 画图让抽象形象化
// * 思路：用左上和右下的坐标定位出一次要旋转打印的数据，一次旋转打印结束后，往对角分别前进和后退一个单位。注意单行或者单列的情况。
// */
//public class PrintMatrix_逆时针 {
//
//    public ArrayList<Integer> printMatrix(int[][] matrix) {
//        int row = matrix.length;
//        int col = matrix[0].length;a
//        ArrayList<Integer> res = new ArrayList<>();
//        if (row == 0 || col == 0) {
//            return res;
//        }
//        int left = 0, top = 0, right = col - 1, bottom = row - 1; // 定义四个关键变量，表示左上和右下的打印范围
//        while (left <= right && top <= bottom) {
//            for (int i = left; i <= right; ++i) {
//                res.add(matrix[top][i]);//从左到右
//            }
//            for (int i = top + 1; i <= bottom; ++i) {
//                res.add(matrix[i][right]);//从上到下
//            }
//            if (top != bottom) {
//                for (int i = right - 1; i >= left; --i) {
//                    res.add(matrix[bottom][i]);//从右到左
//                }
//            }
//            if (left != right) {
//                for (int i = bottom - 1; i > top; --i) {
//                    res.add(matrix[i][left]);//从下到上
//                }
//            }
//            left++;
//            top++;
//            right--;
//            bottom--;//缩小一圈，重新定位打印范围
//        }
//        return res;
//    }
//}
