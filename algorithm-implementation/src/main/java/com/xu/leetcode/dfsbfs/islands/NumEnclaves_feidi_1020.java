package com.xu.leetcode.dfsbfs.islands;

/**
 * Created by sop on 2020/5/31.
 *
 * 给出一个二维数组 A，每个单元格为 0（代表海）或 1（代表陆地）。

 移动是指在陆地上从一个地方走到另一个地方（朝四个方向之一）或离开网格的边界。
 给出一个二维数组 A，每个单元格为 0（代表海）或 1（代表陆地）。

 移动是指在陆地上从一个地方走到另一个地方（朝四个方向之一）或离开网格的边界。
 */
public class NumEnclaves_feidi_1020 {

    private int nums = 0;
    public int numEnclaves(int[][] A) {
        if(A == null || A.length == 0) return 0;
        int r=A.length;
        int c=A[0].length;
        // 淹没所有和边界相接的陆地
        for(int i=0; i<r; i++){
            dfs(A,i,0);
            dfs(A,i,c-1);
        }
        for(int j=0; j<c; j++){
            dfs(A,0, j);
            dfs(A,r-1, j);
        }

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(A[i][j] == 1){
                    nums++;
                }
            }
        }

        return nums;
    }

    //返回是否触达边界
    private void dfs(int[][] A, int r, int c) {
        if(!inArea(A,r,c)){
            return;
        }
        if(A[r][c] == 0){
            return;
        }
        A[r][c] = 0; //海洋
        dfs(A,r,c-1);
        dfs(A,r,c+1);
        dfs(A,r-1,c);
        dfs(A,r+1,c);
    }


    private boolean inArea(int[][] grid, int r, int c){
        return 0<=r && r<grid.length
                && 0 <=c && c< grid[0].length;
    }


}
