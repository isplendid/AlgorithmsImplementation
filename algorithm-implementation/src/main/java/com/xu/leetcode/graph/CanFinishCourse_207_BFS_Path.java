package com.xu.leetcode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xushichao
 * @date 2023/5/23 22:39
 * @desc
 *
 * 以入度为切入点  ： 队列  广度优先搜索
 * 以出度为切入点： 深度优先搜索
 */
public class CanFinishCourse_207_BFS_Path {

    private int[] inDegrees; //每个节点入度

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        int[] result = new int[numCourses];
        inDegrees = new int[numCourses];
        int k = 0;

        for(int i=0; i<numCourses;i++){
            graph[i] = new ArrayList<>();
        }
        // [1,0]  => 1 => 0
        for(int i=0; i<prerequisites.length; i++){
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
            inDegrees[prerequisites[i][0]]++;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        // 将所有入度为 0 的节点放入队列中
        for(int i=0; i<numCourses; i++) {
            if(inDegrees[i] == 0) {
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()) {
            int u = queue.poll();
            result[k++] = u;

            for(int v: graph[u]) {
                inDegrees[v]--;
                // 如果相邻节点 v 的入度为 0，就可以选 v 对应的课程了
                if(inDegrees[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        if(k != numCourses) {
            return new int[0];
        }
        return result;
    }


    public static void main(String[] args) {
        CanFinishCourse_207_BFS_Path path  =new CanFinishCourse_207_BFS_Path();
        int[][] pre = new int[][]{{1,0},{2,0},{3,1},{3,2}};
        int numberCourses = 4;
        int[] res = path.findOrder(numberCourses,pre);
        Arrays.stream(res).forEach(System.out::println);

    }


}
