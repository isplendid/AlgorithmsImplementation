package com.xu.leetcode.contest.c192;

import java.util.*;

/**
 * Created by sop on 2020/6/7.
 */
public class StrongestNum_192 {
    public   int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        int mid =  (n-1)/2;
        List<Node> nodes = new ArrayList<>();
        for(int i=0; i<n; i++){
            nodes.add(new Node(Math.abs(arr[i] - arr[mid]), arr[i]));
        }
        Collections.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.dis ==o2.dis){
                    return o2.val - o1.val;
                } else {
                    return o2.dis - o1.dis;
                }
            }
        });
        int[] res = new int[k];
        for(int i=0; i<k; i++){
           res[i] = nodes.get(i).val;
        }
        return res;

    }

    class Node {
       public int dis;
        public int val;

        public Node(int dis, int val) {
            this.dis = dis;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        StrongestNum_192 s = new StrongestNum_192();
        int[] arr = new int[]{1,2,3,4,5};
        int k=2;

        int[] res = s.getStrongest(arr,k);
        for (int r:res)
            System.out.println(r);
    }
}
