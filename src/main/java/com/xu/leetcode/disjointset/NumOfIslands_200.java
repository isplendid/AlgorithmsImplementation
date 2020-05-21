package com.xu.leetcode.disjointset;

/**
 * Created by sop on 2020/2/23.
 */
public class NumOfIslands_200 {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        UnionFind2 uf = new UnionFind2(grid);
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    grid[r][c] = '0';
                    if (r - 1 >= 0 && grid[r-1][c] == '1') {
                        uf.union(r * nc + c, (r-1) * nc + c);
                    }
                    if (r + 1 < nr && grid[r+1][c] == '1') {
                        uf.union(r * nc + c, (r+1) * nc + c);
                    }
                    if (c - 1 >= 0 && grid[r][c-1] == '1') {
                        uf.union(r * nc + c, r * nc + c - 1);
                    }
                    if (c + 1 < nc && grid[r][c+1] == '1') {
                        uf.union(r * nc + c, r * nc + c + 1);
                    }
                }
            }
        }

        return uf.count();
    }


    class UnionFind2 {
        private int count=0;
        private int[] parent, rank;

        public UnionFind2(char[][] grid) { // for problem 200
            int m = grid.length;
            int n = grid[0].length;
            parent = new int[m * n];
            rank = new int[m * n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (grid[i][j] == '1') {
                        parent[i * n + j] = i * n + j;
                        ++count;
                    }
                    rank[i * n + j] = 0;
                }
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
}
