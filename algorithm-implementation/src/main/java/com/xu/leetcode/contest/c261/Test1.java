package com.xu.leetcode.contest.c261;

import java.util.PriorityQueue;

/**
 * @author xushichao
 * @date 2021/10/3 10:27 AM
 * @desc
 */
public class Test1 {

    /***
     * 1. 奇数： 可被3整除，不可被3整除
     * 2. 偶数： 可被3整除，不可被3整除
     * @param stones
     * @return
     */
//    public boolean stoneGameIX(int[] stones) {
//        //求
//        boolean[]  aliceDp = new boolean[stones.length];
//
//    }


    /**
     * 482
     *
     * @param s
     * @param k
     * @return
     */
    public static String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1, cnt = 0; i >= 0; i--) {
            if (s.charAt(i) == '-') {
                continue;
            }
            if (cnt == k) {
                sb.append("-");
                cnt = 0;
            }
            sb.append(s.charAt(i));
            cnt++;
        }
        return sb.reverse().toString().toUpperCase();
    }

    public static void main1(String[] args) {

        String s = "2-5g-3-J";
        int k = 2;
        System.out.println(licenseKeyFormatting(s, k));
    }


    public static int thirdMax(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(3);
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (pq.size() < 3) { //相等值如何处理
                pq.offer(val);
            } else {
                if (val > pq.peek()) {
                    pq.offer(val);
                }
                if (pq.size() > 3) {
                    pq.poll();
                }
            }
        }

        Integer res = Integer.MIN_VALUE;
        if(pq.size() < 3) {
            for(Integer i: pq ){
                if(i > res) {
                    res  = i;
                }
            }
            return res;
        }
        return pq.peek();
    }

    public static void main(String[] args) {

        int[] nums = new int[]{2, 2, 3, 1};
        System.out.println(thirdMax(nums));
    }

}
