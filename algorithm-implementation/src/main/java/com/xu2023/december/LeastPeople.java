package com.xu2023.december;

import java.util.HashMap;
import java.util.Map;

/***
 *
 * 当上了宣传委员，开始组织迎新晚会，已知班里有个同学，每个同学有且仅有一个擅长的声部，把同学们分成恰好组，
 * 为了不搞砸节目，每一组里的同学都必须擅长同一个声部，当然，不同组同学擅长同一个声部的情况是可以出现的，
 * 毕竟一个声部也可以分成好几个part进行表演，但是他不希望出现任何一组的人过多，否则可能会导致场地分配不协调，
 * 也就是说，她希望人数最多的小组的人尽可能少，除此之外，对组内人员分配没有其他要求，她希望你告诉她，这个值是多少，如果无法顺利安排，请输出-1
 *
 *
 *分为 m 组 ；分组，人最少
 * 第一行两个数个数n,m(1≤m≤n≤100000)表示人数
 *
 * 接下来一行n个数,a[i](1≤a[i]≤n)表示第i个学生的擅长声部
 */
public class LeastPeople {

    /***
     * 最大值的最小化
     * @param n
     * @param m
     * @param arr
     * @return
     */
    private static int getLeast(int n, int m, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        if (map.size() > m) {
            return -1;
        }

        int l = 1, r = n, mid;
        int ans = 0;

        while (l <= r) {
            mid = l + (r - l) / 2;
            if (checkGroup(map, mid, m)) {
                r = mid - 1;
                ans = mid;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    private static boolean checkGroup(Map<Integer, Integer> map, int maxGroupSize, int m) {
        int totalGroups = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            totalGroups += entry.getValue() / maxGroupSize + (entry.getValue() % maxGroupSize == 0 ? 0 : 1);
        }
        if (totalGroups <= m) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 5;
        int m = 3;
        int[] arr = new int[]{2, 2, 3, 3, 3};
        int res = getLeast(n, m, arr);
        System.out.println(res);
    }

}
