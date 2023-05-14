package com.xu2023.april;

/**
 * @author xushichao
 * @date 2023/4/13 11:09
 * @desc
 *
 *跳出循环的条件：
 * 1） 机器人不位于原点
 * 2） 机器人不面朝北
 */
public class IsRobotBounded_1041 {
    public boolean isRobotBounded(String ins) {

        int x = 0, y = 0, i = 0;
        // N, W(R), S, E(L)
        // 0 ， 1，2， 3
        int d[][] = {{0, 1}, {1, 0}, {0, -1}, { -1, 0}};

        for (int j = 0; j < ins.length(); ++j)
            if (ins.charAt(j) == 'R')
                i = (i + 1) % 4;
            else if (ins.charAt(j) == 'L')
                i = (i + 3) % 4;
            else {
                x += d[i][0]; y += d[i][1];
            }
        return x == 0 && y == 0 || i > 0;
    }

    public static void main(String[] args) {


    }
}
