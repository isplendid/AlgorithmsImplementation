package com.xu2025.xu11;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * @author alex xu
 * @date 2025/11/30
 * @desc  排序 + 分组
 *
 * 优化思路（排序 + 分组）：
 *
 * 1) 将数组按升序排序。
 * 2)关键观察： 相同值的元素，它们被比“更大”的元素的个数是一样的。
 * 3) 因此，我们可以：
 * > 从右往左按“值分组”遍历（即一段一段相等的元素）。
 * > 维护一个变量 greaterCount，表示当前处理的这个值的所有元素中，有多少元素是“严格大于”它的：
 * 因为我们从大到小处理，已经处理过的元素都是“比当前值大的元素”，所以它们的总数就是 greaterCount。
 * > 对于当前值 v，其出现次数为 cnt：
 * 如果 greaterCount >= k，那么 这个值的所有 cnt 个元素都合格，把 cnt 加入答案。
 * > 然后把当前值的个数 cnt 加到 greaterCount 中，表示这些也会成为后面更小值的“更大元素”。
 */
public class Main {
    public int countElements(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int ans = 0;
        int greaterCnt = 0;  //已经处理过的（严格更大）元素个数
        int i= nums.length -1;
        while(i >=0) {
            int value = nums[i];
            int start = i;
            // 找到这一组相同 value 的起点（从右往左）
            while(i >=0 && nums[i] == value) {
                i--;
            }
            int count = start - i; // 当前 value 的出现次数
            if(greaterCnt >= k) {
                ans += count;
            }
            // 这一组元素也会成为后续更小元素的“更大元素”
            greaterCnt += count;
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{3,1,2};
        int k = 1;
        Main main = new Main();
        int val = main.countElements(nums, k);
        System.out.println(val);

    }
}
