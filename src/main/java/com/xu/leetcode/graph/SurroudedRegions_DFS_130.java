package com.xu.leetcode.graph;

/**
 * Created by sop on 2020/2/23.
 *
 * 先从边界开始遍历，DFS查找连通分量
 */
public class SurroudedRegions_DFS_130 {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0); //0列
            dfs(board, i, n - 1); //n-1列
        }
        for (int j = 0; j < n; j++) {
            dfs(board, 0, j);  //0行
            dfs(board, m - 1, j); //m-1行
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == 'X' || board[i][j] == '#') {
            return;
        }
        board[i][j] = '#';
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
    }

}
