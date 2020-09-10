package com.xu.leetcode.graph;

import java.util.*;

/**
 * Created by sop on 2020/7/25.
 * 方程式 除法求值
 */
public class CalcEquation_DFS_399 {

    private final static Integer ILL = -1;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int M = equations.size();
        if (M == 0) {
            return new double[0];
        }
        //深度优先搜索解决，先转换为Graph G，邻接表模式
        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        double[] res = new double[queries.size()];
        String start, end;
        for (int i = 0; i < queries.size(); i++) {
            start = queries.get(i).get(0);
            end = queries.get(i).get(1);
            res[i] = getPathWeight(start, end, new HashSet<String>(), graph);
        }
        return res;
    }

    /***
     * 计算 路径权重
     *
     * @param start
     * @param end
     * @param visited
     * @param graph
     * @return
     */
    private double getPathWeight(String start, String end, Set<String> visited, Map<String, Map<String, Double>> graph) {
        if (!graph.containsKey(start)) {
            return ILL;
        }
        if (graph.get(start).containsKey(end)) {
            return graph.get(start).get(end);
        }
        visited.add(start);
        for (Map.Entry<String, Double> neighbour : graph.get(start).entrySet()) {
            if (!visited.contains(neighbour.getKey())) {
                double leftWeight = getPathWeight(neighbour.getKey(), end, visited, graph);
                if (leftWeight != ILL) {
                    return leftWeight * neighbour.getValue();
                }
            }
        }
        return ILL;
    }

    private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        String u, v;
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            u = equations.get(i).get(0);
            v = equations.get(i).get(1);
            graph.putIfAbsent(u, new HashMap<>());
            graph.get(u).put(v, values[i]);
            graph.putIfAbsent(v, new HashMap<>());
            graph.get(v).put(u, 1 / values[i]);
        }
        return graph;
    }

    public static void main(String[] args) {
//        equations = [ ["a", "b"], ["b", "c"] ],
//        values = [2.0, 3.0],
//        queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].

//        queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
//        return [6.0, 0.5, -1.0, 1.0, -1.0 ].
    }
}
