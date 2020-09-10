package com.xu.leetcode.disjointset;

/**
 * Created by sop on 2020/2/22.
 */
public class UnionFind {
    private int count=0;
    private int[] parent, rank;

    public UnionFind(int n){
        count = n;
        parent = new int[n];
        rank = new int[n];
        for(int i=0; i<n ;i++){
            parent[i] = i;
        }
    }
    public int find(int p) {
        while (parent[p] != p) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
    public void union(int p, int q){
        int rootP = find(p);
        int rootQ = find(q);
        if(rootP == rootQ) return;
        if(rank[rootP] > rank[rootQ]){
            parent[rootQ] = rootP;
            rank[rootP] += rank[rootQ];
        }else{
            parent[rootP] =rootQ;
            rank[rootQ] += rank[rootP];
        }
        count --;
    }

    public int count() {
        return count;
    }
}
