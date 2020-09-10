package com.xu.leetcode.slidingwindown;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;

/**
 * Created by sop on 2020/2/20.
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值    。
 *
 *
 *
 */
public class MaxSlidingWindow_239 {


    /***
     * 双端队列解决  first是最大值， last是 最小值
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow_deque(int[] nums, int k) {
        if(null == nums || k <=0) {
            return new int[0];
        }

        int[] res = new int[nums.length-k+1];
        //双端队列，用户记录每个窗口的最大值小标；
        Deque<Integer> qmax = new LinkedList<>();
        for(int i=0; i<nums.length; i++){
            while(!qmax.isEmpty() && nums[qmax.peekLast()] < nums[i]){
                qmax.pollLast();
            }
            qmax.addLast(i);
            //判断队列首元素是否过期
            if(qmax.peekFirst() == i-k) {
                qmax.pollFirst();
            }
            //向res加入最大值, 从k-1循环起
            if(i>=k-1){
                res[i-k+1]= nums[qmax.peekFirst()];
            }
        }
        return res;

    }


    /***
     * BST来做
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow_BST(int[] nums, int k) {
        if(null == nums || k <=0) {
            return new int[0];
        }

        //save the entry<nums[i],i>
        TreeMap<Integer, Integer> tree = new TreeMap<>();
        int[]  res = new int[nums.length -k +1];
        for(int i=0; i<nums.length; i++){
            //for i<k, just put the entries
            tree.put(nums[i],i);
            // if i >= k - 1, meaning that there are k elements in the window
            if( i>=k-1 ){
                res[i-k+1] = tree.lastKey();
                //there are enough entries, remove the oldest one
                // however, there may exist duplicates
                // thus we need to check whether the index matches
                // if matches, just remove it safely
                // if not match, meaning that the number is automatically covered by some later numbers and we don't need to remove it
                //移除最老的值，后面会加入重复的
                if (tree.get(nums[i - k + 1]) == i - k + 1) { tree.remove(nums[i - k + 1]); }
            }
        }//for
        return res;
    }


    /***
     * What does Monoqueue do here:
     It has three basic options:

     push: push an element into the queue; O (1) (amortized)
     pop: pop an element out of the queue; O(1) (pop = remove, it can't report this element)
     max: report the max element in queue;O(1)
     It takes only O(n) time to process a N-size sliding window minimum/maximum problem.

     Note: different from a priority queue (which takes O(nlogk) to solve this problem), it doesn't pop the max element: It pops the first element (in original order) in queue.
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow_queue(int[] nums, int k) {
       if(nums == null || k<=0)
           return new int[0];

        Monoqueue mq = new Monoqueue();
        int[] res = new int[nums.length-k+1];
        int idx =0;
        for(int i=0; i<nums.length; i++){
            if(i<k-1) {
                mq.push(nums[i]);
            } else {
                mq.push(nums[i]);
                res[idx++]= mq.max();
                mq.pop(nums[i-k+1]); //不一定有值，最大值过期了
            }
        }//for
        return res;
    }




    /***
     * 暴力法  Time Complexity O((n-k+1)*k), space O(1)
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];
        if(n==0 || k<=0) return new int[0];
        int j;
        for(int i=0; i<n-k+1; i++){
            j = i+k-1;
            res[i]=findMaxNum(nums, i,j);
        }
        return res;
    }

    private int findMaxNum(int[] nums, int i, int j){
        int res = Integer.MIN_VALUE;
        for(int k=i; k<=j; k++){
            res = Math.max(res,nums[k]);
        }
        return res;
    }


    class Monoqueue{
        /***
         * first 为最大值， last为最小值， 单调队列
         */
        Deque<Integer> q = new ArrayDeque<>();
        public void push(Integer n){
            while(!q.isEmpty() && q.peekLast().compareTo(n) < 0){
                q.pollLast();
            }
            q.offerLast(n);
        }

        public void pop(Integer n){
            if(n.equals(q.peekFirst())) q.pollFirst(); //最大值过期 移除
        }

        public Integer max(){
            return q.peekFirst();
        }
    }


    /***
     * 暴力求解 O(n *(n-k+1))
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow_bruteForce(int[] nums, int k) {
        if(nums == null || k <= 0) return new int [0];
        int [] arr = new int[nums.length - k + 1];
        for(int i = 0; i < nums.length - k + 1; i++){
            int max = Integer.MIN_VALUE;
            for(int j = i; j < i + k; j++)
                max = Math.max(max, nums[j]);
            arr[i] = max;
        }
        return arr;
    }



}
