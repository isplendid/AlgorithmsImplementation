package com.xu.leetcode.contest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sop on 2020/08/2020/8/28 21:46
 *
 * @Description:
 */
public class JugeCircle {

    /***
     * 657. 机器人能否返回原点
     * 在二维平面上，有一个机器人从原点 (0, 0) 开始。给出它的移动顺序，判断这个机器人在完成移动后是否在 (0, 0) 处结束。     *
     * 移动顺序由字符串表示。字符 move[i] 表示其第 i 次移动。机器人的有效动作有 R（右），L（左），U（上）和 D（下）。
     * 如果机器人在完成所有动作后返回原点，则返回 true。否则，返回 false。

     * @param moves
     *
     * 时间：0（N)
     * 空间：O(1)
     * @return
     */
    public boolean judgeCircle1(String moves) {
        int x = 0, y = 0;
        int length = moves.length();
        for (int i = 0; i < length; i++) {
            char move = moves.charAt(i);
            if (move == 'U') {
                y--;
            } else if (move == 'D') {
                y++;
            } else if (move == 'L') {
                x--;
            } else if (move == 'R') {
                x++;
            }
        }
        return x == 0 && y == 0;
    }

    //空间复杂度有点高
    public boolean judgeCircle(String moves) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('L',0);
        map.put('R',0);
        map.put('U',0);
        map.put('D',0);
        for(int i=0; i<moves.length(); i++){
            char t = moves.charAt(i);
            map.put(t,map.get(t)+1);
        }
        return map.get('L').intValue()== map.get('R').intValue() && map.get('U').intValue() == map.get('D').intValue();

    }

    public static void main(String[] args) {
        String str = "LL";
        JugeCircle judge = new JugeCircle();

        System.out.println(judge.judgeCircle(str));
    }
}
