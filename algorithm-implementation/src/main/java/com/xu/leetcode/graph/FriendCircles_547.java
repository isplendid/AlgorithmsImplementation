package com.xu.leetcode.graph;

import java.util.ArrayList;

/**
 * Created by sop on 2018/12/2.
 * https://leetcode.com/problems/friend-circles/
 *
 * There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive in nature. For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C. And we defined a friend circle is a group of students who are direct or indirect friends.

 Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not. And you have to output the total number of friend circles among all the students.

 Example 1:
 Input:
 [[1,1,0],
 [1,1,0],
 [0,0,1]]
 Output: 2
 Explanation:The 0th and 1st students are direct friends, so they are in a friend circle.
 The 2nd student himself is in a friend circle. So return 2.
 */

class FriendCircles_547 {
    //无向图连通分量
    public int findCircleNum(int[][] M) {
        if(M.length == 0){
            return 0;
        }

        //深度优先搜索解决，先转换为Graph G，邻接表模式
        ArrayList<Integer>[] graph =  (ArrayList<Integer>[]) new ArrayList[M.length];
        for(int i=0; i<M.length; i++){
            graph[i] = new ArrayList<Integer>();   // write here,
            for(int j=0; j<M[i].length; j++){
                if(M[i][j] == 1 && (i != j)){     // i !=j
                    graph[i].add(j);
                }
            }
        }
        boolean[] marked = new boolean[M.length];
        int count = 0;
        for(int s=0; s<M.length; s++)  {
            if(!marked[s]){
                dfs(graph, s, marked);
                count++;
            }
        }
        return count;
    }
    //DepthFirstSearch
    void dfs(ArrayList<Integer>[] graph, int v, boolean[] marked){
        marked[v] = true;
        for(int w: graph[v]){
            if(!marked[w]){
                dfs(graph, w, marked);
            }
        }
    }


}

