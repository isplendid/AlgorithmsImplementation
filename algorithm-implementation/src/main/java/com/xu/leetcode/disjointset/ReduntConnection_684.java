package com.xu.leetcode.disjointset;

/**
 * Created by sop on 2020/2/23.
 */
public class ReduntConnection_684 {

    public static int[] findRedundantConnection(int[][] edges) {
        int M = edges.length;
        BooleanUnionFind uf = new BooleanUnionFind(M);
        for(int[] edge: edges){
            if(!uf.union(edge[0], edge[1])){
                return edge;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[][] edges = new int[][]{{1,2},{1,3},{2,3}};
        int[] res = findRedundantConnection(edges);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}
