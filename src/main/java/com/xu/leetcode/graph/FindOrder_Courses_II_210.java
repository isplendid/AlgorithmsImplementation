package com.xu.leetcode.graph;

import java.util.*;

/**
 * Created by sop on 2020/7/25.
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 * 在选修某些课程之前需要一些先修课程。 
 * 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
 * 链接：https://leetcode-cn.com/problems/course-schedule-ii
 * 拓扑排序
 */
public class FindOrder_Courses_II_210 {

    //方法一：使用基于入度的 广度优先搜索遍历
    // space & Time : O(m+n), O(m+n)
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        int[] indegree = new int[numCourses];
        int[] topOrder = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < prerequisites.length; i++) {
            int dest = prerequisites[i][0];
            int src = prerequisites[i][1];
            List<Integer> lst = adjList.getOrDefault(src, new ArrayList<>());
            lst.add(dest);
            adjList.put(src, lst);
            indegree[dest]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int i = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            topOrder[i++] = node;

            if (adjList.containsKey(node)) {
                for (Integer neighbor : adjList.get(node)) {  //改变入度
                    indegree[neighbor]--;
                    if (indegree[neighbor] == 0) {
                        queue.offer(neighbor);
                    }
                }
            }
        }//while

        if (i == numCourses) {  //通过访问的节点个数 判断是否所有课程都学完
            return topOrder;
        }
        return new int[0]; //存在环
    }
}
