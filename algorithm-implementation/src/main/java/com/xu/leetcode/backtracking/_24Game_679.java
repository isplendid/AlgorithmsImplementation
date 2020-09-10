package com.xu.leetcode.backtracking;

/**
 * Created by sop on 2020/08/2020/8/24 22:18
 * 你有 4 张写有 1 到 9 数字的牌。你需要判断是否能通过 *，/，+，-，(，) 的运算得到 24。
 * 输入: [4, 1, 8, 7]
 * 输出: True
 * 解释: (8-4) * (7-1) = 24
 *
 * @Description:
 */
public class _24Game_679 {

    private final static double EPSILON = 0.001;//1e-6;

    public boolean judgePoint24(int[] nums) {
        double[] a = new double[]{nums[0], nums[1], nums[2], nums[3]};
        return helper(a);
    }

    private boolean helper(double[] a) {
        if (a.length == 1) {
            return Math.abs(a[0] - 24) < EPSILON;
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                double[] b = new double[a.length - 1];
                for (int k = 0, index = 0; k < a.length; k++) {
                    if (k != i && k != j) {
                        b[index++] = a[k];
                    }
                }

                for (double d : compute(a[i], a[j])) {
                    b[b.length - 1] = d;
                    if (helper(b)) return true;
                }
            }
        }
        return false;
    }

    private double[] compute(double x, double y) {
        return new double[]{x + y, x * y, x - y, y - x, x / y, y / x};
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 6, 7};
        _24Game_679 game = new _24Game_679();
        System.out.println(game.judgePoint24(arr));
    }
}
