package com.xu.leetcode.contest.c193;

import com.xu.leetcode.contest.c192.StrongestNum_192;

import java.util.*;

/**
 * Created by sop on 2020/6/14.
 */
public class FindLeastNumOfUniqueInts {
//    public   int[] getStrongest(int[] arr, int k) {
//        Arrays.sort(arr);
//        int n = arr.length;
//        int mid =  (n-1)/2;
//        List<Node> nodes = new ArrayList<>();
//        for(int i=0; i<n; i++){
//            nodes.add(new Node(Math.abs(arr[i] - arr[mid]), arr[i]));
//        }
//        Collections.sort(nodes, new Comparator<Node>() {
//            @Override
//            public int compare(Node o1, Node o2) {
//                if(o1.dis ==o2.dis){
//                    return o2.val - o1.val;
//                } else {
//                    return o2.dis - o1.dis;
//                }
//            }
//        });
//        int[] res = new int[k];
//        for(int i=0; i<k; i++){
//            res[i] = nodes.get(i).val;
//        }
//        return res;
//
//    }

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
//        Arrays.sort(arr);
//        int n = arr.length;
//        List<Node> nodes = new ArrayList<>();
//        for(int i=0; i<n; i++){
//            nodes.add(new Node(Math.abs(arr[i] - arr[mid]), arr[i]));
//        }
            Map<Integer, Integer> map = new HashMap<>();
            for(int a:arr){
                if(!map.containsKey(a)){
                    map.put(a,1);
                }else {
                    map.put(a, map.get(a) + 1);
                }
            }

            List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    return o1.getValue() - o2.getValue();
                }
            });
           int sum = 0;
           int size = list.size();
           for(Map.Entry<Integer, Integer> entry: list){
               sum += entry.getValue();
               if(sum <= k) {
                   size --;
               } else {
                   break;
               }
           }
         return size;
}



    public static void main(String[] args) {
        FindLeastNumOfUniqueInts s = new FindLeastNumOfUniqueInts();
        int[] arr = new int[]{5,5,4};
        int k=1;

        int res = s.findLeastNumOfUniqueInts(arr,k);
        System.out.println(res);
    }
}
