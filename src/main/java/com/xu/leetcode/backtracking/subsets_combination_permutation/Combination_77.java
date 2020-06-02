package com.xu.leetcode.backtracking.subsets_combination_permutation;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by sop on 2020/5/28.
 *
 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 输入: n = 4, k = 2
 输出:
 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4],
 ]


 从小到大，不能重复
 */
public class Combination_77 {



    private  List<List<Integer>> res2 = new ArrayList<>();
    public List<List<Integer>> combine2(int n, int k) {

        Stack<Integer> path = new Stack<>();
        dfs(n,k, 1,path);
        return res2;
    }

    private void dfs(int n, int k, int start, Stack<Integer> path){

        if(path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i=start; i<=n; i++){
            //   if(path.contains(i)){
            //       continue;
            //   }
            path.push(i);
            dfs(n,k,i+1,path);
            path.pop();
        }

    }



    private  List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        Stack<Integer> path = new Stack<>();
        dfs(n,k,path);
        return res;
    }

    private void dfs(int n, int k,  Stack<Integer> path){
        if(path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=1; i<=n; i++){
            if(path.contains(i)){
                continue;
            }
            path.push(i);
            dfs(n,k,path);
            path.pop();
        }
    }



    public static void main(String[] args) {
        Combination_77 comb = new Combination_77();
        int n =4, k=2;
        System.out.println(comb.combine(n,k));


    }
}
