package com.xu.leetcode.contest.c193;

/**
 * Created by sop on 2020/6/15.
 *
 * 倍增法 求 父节点 LCA等
 */
public class TreeAncestor {
    int[][] dp;
    public TreeAncestor(int n, int[] parent){
        dp = new int[n][(int) (Math.log(n) / Math.log(2)) + 1];
        for(int i=0; i<n; i++){
            dp[i][0] = parent[i];
        }
        for(int j=1; (1<< j) <n; j++){
            for(int i=0; i<n; i++){
                if(dp[i][j-1] != -1){
                    dp[i][j] = dp[dp[i][j-1]][j-1];
                } else {
                    dp[i][j] = -1;
                }
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        if(k==0 || node == -1){
            return node;
        }
        int p = (int) (Math.log(k) / Math.log(2));
        return getKthAncestor(dp[node][p], k-(1<<p));
    }
}
