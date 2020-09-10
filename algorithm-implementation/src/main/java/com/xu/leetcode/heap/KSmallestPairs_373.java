package com.xu.leetcode.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by sop on 2020/8/16.
 * <p>
 * 取堆顶最小的元素
 * 小顶堆： merge k sorted list
 * 将2个升序数组，通过a[i] + b[j] 转换成N个有序数组
 * (1,2)->(1,4)->(1,6)
 * (7,2)->(7,4)->(7,6)
 * (11,2)->(11,4)->(11,6)
 */
public class KSmallestPairs_373 {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums1.length == 0 || nums2.length == 0 || k<= 0){
            return res;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (o1,o2) -> (nums1[o1[0]] + nums2[o1[1]]) - (nums1[o2[0]] + nums2[o2[1]]));


        for(int i=0; i<Math.min(nums1.length, k); i++){
            pq.offer(new int[]{i, 0});
        }
        while(k > 0 && !pq.isEmpty()){
            int[] top = pq.poll();
            List<Integer> item = new ArrayList<>();
            item.add(nums1[top[0]]);
            item.add(nums2[top[1]]);

            if(top[1] < nums2.length -1){ //每行的下一个元素
                pq.offer(new int[]{top[0], top[1] + 1});
            }
            res.add(item);
            k--;
        }

        return res;

    }

    public static void main(String[] args) {
         int[] nums1 = new int[]{1,7,11};
        int[] nums2 = new int[]{2,4,6};
        int k = 3;
        KSmallestPairs_373 ks = new KSmallestPairs_373();
        List<List<Integer>> res= ks.kSmallestPairs(nums1, nums2, k);
        System.out.println(res);  //[[1, 2], [1, 4], [1, 6]]

    }
}
