package com.xu.leetcode.backtracking;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author xushichao
 * @date 2021/9/19 10:15 PM
 * @desc  N 皇后问题： 皇后可以攻击同一行、同一列、左上左下右上右下四个方向的任意单位。
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 */
public class NQueues_51 {

    private List<List<String>>  res = new ArrayList<>();
    private static final char DOT = '.';
    private static final char Q = 'Q';

    public List<List<String>> solveNQueens(int n) {
        // '.' 表示空，'Q' 表示皇后，初始化空棋盘。
        char[][] board = new char[n][n];
        for(int i=0; i<n;i++){
            for(int j=0; j<n; j++) {
               board[i][j] = DOT;
            }
        }
        backtrack(board,0);

       return res;

    }

    /**
     * 路径：board 中小于 row 的那些行都已经成功放置了皇后
     * 选择列表：第 row 行的所有列都是放置皇后的选择
     * 结束条件：row 超过 board 的最后一行
     * @param board
     * @param row
     */
    private void backtrack(char[][] board, int row){
        if(row == board.length){
            //加入结果集合
            res.add(transform2List(board));
            return;
        }

        int n = board[row].length;
        for(int col = 0; col<n; col++){
            //排除不合法选择
            if(!valid(board, row, col)){
                continue;
            }
            //做选择
            board[row][col] = Q;
            //进入下一行决策
            backtrack(board, row+1);
            //撤销选择
            board[row][col] = DOT;
        }

    }

    /**
     * 是否可以在 board[row][col] 放置皇后？
     * @param board
     * @param row
     * @param col
     * @return
     */
    private boolean valid(char[][] board, int row, int col){
        int n = board.length;
        // 检查列是否有皇后互相冲突
        for(int i=0; i<n;i++){
            if(board[i][col] == Q){
                return false;
            }
        }
        // 检查右上方是否有皇后互相冲突
        for(int i=row-1, j = col+1; i>=0 && j<n; i--, j++){
            if(board[i][j] == Q){
                return false;
            }
        }

        // 检查左上方是否有皇后互相冲突
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--){
            if(board[i][j] == Q){
                return false;
            }
        }
        return true;
    }
    private List<String> transform2List(char[][] board){
        List<String> list = new ArrayList<>();
        for(int i=0; i<board.length; i++){
            list.add(new String(board[i]));
        }
        return list;
    }

    public static void main(String[] args) {
        NQueues_51 queues = new NQueues_51();
//        char[][] chars = new char[][]{{'.','Q'}, {'Q','.'}};
//        System.out.println(queues.transform2List(chars));
        int n =4;
        System.out.println(queues.solveNQueens(n));

    }

}
