package com.xu.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xushichao
 * @date 2021/9/16 8:57 PM
 * @desc 给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。
 * 与WordSearch_79类似
 */
public class FindWords_212 {


    /***
     * https://leetcode-cn.com/problems/word-search-ii/solution/gong-shui-san-xie-yi-ti-shuang-jie-hui-s-am8f/
     * 暴力搜索回溯处理
     * @param board
     * @param words
     * @return
     */
    public List<String> findWords(char[][] board, String[] words) {

        List<String> res = new ArrayList<>();

        for (String word : words) {
            if (findWords(board, word)) {
                res.add(word);
            }
        }
        return res;
    }

    private boolean findWords(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j] && dfs(board, word, i, j, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }


    private boolean dfs(char[][] board, String word, int i, int j, int index, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word.charAt(index) || visited[i][j]) {
            return false;
        }

        visited[i][j] = true;

        if (dfs(board, word, i - 1, j, index + 1, visited) ||
                dfs(board, word, i + 1, j, index + 1, visited) ||
                dfs(board, word, i, j - 1, index + 1, visited) ||
                dfs(board, word, i, j + 1, index + 1, visited)) {
            return true;
        }
        //撤销选择
        visited[i][j] = false;
        //未找到
        return false;
    }

    public static void main(String[] args) {

    }
}
