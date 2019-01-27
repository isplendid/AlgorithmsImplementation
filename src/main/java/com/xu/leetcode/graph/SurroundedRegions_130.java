package com.xu.leetcode.graph;

import java.util.LinkedList;

/**
 * Created by sop on 2018/12/23.
 * https://leetcode.com/problems/surrounded-regions/
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

 A region is captured by flipping all 'O's into 'X's in that surrounded region.
 Example:

 X X X X
 X O O X
 X X O X
 X O X X
 After running your function, the board should be:

 X X X X
 X X X X
 X X X X
 X O X X
 */
public class SurroundedRegions_130 {

    class Point{
        int x,y;
        Point(int i,int j){
            x=i;
            y=j;
        }
    }




    public void solve(char[][] board) {
        int m = board.length;
        if(m==0) return;
        int n = board[0].length;
        if(n==0) return;
        for(int i=0; i<m; i++){  // col 0 & n-1;
            bfs(board,i,0);
            bfs(board,i,n-1);
        }
        for(int j=0; j<n; j++){  //row 0 & m-1;
            bfs(board,0,j);
            bfs(board,m-1, j);
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if(board[i][j] == 'A'){
                    board[i][j] = 'O';
                }
            }
        }

    }

    private void bfs(char[][] board, int x, int y){
        if(board[x][y] != 'O'){
            return ;
        }
        LinkedList<Point> queue = new LinkedList<Point>();
        queue.add(new Point(x,y));
        board[x][y] = 'A';
        while(!queue.isEmpty()){
            Point top = queue.poll();
            int i = top.x;
            int j = top.y;
            addPoint(board, i-1, j, queue);
            addPoint(board, i+1, j, queue);
            addPoint(board, i, j-1, queue);
            addPoint(board, i, j+1, queue);
        }

    }

    private boolean addPoint(char[][] board, int x, int y, LinkedList<Point> queue){
        if(x<0 || x > board.length-1 || y<0 || y>board[0].length -1 || board[x][y] != 'O'){
            return false;
        }else {
            queue.add(new Point(x,y));
            board[x][y] = 'A';
            return true;
        }
    }
}
