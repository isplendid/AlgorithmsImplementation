package com.xu.leetcode.dfsbfs.islands;

/**
 * Created by sop on 2020/5/24.
 *https://leetcode-cn.com/problems/number-of-islands/solution/dao-yu-lei-wen-ti-de-tong-yong-jie-fa-dfs-bian-li-/
 * 岛屿数量
 */
public class NumsOfIslands_200 {
    public int numIslands(char[][] grid) {
        int count=0;
        int m = grid.length;
        if(m==0) return 0;
        int n = grid[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1'){
                    dfs(grid,i,j);
                    count ++;
                }
            }
        }
        return count;

    }

    private void dfs(char[][] grid, int r, int c){
        if(!inArea(grid,r,c)){
            return;
        }
        if(grid[r][c] != '1'){
            return;
        }
        grid[r][c]='2';

        dfs(grid,r,c+1);
        dfs(grid,r,c-1);
        dfs(grid,r-1, c);
        dfs(grid,r+1, c);

    }
    private boolean inArea(char[][] grid, int r, int c){
        return 0<=r && r<grid.length
                && 0 <=c && c< grid[0].length;
    }
}
