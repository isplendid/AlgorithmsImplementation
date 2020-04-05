package com.xu.leetcode.binarysearch;

/**
 * Created by sop on 2020/3/11.
 * 爱吃香蕉的珂珂
 *
 *  这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。
 * 输入: piles = [3,6,7,11], H = 8
 * 输出: 4
 */
public class EatingBanana_875 {
    public int minEatingSpeed(int[] piles, int H) {

        int maxSpeed = getMax(piles);

        int left= 1;
        int right = maxSpeed;
        while(left <= right){
            int mid= left +(right -left)/2;
            if(canFinish(piles, mid, H)){
                right = mid-1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 时间复杂度 O(N)
    boolean canFinish(int[] piles, int speed, int H) {
        int time = 0;
        for (int n : piles) {
            time += timeOf(n, speed);
        }
        return time <= H;
    }

    int timeOf(int n, int speed) {
        return (n / speed) + ((n % speed > 0) ? 1 : 0);
    }

    int getMax(int[] piles) {
        int max = 0;
        for (int n : piles)
            max = Math.max(n, max);
        return max;
    }
}
