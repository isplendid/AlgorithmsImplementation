package com.xu.leetcode.contest.c257;

/**
 * @author xushichao
 * @date 2021/9/5 10:30 AM
 * @desc
 */
public class Test2 {

    public int countQuadruplets(int[] nums) {
        int cnt =0;
        for(int i=0; i<nums.length-3; i++){
            for(int j=i+1; j<nums.length-2; j++){
                for(int k = j+1; k<nums.length -1; k++){
                    for(int m = k+1; m<nums.length; m++){
                        if(nums[i] + nums[j] + nums[k]== nums[m]){
                            cnt++;
                        }
                    }

                }
            }

        }
        return cnt;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,5};
        Test2 test2 = new Test2();
        System.out.println(test2.countQuadruplets(nums));


    }
}
