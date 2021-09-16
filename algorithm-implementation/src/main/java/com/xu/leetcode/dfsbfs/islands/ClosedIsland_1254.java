package com.xu.leetcode.dfsbfs.islands;

/**
 * Created by sop on 2020/5/24.
 *
 * 如果一座岛屿 完全 由水域包围，即陆地边缘上下左右所有相邻区域都是水域，那么我们将其称为 「封闭岛屿」。
 *
 * 解释：不与边界接壤
 */
public class ClosedIsland_1254 {

    public int closedIsland(int[][] grid) {
        int count=0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j < grid[0].length; j++){
                if(grid[i][j] == 0){
                    if(!dfs(grid,i,j)){
                        count++;
                    }
                }
            }
        }
        return count;

    }
    //dfs 返回是否触达边界
    private boolean dfs(int[][] grid, int r, int c){
        if(!inArea(grid,r,c)){
            return true;
        }
        if(grid[r][c] != 0){ //如果是海洋1或者2，无需再访问直接返回即可
            return false;
        }
        grid[r][c]= 2;
        //不要串接直接返回，短路
        boolean left = dfs(grid, r,c-1);
        boolean right = dfs(grid, r, c+1);
        boolean up = dfs(grid, r-1, c);
        boolean down = dfs(grid, r+1, c);
        return left || right || up || down;

    }
    private boolean inArea(int[][] grid, int r, int c){
        return 0<=r && r<grid.length
                && 0 <=c && c< grid[0].length;
    }
}
