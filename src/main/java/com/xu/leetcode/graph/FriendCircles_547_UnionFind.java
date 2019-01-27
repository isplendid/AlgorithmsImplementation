package com.xu.leetcode.graph;

/**
 * Created by sop on 2018/12/2.
 * https://leetcode.com/problems/friend-circles/
 * This is a typical Union Find problem. I abstracted it as a standalone class.
 *
 * 加权quick-union 算法
 */
class UnionFind{
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
    public int find(int p){
        while(p != parent[p]){
            //parent[p] = parent[parent[p]]; //path compresssion by halving
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



public class FriendCircles_547_UnionFind {

    public int findCircleNum(int[][] M) {
        int n = M.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 1) uf.union(i, j);
            }
        }
        return uf.count();
    }
}
