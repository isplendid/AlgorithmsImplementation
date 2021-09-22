package com.xu.leetcode.parenthesis;

/**
 * @author xushichao
 * @date 2021/9/19 9:42 AM
 * @desc 平衡括号串
 */
public class MinAddToMakeValid_921 {
    /**
     * 以 '('为基准，统计个数，如果<0 计算 负值数量
     * @param s
     * @return
     */
    public int minAddToMakeValid(String s) {
        int leftCnt = 0;
        int minAdd = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                leftCnt++;
            } else if (c == ')') {
                leftCnt--;
            }
            if (leftCnt < 0) {
                minAdd += -leftCnt; //计算负值数量
                leftCnt = 0;
            }
        }
        return minAdd + leftCnt;
    }

    public static void main(String[] args) {
        MinAddToMakeValid_921 minAdd = new MinAddToMakeValid_921();
        String s = "(())((";
        System.out.println(minAdd.minAddToMakeValid(s));
    }
}
