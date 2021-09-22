package com.xu.leetcode.array;

/**
 * @author xushichao
 * @date 2021/9/17 10:59 PM
 * @desc 9*9宫格
 */
public class IsValidSudoku_36 {

    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9]; //rows[i][index] 表示第i行 数字index+1的个数
        int[][] cols = new int[9][9]; //cols[j][index] 表示第j列 数字index+1的个数
        int[][][] sub = new int[3][3][9];//sub[i][j][index] 表示 小九宫格的计数
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int index = c - '0' - 1;
                    rows[i][index]++;
                    cols[j][index]++;
                    sub[i / 3][j / 3][index]++;
                    if (rows[i][index] > 1 || cols[j][index] > 1 || sub[i / 3][j / 3][index] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
