package com.xu.leetcode.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by sop on 2020/8/16.
 */
public class KsmallestNumber_offer40 {
    public static int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a,b) -> b-a); //大顶堆，最小的k数据
        for(int i=0; i<arr.length; i++){
            if(i>=k){
                if(arr[i] < pq.peek()){
                    pq.poll();
                    pq.add(arr[i]);
                }
            }else {
                pq.add(arr[i]);
            }
        }
        int[] res = new int[pq.size()];
        int i=0;
        for(Integer item: pq){
            res[i++] = item;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,0,0,2,0,5};
        int k = 0;
        int[] res = getLeastNumbers(arr,k);
        Arrays.stream(res).forEach(System.out::println);
    }
}
