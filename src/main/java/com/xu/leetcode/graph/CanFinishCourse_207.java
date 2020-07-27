package com.xu.leetcode.graph;

import com.xu.algs.basic.In;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by sop on 2020/7/25.
 */
public class CanFinishCourse_207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        //深度优先搜索解决，先转换为Graph G，邻接表模式
        ArrayList<Integer>[] graph =  (ArrayList<Integer>[]) new ArrayList[numCourses];
        for(int i=0; i<numCourses;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<prerequisites.length; i++){
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }
         boolean[] visited = new boolean[numCourses];
         boolean[] onStack = new boolean[numCourses];
        for(int i=0; i<numCourses; i++){
            if(dfs(graph,i, visited, onStack)){
                return false;
            }
        }
        return true;
    }

    //dfs遍历，返回true: 有环， false: 无环
    private boolean dfs(ArrayList<Integer>[] graph, int v, boolean[] visited, boolean[] onStack){
        visited[v] = true;
        onStack[v] = true;
        for(int w: graph[v]){
            if(!visited[w]){
                if(dfs(graph, w, visited, onStack)){  //有环直接返回，否则往下执行
                    return true;
                }
            }else if(onStack[w]){
                return true;
            }
        }
        onStack[v]= false;
        return false;
    }

    public static void main(String[] args) {
        int nums=4;
        int[][] pre1 = new int[][]{{2,0},{1,0},{3,1},{3,2},{1,3}};
        int[][] pre2 = new int[][]{{3,0},{0,1}};
        CanFinishCourse_207 can = new CanFinishCourse_207();
        System.out.println(can.canFinish(nums, pre1));
    }


}
