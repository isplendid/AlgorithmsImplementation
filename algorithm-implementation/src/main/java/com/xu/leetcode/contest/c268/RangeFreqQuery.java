package com.xu.leetcode.contest.c268;

import java.util.*;

/**
 * @author xushichao
 * @date 2021/11/21 11:10 AM
 * @desc
 */
public class RangeFreqQuery {
    //value, index;
    private Map<Integer, List<Integer>> valueIndexMap;

    public RangeFreqQuery(int[] arr) {
        valueIndexMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (valueIndexMap.containsKey(arr[i])) {
                valueIndexMap.get(arr[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                valueIndexMap.put(arr[i], list);
            }
        }
    }

    public int query(int left, int right, int value) {
        List<Integer> index = valueIndexMap.get(value);
        int cnt = 0;
        if (Objects.isNull(index) || index.size() ==0) {
            return cnt;
        }
        int queryLeft = Collections.binarySearch(index, left);
        int queryRight = Collections.binarySearch(index, right);

        if(queryLeft<0 &&  queryLeft <0){
            return 0;
        } else if(queryLeft<0) {
            return index.size()-queryRight;
        } else if(queryRight < 0) {
            return 0;
        }
        return queryRight-queryLeft;
    }



    public static void main(String[] args) {
        int[] arr = new int[]{12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56};
        RangeFreqQuery rq = new RangeFreqQuery(arr);
        //int res = rq.query(0, 3, 5);
        int res2 = rq.query(0, 11, 33);
        //System.out.println(res);
        System.out.println(res2);
    }
}
