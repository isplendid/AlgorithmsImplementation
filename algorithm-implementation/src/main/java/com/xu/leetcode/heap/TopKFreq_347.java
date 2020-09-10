package com.xu.leetcode.heap;

import com.xu.algs.basic.In;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by sop on 2020/8/16.
 */
public class TopKFreq_347 {
    class Item {
        int val;
        int freq;
        public Item(int val, int freq){
            this.val = val;
            this.freq =freq;
        }
    }

    public int[] topKFrequent(int[] nums, int k){

        if(nums.length == 0 || k<=0){
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Item> pq = new PriorityQueue<>((a,b) -> a.freq - b.freq); //小顶堆， 与最小值比较
        int i=0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            Item item = new Item(entry.getKey(), entry.getValue());
            i++;
            if(i > k){
                if(entry.getValue() > pq.peek().freq){
                    pq.poll();
                    pq.offer(item);
                }
            } else {
                pq.offer(item);
            }
        }
        int[] res = new int[pq.size()];
        int j=0;
        for(Item item: pq){
            res[j++] = item.val;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,0,1,0};
        int k = 1;
        TopKFreq_347 top = new TopKFreq_347();
        int[] res = top.topKFrequent(nums, k);
        Arrays.stream(res).forEach(System.out::println);
    }
}
