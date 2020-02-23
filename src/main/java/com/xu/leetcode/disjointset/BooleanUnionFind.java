package com.xu.leetcode.disjointset;

/**
 * Created by sop on 2020/2/23.
 */
public class BooleanUnionFind {
    private int count=0;
    private int[] parent, rank;

    public BooleanUnionFind(int n){
        count = n;
        parent = new int[n+1];
        rank = new int[n+1];
        for(int i=0; i<n+1 ;i++){
            parent[i] = i;
        }
    }

    public int find(int p){
        if(p != parent[p]){
            parent[p] = find(parent[p]); //path compresssion by halving
        }
        return parent[p];
    }
    public boolean union(int p, int q){
        int rootP = find(p);
        int rootQ = find(q);
        if(rootP == rootQ) return false;
        if(rank[rootP] > rank[rootQ]){
            parent[rootQ] = rootP;
            rank[rootP] += rank[rootQ];
        }else{
            parent[rootP] =rootQ;
            rank[rootQ] += rank[rootP];
        }
        count --;
        return true;
    }

    public int count() {
        return count;
    }
}
