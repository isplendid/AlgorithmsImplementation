package com.xu2023.april;

import java.util.Arrays;

/**
 * @author xushichao
 * @date 2023/4/29 20:42
 * @desc
 */
public class SortArrayByParity_905 {
    public static int[] sortArrayByParity(int[] nums) {
        int low = 0, high = nums.length-1;
        int temp = nums[low];  //由于先记录的是这个nums[low], 所以先从最右边开始遍历，最后 再 nums[low] = temp;
        while(low<high) {

            while(low<high && nums[high] % 2 == 1) {
                high--;
            }
            nums[low] = nums[high];

            while(low <high && nums[low] % 2 == 0) {
                low++;
            }
            nums[high] = nums[low];


        }

        nums[low] = temp;

        return nums;

    }

    public static void main(String[] args) {
        int[] arr = new int[] {3,1,2,4};
        sortArrayByParity(arr);

        Arrays.stream(arr).forEach(System.out::println);
    }

}
