package com.xu.leetcode.dfsbfs.dfs;

/**
 * Created by sop on 2020/7/26.
 */
public class LongestIncreasingPath_dfs_329 {
    public int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int rows, columns;

    /**
     * dp[x][y] =  max(dp[x][y], 1 + dfs(mat, tx, ty));
     *
     * @param matrix
     * @return
     */
    public int longestIncreasingPath(int[][] matrix) {
        rows = matrix.length;
        if (rows == 0) {
            return 0;
        }
        int res = 0;
        columns = matrix[0].length;
        int[][] memo = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                res = Math.max(res, dfs(matrix, i, j, memo));
            }
        }
        return res;
    }

    private int dfs(int[][] matrix, int r, int c, int[][] memo) {
        if (memo[r][c] != 0) {
            return memo[r][c];
        }
        ++memo[r][c];
        for (int[] dir : dirs) {
            int newRow = r + dir[0], newColumn = c + dir[1];
            if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns && matrix[newRow][newColumn] > matrix[r][c]) {
                memo[r][c] = Math.max(memo[r][c], dfs(matrix, newRow, newColumn, memo) + 1);
            }
        }
        return memo[r][c];
    }


}
