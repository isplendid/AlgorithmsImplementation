package com.xu.leetcode.slidingwindown;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xushichao
 * @date 2023/4/28 17:45
 * @desc
 */
public class TotalFruit_904 {

    //思路：kind<=2时 right右移， kind>=3时 left左移
    public int totalFruit(int[] fruits) {

        int left=0, right=0;
        int n= fruits.length;
        Map<Integer, Integer> map  = new HashMap<>();
        int kind=0;
        int len = Integer.MIN_VALUE;
        while(right < n) {
            if(kind<=2) {
                int val =fruits[right];
                map.put(val, map.getOrDefault(val, 0) + 1);
                kind = map.size();
                right ++;
                if(kind<=2) {
                    len = Math.max(right -left, len);
                }

            } else {

                int val = fruits[left];
                map.put(val, map.get(val) -1 );
                if(map.get(val) == 0) {
                    map.remove(val);
                }
                kind = map.size();
                left ++;
            }


        }
        return len;

    }


    public static void main(String[] args) {

        TotalFruit_904 t = new TotalFruit_904();
        int[] fruits = new int[] {3,3,3,1,2,1,1,2,3,3,4};
        int res = t.totalFruit(fruits);

        System.out.println(res);

    }
}
