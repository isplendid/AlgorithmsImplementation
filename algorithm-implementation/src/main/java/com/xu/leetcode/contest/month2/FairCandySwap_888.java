package com.xu.leetcode.contest.month2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author xushichao
 * @date 2021/2/1 10:35 PM
 * @desc
 */
public class FairCandySwap_888 {

    /**
     * 链接：https://leetcode-cn.com/problems/fair-candy-swap/solution/gong-ping-de-tang-guo-jiao-huan-by-leetc-tlam/
     *
     * @param A
     * @param B 时间复杂度：O(n + m)，其中 n 是序列 A 的长度，m 是序列 B 的长度。
     *          空间复杂度：O(n)，其中 n 是序列 A 的长度。我们需要建立一个和序列 A 等大的哈希表
     *          <p>
     *          计算公式：sumA−x+y=sumB+x−y； => x = y  + (sumA- sumB)/2;
     * @return
     */
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = Arrays.stream(A).sum();
        int sumB = Arrays.stream(B).sum();
        int delta = (sumA - sumB) / 2;
        Set<Integer> rec = new HashSet<Integer>();
        for (int num : A) {
            rec.add(num);
        }
        int[] ans = new int[2];
        for (int y : B) {
            int x = y + delta;
            if (rec.contains(x)) {
                ans[0] = x;
                ans[1] = y;
                break;
            }
        }
        return ans;
    }


    public int[] fairCandySwap_me(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int sumA = sum(A);
        int sumB = sum(B);
        int dis = sumA - sumB;
        int d = dis / 2;
        // A>B
        int la = A.length - 1;
        int lb = B.length - 1;
        if (dis > 0) {
            while (la >= 0 && lb >= 0) {
                if (A[la] - B[lb] == d) {
                    return new int[]{A[la], B[lb]};
                } else if (A[la] - B[lb] > d) {
                    la--;
                } else {
                    lb--;
                }
            }
        } else {
            d = -1 * d;
            while (la >= 0 && lb >= 0) {
                if (B[lb] - A[la] == d) {
                    return new int[]{A[la], B[lb]};
                } else if (B[lb] - A[la] > d) {
                    lb--;
                } else {
                    la--;
                }
            }

        }
        return new int[0];
    }

    private int sum(int[] A) {
        int sum = 0;
        for (int a : A) {
            sum += a;
        }
        return sum;
    }

    public static void main(String[] args) {
        FairCandySwap_888 fairCandySwap = new FairCandySwap_888();
        int[] A1 = new int[]{1, 2, 5};
        int[] B1 = new int[]{2, 4};

        int[] A = new int[]{2};
        int[] B = new int[]{1, 3};
        int[] res = fairCandySwap.fairCandySwap(A, B);
        for (int r : res) {
            System.out.println(r);
        }
    }
}
