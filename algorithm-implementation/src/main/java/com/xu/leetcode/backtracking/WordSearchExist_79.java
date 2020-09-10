package com.xu.leetcode.backtracking;

/**
 * Created by sop on 2020/3/1.
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
  链接：https://leetcode-cn.com/problems/word-search
  深度优先搜索

 */
public class WordSearchExist_79 {

    private  static boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        visited = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(word.charAt(0) == board[i][j] && dfs(board, word, i, j ,0)){
                    return true;
                }
            }
        }
        return false;

    }

    private boolean dfs(char[][] board, String word, int i, int j, int index){
        if(index == word.length()){
            return true;
        }
        if(i>=board.length || i<0 || j>=board[0].length || j<0 ||board[i][j] != word.charAt(index) || visited[i][j]){
            return false;
        }
        visited[i][j] = true;

        if(dfs(board, word, i-1, j, index+1) ||
                dfs(board, word, i+1, j, index+1) ||
                dfs(board, word, i, j-1, index+1) ||
                dfs(board, word, i, j+1, index+1)){
            return true;
        }
        visited[i][j] = false;
        return false;
    }
}
