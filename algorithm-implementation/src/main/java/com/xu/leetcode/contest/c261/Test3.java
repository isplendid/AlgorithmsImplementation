package com.xu.leetcode.contest.c261;

/**
 * @author xushichao
 * @date 2021/10/3 10:27 AM
 * @desc
 */
public class Test3 {


    public int minimumMoves(String s) {
        int cnt=0;
        for(int i=0; i<s.length();){
            char c = s.charAt(i);
            if(c=='X'){
                cnt++;
                i = i+3;
            } else {
                i++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Test3 test3 = new Test3();
        String s ="00XXXOX";
        System.out.println(test3.minimumMoves(s));
    }
}
