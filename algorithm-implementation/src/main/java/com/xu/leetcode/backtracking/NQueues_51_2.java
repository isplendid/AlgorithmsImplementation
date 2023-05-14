package com.xu.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xushichao
 * @date 2022/7/24 5:18 PM
 * @desc
 */
public class NQueues_51_2 {

    private List<List<String>>  res = new ArrayList<>();
    private static final char DOT = '.';
    private static final char Q = 'Q';

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        //初始化空棋盘
        for (int i = 0; i < n; i++) {
            for(int j=0;j<n; j++){
                board[i][j] = DOT;
            }
        }
        backTrack(board, 0);
        return res;
    }

    private void backTrack(char[][]  board, int row) {
        if(row == board.length) {
            res.add(trans2List(board));
            return;
        }
        int n = board[row].length;
        for(int col = 0; col < n ; col ++) {
            if(!valid(board, row, col)){
                continue;
            }
            //做选择
            board[row][col] = Q;
            //进入下一行决策
            backTrack(board, row + 1);
            //撤销选择
            board[row][col] = DOT;
        }

    }

    private boolean valid(char[][] board, int row, int col) {
        int n = board.length;
        // 检查列是否有皇后互相冲突
        for(int i=0; i<n; i++){
            if(board[i][col] == Q){
                return false;
            }
        }
        // 检查右上方是否有皇后互相冲突
        for(int i= row-1, j = col+1; i>=0 && j <n; i--, j++ ){
            if(board[i][j] == Q){
                return false;
            }
        }

        // 检查左上方是否有皇后互相冲突
        for(int i=row-1, j=col-1; i>=0 && j >=0; i--,j--) {
            if(board[i][j] == Q){
                return false;
            }
        }

       return true;
    }

    private List<String> trans2List(char[][] board) {
        List<String> list = new ArrayList<>();
        for(char[] arr: board){
            list.add(new String(arr));
        }
        return list;
    }



    public static void main(String[] args) {
        int n =4;
        NQueues_51_2 queue = new NQueues_51_2();
        queue.solveNQueens(n);
    }
}
