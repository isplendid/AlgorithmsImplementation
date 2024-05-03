package com.xu2023.december;

public class FindPeakElement_162 {

    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int res = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (compare(nums, mid-1, mid) < 0 && compare(nums, mid, mid+1)> 0) {
                res = mid;
                return res;
            }

            if(compare(nums, mid, mid + 1) < 0) {
                l = mid +1;
            } else {
                r = mid -1;
            }
        }
        return res;
    }



    private int compare(int[] nums, int i, int j) {
         int[] num1 = get(nums, i);
         int[] num2 = get(nums, j);

         if(num1[0] != num2[0]) {
             return num1[0] > num2[0] ? 1: -1;
         }

         if(num1[1] == num2[1]) {
             return 0;
         }
         return num1[1]>num2[1] ? 1: -1;
    }


    /***
     * 辅助函数，输入下标 i，返回一个二元组 (0/1, nums[i]),  表示（是否边界，边界是最小的，  数值）
     * 处理 nums[-1]和 nums[n]边界情况
     * @param nums
     * @param idx
     * @return
     */
    private int[] get(int[] nums, int idx) {
        if (idx == -1 || idx == nums.length) {
            return new int[]{0, 0};
        }
        return new int[]{1, nums[idx]};
    }


    public static void main(String[] args) {
        int[] arr = new int[]{2,1};
        FindPeakElement_162 find = new FindPeakElement_162();
        int res = find.findPeakElement(arr);
        System.out.println(res);

    }

}
