package com.xu.leetcode.contest.c193;

/**
 * Created by sop on 2020/6/14.
 */
public class TreeAncestor_Timeout {
     private int n;
    private int[] parent;

    public TreeAncestor_Timeout(int n, int[] parent) {
        this.n = n;
        this.parent = parent;
    }

    public int getKthAncestor(int node, int k) {
        int p = node;
        while(k>0 ){
            if(parent[p] < 0) {
                p=-1;
                break;
            }
            p = parent[parent[p]];
            k -=2;
            if(p < 0){
                p = -1;
                break;
            }
        }
        return p;
    }

//
//    public int getKthAncestor(int node, int k) {
//
//    }
//

    public static void main(String[] args) {
        /**
         * Your TreeAncestor_Timeout object will be instantiated and called as such:
         * TreeAncestor_Timeout obj = new TreeAncestor_Timeout(n, parent);
         * int param_1 = obj.getKthAncestor(node,k);
         */
//        int[] arr =new int[]{ -1, 0, 0, 1, 1, 2, 2};
//        TreeAncestor_Timeout treeAncestor = new TreeAncestor_Timeout(7, arr);
//
//        System.out.println(treeAncestor.getKthAncestor(3, 1));  // 返回 1 ，它是 3 的父节点
//        System.out.println(treeAncestor.getKthAncestor(5, 2));  // 返回 0 ，它是 5 的祖父节点
//        System.out.println(treeAncestor.getKthAncestor(6, 3));  // 返回 -1 因为不存在满足要求的祖先节点


        int[] arr =new int[]{ -1, 0, 0, 0, 3};
        TreeAncestor_Timeout treeAncestor = new TreeAncestor_Timeout(5, arr);

        System.out.println(treeAncestor.getKthAncestor(1, 5));  //
        System.out.println(treeAncestor.getKthAncestor(3, 2));  //
        System.out.println(treeAncestor.getKthAncestor(0, 1));  //


    }

}
