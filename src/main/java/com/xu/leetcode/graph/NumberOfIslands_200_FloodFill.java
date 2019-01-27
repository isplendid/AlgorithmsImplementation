package com.xu.leetcode.graph;

/**
 * Created by sop on 2018/12/2.
 * https://leetcode.com/problems/number-of-islands/
 * iven a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and
 * is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 */

 class Solution200 {

    private int n;
    private int m;

    public int numIslands(char[][] grid) {
        int count = 0;
        n = grid.length;
        if (n == 0) return 0;
        m = grid[0].length;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++)
                if (grid[i][j] == '1') {
                    DFSMarking(grid, i, j);
                    ++count;
                }
        }
        return count;
    }

    /***
     * 将上下左右相连的1 标为 0； 然后计算有几次遍历
     * @param grid
     * @param i
     * @param j
     */
    private void DFSMarking(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') return;
        grid[i][j] = '0';
        DFSMarking(grid, i + 1, j);
        DFSMarking(grid, i - 1, j);
        DFSMarking(grid, i, j + 1);
        DFSMarking(grid, i, j - 1);
    }
}
public class NumberOfIslands_200_FloodFill {
}
