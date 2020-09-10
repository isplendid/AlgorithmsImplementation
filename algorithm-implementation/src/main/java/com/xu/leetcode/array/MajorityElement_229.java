package com.xu.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sop on 2020/3/7.
 *https://leetcode-cn.com/problems/majority-element-ii/solution/liang-fu-dong-hua-yan-shi-mo-er-tou-piao-fa-zui-zh/
 */
public class MajorityElement_229 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if(nums==null || nums.length==0) return res;
        int cand1=nums[0], count1=0, cand2=nums[0], count2=0;
        //对抗阶段
        for(int num: nums){
            if(num == cand1){
                count1++;
                continue;
            }

            if(num == cand2){
                count2++;
                continue;
            }

            // 第1个候选人配对
            if (count1 == 0) {
                cand1 = num;
                count1++;
                continue;
            }
            // 第2个候选人配对
            if (count2 == 0) {
                cand2 = num;
                count2++;
                continue;
            }

            count1--;
            count2--;
        }

        //计数阶段
        count1=0;
        count2=0;
        for(int num: nums){
            if(num == cand1){
                count1++;
            } else if(num == cand2){
                count2++;
            }
        }
        if(count1 > nums.length/3) res.add(cand1);
        if(count2 > nums.length/3) res.add(cand2);
        return res;

    }

}
