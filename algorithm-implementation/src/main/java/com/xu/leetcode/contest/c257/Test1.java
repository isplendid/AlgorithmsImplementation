package com.xu.leetcode.contest.c257;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author xushichao
 * @date 2021/9/5 10:30 AM
 * @desc
 */
public class Test1 {

    public int numberOfWeakCharacters(int[][] properties) {
        /**
         * 按 攻击 逆序， 按防御正序
         */
        Arrays.sort(properties, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o2[0] - o1[0] > 0) {
                    return 1;
                } else if (o2[0] - o1[0] < 0) {
                    return -1;
                } else if (o2[0] - o1[0] == 0) {
                    return o1[1] - o2[1];
                }
                return 0;
            }
        });
        int l = properties.length;
        int cnt = 0;
        int max1 = Integer.MIN_VALUE;
        for (int i = 0; i < l; i++) {
            if (properties[i][1] < max1) {
                cnt++;
            } else {
                max1 = properties[i][1];
            }
        }

        return cnt;
    }


    public int numberOfWeakCharacters_no(int[][] properties) {
        int l = properties.length;
        int max0 = Integer.MIN_VALUE;
        int max1 = Integer.MIN_VALUE;
        int maxS = Integer.MIN_VALUE;
        for (int i = 0; i < l; i++) {
            max0 = Math.max(properties[i][0], max0);
            max1 = Math.max(properties[i][1], max1);
            maxS = Math.max(properties[i][0] + properties[i][1], maxS);
        }
        int cnt = 0;
        for (int i = 0; i < l; i++) {
            if (properties[i][0] != max0 && properties[i][1] != max1 && isValid(properties[i][0], properties[i][1], maxS)) {
                cnt++;
            }
        }
        return cnt;
    }

    private boolean isValid(int a, int b, int sum) {
        return Math.abs(a + b - sum) > 1;
    }

    public int numberOfWeakCharacters_2(int[][] properties) {
        /**
         * 按 攻击 逆序， 按防御正序
         */
        Arrays.sort(properties, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o2[0] - o1[0] > 0) {
                    return 1;
                } else if (o2[0] - o1[0] < 0) {
                    return -1;
                } else if (o2[0] - o1[0] == 0) {
                    return o1[1] - o2[1];
                }
                return 0;
            }
        });

        int l = properties.length;
        int cnt = 0;
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                if (i == j) {
                    continue;
                }
                if (properties[j][1] > properties[i][1] && properties[j][0] > properties[i][0]) {
                    cnt++;
                    break;
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        int[][] per = new int[][]{{7, 7}, {1, 2}, {9, 7}, {7, 3}, {3, 10}, {9, 8}, {8, 10}, {4, 3}, {1, 5}, {1, 5}};
        int[][] per2 = new int[][]{{3, 6}, {6, 3}, {5, 2}};
        Test1 test1 = new Test1();
        System.out.println(test1.numberOfWeakCharacters(per2));
    }
}
