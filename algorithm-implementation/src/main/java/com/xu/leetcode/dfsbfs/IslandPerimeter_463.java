package com.xu.leetcode.dfsbfs;

/**
 * Created by sop on 2020/5/24.
 * https://leetcode-cn.com/problems/number-of-islands/solution/dao-yu-lei-wen-ti-de-tong-yong-jie-fa-dfs-bian-li-/
 */
public class IslandPerimeter_463 {

    public int islandPerimeter(int[][] grid) {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    // 题目限制只有一个岛屿，计算一个即可
                    return dfs(grid, r, c);
                }
            }
        }
        return 0;
    }

    int dfs(int[][] grid, int r, int c) {
        // 函数因为「坐标 (r, c) 超出网格范围」返回，对应一条黄色的边
        if (!inArea(grid, r, c)) {
            return 1;
        }
        // 函数因为「当前格子是海洋格子」返回，对应一条蓝色的边
        if (grid[r][c] == 0) {
            return 1;
        }
        // 函数因为「当前格子是已遍历的陆地格子」返回，和周长没关系
        if (grid[r][c] != 1) {
            return 0;
        }
        grid[r][c] = 2;
        return dfs(grid, r - 1, c)
                + dfs(grid, r + 1, c)
                + dfs(grid, r, c - 1)
                + dfs(grid, r, c + 1);
    }

    // 判断坐标 (r, c) 是否在网格中
    boolean inArea(int[][] grid, int r, int c) {
        return 0 <= r && r < grid.length
                && 0 <= c && c < grid[0].length;
    }



    //朴素解法：
    //链接：https://leetcode-cn.com/problems/island-perimeter/solution/fei-chang-rong-yi-li-jie-de-si-lu-by-2020-19-2/
    public int islandPerimeter_2(int[][] grid) {
        //定义总周长res为0
        int res=0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j]==1) {
                    //每个岛屿默认4条边
                    int count=4;
                    //看它的上方的那块是不是 1，是的话count减一
                    if(i>0&&grid[i-1][j]==1)
                        count--;
                    //看它的下方的那块是不是 1，是的话count减一
                    if(i<grid.length-1&&grid[i+1][j]==1)
                        count--;
                    //看它的左方的那块是不是 1，是的话count减一
                    if(j>0&&grid[i][j-1]==1)
                        count--;
                    //看它的右方的那块是不是 1，是的话count减一
                    if(j<grid[0].length-1&&grid[i][j+1]==1)
                        count--;
                    res+=count;
                }
            }
        }
        return res;
    }


}
