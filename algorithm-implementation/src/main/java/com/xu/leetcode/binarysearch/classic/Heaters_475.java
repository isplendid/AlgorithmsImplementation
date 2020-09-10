package com.xu.leetcode.binarysearch.classic;

import java.util.Arrays;

/**
 * Created by sop on 2020/8/2.
 *
 * 对于每个房屋，要么用前面的暖气，要么用后面的，二者取近的，得到距离
 * 对于所有的房屋，选择最大的上述距离。
 *
 */
public class Heaters_475 {

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int n = heaters.length;
        int res = 0;
        for(int i=0; i<houses.length; i++){
           int heaterIndex = findHeater(heaters, houses[i]);

            //比较 house两边的heaters
            int dist1 = heaterIndex == 0 ? Integer.MAX_VALUE : Math.abs( houses[i] - heaters[heaterIndex]);
            int dist2 = heaterIndex == n ? Integer.MAX_VALUE : Math.abs(houses[i] - heaters[heaterIndex -1]);
            res = Math.max(res, Math.min(dist1, dist1));
        }
        return res;
    }

    //二分法找不小于house的第一个heater值
    private int findHeater(int[] heaters, int house){
        int l =0, r = heaters.length -1;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(heaters[mid] >= house) {
                 r = mid -1;
            }else {
                l = mid +1;
            }
        }
        return l;
    }
}

