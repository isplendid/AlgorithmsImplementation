package com.xu.leetcode.binarysearch;

/**
 * Created by sop on 2020/3/12.
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。

 所以 nums[start] == nums[mid] 需要我们单独考虑了
 */
public class SearchRotatedArrayII_81 {
    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target == nums[mid]) {
                return true;
            }
            //左半段有序
            if (nums[start] < nums[mid]) {
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if(nums[start] == nums[mid]){
                start++;
                //右半段有序
            }else{
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }

}
/****
 * 时间复杂度：最好的情况，如果没有遇到 nums [ start ] == nums [ mid ]，
 * 还是 O（log（n））。当然最差的情况，如果是类似于这种 [ 1, 1, 1, 1, 2, 1 ] ，
 * target = 2，就是 O ( n ) 了。
 空间复杂度：O ( 1 )。
 */
