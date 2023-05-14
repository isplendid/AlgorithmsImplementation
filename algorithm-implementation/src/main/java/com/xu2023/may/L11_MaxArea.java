package com.xu2023.may;

/**
 * @author xushichao
 * @date 2023/5/11 10:04
 * @desc
 */
public class L11_MaxArea {
    public int maxArea(int[] height) {
        int l = 0, r = height.length-1;
        int max = Integer.MIN_VALUE;

        while(l <= r) {
            while(l<=r && height[l] <= height[l+1]) {
                max = Math.max(max, Math.min(height[l], height[r]) * (r-l));
                l++;
            }
            r--;

            while(l <=r && height[r-1] >= height[r]) {
                max = Math.max(max, Math.min(height[l], height[r]) * (r-l));
                r--;
            }
            l++;

        }



        return max;

    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,8,6,2,5,4,8,3,7};
        L11_MaxArea area = new L11_MaxArea();
        int res = area.maxArea(arr);
        System.out.println(res );
    }
}
