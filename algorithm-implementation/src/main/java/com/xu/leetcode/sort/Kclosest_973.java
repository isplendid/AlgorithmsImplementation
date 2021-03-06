package com.xu.leetcode.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by sop on 2019/12/23.
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

 (Here, the distance between two points on a plane is the Euclidean distance.)

 You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)



 Example 1:

 Input: points = [[1,3],[-2,2]], K = 1
 Output: [[-2,2]]
 Explanation:
 The distance between (1, 3) and the origin is sqrt(10).
 The distance between (-2, 2) and the origin is sqrt(8).
 Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 Example 2:

 Input: points = [[3,3],[5,-1],[-2,4]], K = 2
 Output: [[3,3],[-2,4]]
 (The answer [[-2,4],[3,3]] would also be accepted.)
 * see: https://leetcode.com/problems/k-closest-points-to-origin/
 */




class Solution_PriorityQueue  {

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>(Comparator.comparing(a -> a[0] * a[0] - a[1] * a[1]));
        for(int[] p : points){
            priorityQueue.offer(p);
            if(priorityQueue.size() > K ){
                priorityQueue.poll();
            }
        }
        return priorityQueue.toArray(new int[K][2]);
    }

    public int[][] kClosest2(int[][] points, int K) {
        Arrays.sort(points, (p1, p2) -> p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1]);
        return Arrays.copyOfRange(points, 0, K);
    }


    public int[][] kClosest_sort(int[][] points, int K) {
        int len =  points.length, l = 0, r = len - 1;
        while (l <= r) {
            int mid = helper(points, l, r);
            if (mid == K) break;
            if (mid < K) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return Arrays.copyOfRange(points, 0, K);
    }

    private int helper(int[][] A, int l, int r) {
        int[] pivot = A[l];
        while (l < r) {
            while (l < r && compare(A[r], pivot) >= 0) r--;
            A[l] = A[r];
            while (l < r && compare(A[l], pivot) <= 0) l++;
            A[r] = A[l];
        }
        A[l] = pivot;
        return l;
    }

    private int compare(int[] p1, int[] p2) {
        return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
    }

}


//class Solution {
//    public int[][] kClosest(int[][] points, int K) {
//        int[] rows = new int[points.length];
//        for(int i=0; i< points.length; i++){
//            rows[i] = points[i][0] * points[i][0] + points[i][1]*points[i][1];
//        }
//
//
//        int[][] res = new int[][]{};
//        return res;
//
//    }
//
//    public int[] sort(int[] arr){
//
//    }
//}



public class Kclosest_973 {


}
