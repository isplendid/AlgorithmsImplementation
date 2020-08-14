package com.xu.leetcode.graph;

import java.util.*;

/**
 * Created by sop on 2020/7/26.
 *
 */
public class MinHeightTree_topsort_310 {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
         List<Integer> res = new ArrayList<>();
        if(n==1){
            Collections.singletonList(0);
        }
        int[] indegree = new int[n];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0; i<n;i++){
            graph.put(i, new ArrayList<Integer>());
        }
        for(int[] pair : edges){
            graph.get(pair[0]).add(pair[1]);
            graph.get(pair[1]).add(pair[0]);
            indegree[pair[0]]++;
            indegree[pair[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i< n; i++){
            if(indegree[i] == 1) {
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            while(size -- >0){
                int cur = queue.poll();
                list.add(cur);
                for(int neighBour: graph.get(cur)){
                    indegree[neighBour] --;
                    if(indegree[neighBour] == 1){
                        queue.offer(neighBour);
                    }
                }
            }
            res = list; //暂存最后一层节点
        }
        return res;
    }
}
