package com.xu.leetcode.dfsbfs;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by sop on 2020/3/15.
 * https://leetcode-cn.com/problems/max-area-of-island/solution/javaban-3chong-jie-fa-by-wang_dong/
 *
 * . 岛屿的最大面积
 */
public class MaxAreaOfIsland_695 {

    /***
     * 深度优先搜索（递归实现）
     * Time: O(M*N) , 访问每个网格最多一次
     * Space: O(M*N)  递归的深度最大可能是整个网格的大小，因此最大可能使用 O(M*N)的栈空间
      * @param grid
     * @return
     */
    public int maxAreaOfIsland_dfs(int[][] grid) {

        int maxArea = 0;
        for(int i=0; i<grid.length;i++){
            for(int j=0; j<grid[0].length; j++){
                maxArea = Math.max(maxArea, dfs(grid, i, j));

            }
        }
        return maxArea;
    }

    //通过将经过的岛屿设置为0来确保下次不会重复访问
    private int  dfs(int[][] grid, int i, int j){
        if(i<0 || j<0 || i>= grid.length || j >= grid[0].length || grid[i][j] == 0){
            return 0;
        }
        grid[i][j]= 0;

        int up = dfs(grid, i-1, j);
        int down = dfs(grid, i+1,j);
        int left = dfs(grid, i, j-1);
        int right = dfs(grid, i, j+1);
        return up+down+left+right +1;
    }


    /***
     *  深度优先搜索 + 栈
     *  方法一通过函数的调用来表示接下来想要遍历哪些土地，让下一层函数来访问这些土地。
     *  而方法二把接下来想要遍历的土地放在栈里，然后在取出这些土地的时候访问它们。
     *  访问每一片土地时，我们将对围绕它四个方向进行探索，找到还未访问的土地，加入到栈 stack 中；
     *  ，只要栈 stack 不为空，就说明我们还有土地待访问，那么就从栈中取出一个元素并访问。
     * @param grid
     * @return
     */
    public int maxAreaOfIsland_dfs_stack(int[][] grid){
        Deque<int[]> stack = new LinkedList<>();

        int[][] moveIndexArray = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                stack.add(new int[]{i, j});
                //计算最大面积
                int currMaxArea = 0;
                while (!stack.isEmpty()) {
                    int[] pop = stack.pop();
                    int currI = pop[0];
                    int currJ = pop[1];
                    if (currI < 0 || currI >= grid.length || currJ < 0 || currJ >= grid[0].length || grid[currI][currJ] == 0) {
                        continue;
                    }
                    currMaxArea++;
                    grid[currI][currJ] = 0;
                    for (int[] moveIndex : moveIndexArray) {
                        stack.add(new int[]{currI + moveIndex[0], currJ + moveIndex[1]});
                    }
                }
                maxArea = Math.max(currMaxArea, maxArea);
            }
        }

        return maxArea;
    }


    /***
     * 广度优先遍历(队列实现)
     * @param grid
     * @return
     */
    public int maxAreaOfIsland_bfs_queue(int[][] grid){
        Deque<int[]> queue = new LinkedList<>();

        int[][] moveIndexArray = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                queue.add(new int[]{i, j});
                //计算最大面积
                int currMaxArea = 0;
                while (!queue.isEmpty()) {
                    int size = queue.size();
                    for (int k = 0; k < size; k++) {
                        int[] poll = queue.poll();
                        int currI = poll[0];
                        int currJ = poll[1];
                        if (currI < 0 || currI >= grid.length || currJ < 0 || currJ >= grid[0].length || grid[currI][currJ] == 0) {
                            continue;
                        }
                        currMaxArea++;
                        grid[currI][currJ] = 0;
                        for (int[] moveIndex : moveIndexArray) {
                            queue.offer(new int[]{currI + moveIndex[0], currJ + moveIndex[1]});
                        }
                    }
                }
                maxArea = Math.max(currMaxArea, maxArea);
            }
        }

        return maxArea;
    }


}
