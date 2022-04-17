package com.xu.leetcode.contest.c268;

/**
 * @author xushichao
 * @date 2021/11/21 10:54 AM
 * @desc
 */
public class PlantsWater {
    public int wateringPlants(int[] plants, int capacity) {
        //遍历植物的索引
        int l = plants.length;
        int cap = capacity;
        int step = 0;
        for (int i = 0; i < l; i++) {
            if(cap >= plants[i]){
                step++;
                cap -= plants[i];
            } else {
                cap = capacity;
                step += (2*i+1);
                cap -= plants[i];
            }
        }
        return step;
    }

    public static void main(String[] args) {
        PlantsWater water = new PlantsWater();
        int cap = 4;
        int[] arr = new int[]{1,1,1,4,2,3};
        int res = water.wateringPlants(arr, cap);
        System.out.println(res);
    }
}
