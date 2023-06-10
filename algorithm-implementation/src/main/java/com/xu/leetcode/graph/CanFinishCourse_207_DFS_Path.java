package com.xu.leetcode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * @author xushichao
 * @date 2023/5/23 22:52
 * @desc  以出度为切入点，  出度为0的入栈
 *
 * 我们可以将深度优先搜索的流程与拓扑排序的求解联系起来，用一个栈来存储所有已经搜索完成的节点。
 * 假设我们当前搜索到了节点 u，如果它的所有相邻节点都已经搜索完成，那么这些节点都已经在栈中了，此时我们就可以把 u 入栈。
 * 可以发现，如果我们从栈顶往栈底的顺序看，由于 u 处于栈顶的位置，那么 u 出现在所有 u 的相邻节点的前面。因此对于 u 这个节点而言，它是满足拓扑排序的要求的。
 *
 * 这样以来，我们对图进行一遍深度优先搜索。当每个节点进行回溯的时候，我们把该节点放入栈中。最终从栈顶到栈底的序列就是一种拓扑排序。

 * 链接：https://leetcode.cn/problems/course-schedule/solutions/359392/ke-cheng-biao-by-leetcode-solution/
 *
 * 任务：只判断是否有环
 */
public class CanFinishCourse_207_DFS_Path {

    private int[] visited; // 0：未搜索， 1：搜索中， 2：已完成
    //默认可以完成，无环
    private boolean valid = true;

    private Stack<Integer> stack;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //深度优先搜索解决，先转换为Graph G，邻接表模式
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        visited = new int[numCourses];
        stack = new Stack<>();
        for(int i=0; i<numCourses;i++){
            graph[i] = new ArrayList<>();
        }
        // [1,0]  => 1 => 0
        for(int i=0; i<prerequisites.length; i++){
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        for(int i=0; i<numCourses && valid; i++) {
            if(visited[i] == 0) {
                dfs(graph, i);
            }
        }
        if(!valid) {
            return new int[0];
        }
        int[] res = new int[numCourses];
        int i=0;
        while(!stack.isEmpty()) {
            res[i++] = stack.pop();
        }
        return res;
    }

    private void dfs(ArrayList<Integer>[] graph,  int u) {
        visited[u] = 1;
        for(int v: graph[u]) {
            if(visited[v] == 0) {
                dfs(graph, v);
                if(!valid) {
                    return;
                }
            } else if(visited[v] == 1) {
                valid=false;
                return;
            }
        }
        visited[u] = 2;
        stack.push(u);
    }



    public static void main(String[] args) {
        CanFinishCourse_207_DFS_Path path = new CanFinishCourse_207_DFS_Path();
        int[][] pre = new int[][]{{1,0},{2,0},{3,1},{3,2}};
        int numberCourses = 4;
        int[] res = path.findOrder(numberCourses, pre);

        Arrays.stream(res).forEach(System.out::println);

    }



}
