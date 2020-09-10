package com.xu.leetcode.graph;

import java.util.*;

/**
 * Created by sop on 2020/7/26.
 */
public class FindItinerary_332 {
    public List<String> findItinerary(List<List<String>> tickets) {
         Map<String,List<String>> graph = new HashMap<>();
        for(List<String> pair: tickets){
            //因为涉及删除操作，我们用链表
            String src = pair.get(0);
            String dst  =pair.get(1);
            List<String> lst = graph.getOrDefault(src, new LinkedList<>());
            lst.add(dst);
            graph.put(src,lst);
        }
        //按目的的顶点排序
        graph.values().forEach(x -> x.sort(String:: compareTo));
        String start = "JFK";
        if(!graph.containsKey(start)){
            return Collections.EMPTY_LIST;
        }
        List<String> result = new ArrayList<>();
        dfs(graph, start, result);

        return result;
    }

    private void dfs(Map<String, List<String>> graph, String src, List<String> ans){
        List<String> nbr = graph.get(src);
        while(nbr != null &&  nbr.size() >0){
            String dest = nbr.remove(0);
            dfs(graph, dest, ans);
        }
        ans.add(0, src);//逆序插入
    }

    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        List<String> tic1 = new ArrayList<>(Arrays.asList("JFK","KUL"));
        List<String> tic2 = new ArrayList<>(Arrays.asList("JFK","NRT"));
        List<String> tic3 = new ArrayList<>(Arrays.asList("NRT","JFK"));

        tickets.add(tic1);
        tickets.add(tic2);
        tickets.add(tic3);

        FindItinerary_332 find = new FindItinerary_332();
        List<String> res = find.findItinerary(tickets);
        res.stream().forEach(System.out:: println);
    }

     void test1(){
         List<List<String>> tickets = new ArrayList<>();
         List<String> tic1 = new ArrayList<>(Arrays.asList("JFK","SFO"));
         List<String> tic2 = new ArrayList<>(Arrays.asList("JFK","ATL"));
         List<String> tic3 = new ArrayList<>(Arrays.asList("SFO","ATL"));
         List<String> tic4 = new ArrayList<>(Arrays.asList("ATL","JFK"));
         List<String> tic5 = new ArrayList<>(Arrays.asList("ATL","SFO"));
         tickets.add(tic1);
         tickets.add(tic2);
         tickets.add(tic3);
         tickets.add(tic4);
         tickets.add(tic5);
         FindItinerary_332 find = new FindItinerary_332();
         List<String> res = find.findItinerary(tickets);
         res.stream().forEach(System.out:: println);
    }
}
