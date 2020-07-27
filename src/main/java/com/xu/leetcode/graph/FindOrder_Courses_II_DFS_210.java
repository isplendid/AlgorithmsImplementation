package com.xu.leetcode.graph;

import com.xu.algs.basic.In;

import java.util.*;

/**
 * Created by sop on 2020/7/26.
 */
public class FindOrder_Courses_II_DFS_210 {

    private int[] visited;
    private Stack<Integer> stack;
    private boolean hasCycle; //是否有环

    //使用深度优先搜索解决 拓扑排序
    //用一个栈来存储所有已经搜索完成的节点
    //对于一个节点 uu，如果它的所有相邻节点都已经搜索完成，那么在搜索回溯到 u 的时候，
    // u本身也会变成一个已经搜索完成的节点。这里的「相邻节点」指的是从 u 出发通过一条有向边可以到达的所有节点
    public int[] findOrder2(int numCourses, int[][] prerequisites) {

        //标记每个节点的状态：0=未搜索，1：搜索中，2：已完成
        visited = new int[numCourses];
        stack = new Stack<>();
        Map<Integer, List<Integer>> graph = new HashMap<>(); //邻接表 表示

        for (int i = 0; i < prerequisites.length; i++) {
            int dest = prerequisites[i][0];
            int src = prerequisites[i][1];
            List<Integer> lst = graph.getOrDefault(src, new ArrayList<>());
            lst.add(dest);
            graph.put(src, lst);
        }
        for(int i=0; i<numCourses && !hasCycle; i++){
            if(visited[i] == 0){
                dfs(graph,i);
            }
        }
        if(hasCycle){
            return new int[0];
        }
        int[] res = new int[numCourses];
        for(int i=0;i < numCourses; i++){
            res[i] = stack.pop();
        }
        return res;
    }

    private void dfs(Map<Integer, List<Integer>> graph, int v){
         visited[v] = 1; //标记为搜索中
        //搜索相邻节点，只要发现有环，立即停止搜索
        for(int w: graph.getOrDefault(v, new ArrayList<>())){
            //如果 ‘未搜索’ 那么搜索相邻节点
            if(visited[w] == 0){
                dfs(graph, w);
                if(hasCycle){
                    return;
                }
            } else if(visited[w] == 1){  // 如果「搜索中」说明找到了环
                hasCycle = true;
                return;
            }
        }

        visited[v] = 2;  // 将节点标记为「已完成」
        stack.push(v);  // 将节点入栈
    }

    public static void main(String[] args) {
        int num = 2;
        int[][] prerequisites = new int[][]{{1,0}};
        FindOrder_Courses_II_DFS_210 dfs = new FindOrder_Courses_II_DFS_210();
        int[] res= dfs.findOrder2(num, prerequisites);
        Arrays.stream(res).forEach(System.out::println);
    }
}
