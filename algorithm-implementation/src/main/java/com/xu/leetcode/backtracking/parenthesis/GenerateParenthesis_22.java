package com.xu.leetcode.backtracking.parenthesis;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sop on 2020/5/30.
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * https://labuladong.gitbook.io/algo/suan-fa-si-wei-xi-lie/he-fa-kuo-hao-sheng-cheng
 */
public class GenerateParenthesis_22 {

    private List<String> res = new ArrayList<String>();
    public List<String> generateParenthesis(int n) {
        StringBuilder track = new StringBuilder();
        backtrack(n, n, track);
        return res;
    }

    //left:可用(剩下)的左括号， right: 可用的右括号数量
    private void backtrack(int left, int right, StringBuilder track){
        //若左括号剩下的多，说明不合法
        if(right<left){
            return ;
        }
        if(left <0 || right <0) {
            return;
        }

        //当所有括号都恰好用完时，得到一个合法的括号组合
        if(left==0 && right ==0){
            res.add(track.toString());
            return;
        }

        //尝试放一个左括号
        track.append("(");
        backtrack(left -1, right, track);
        track.deleteCharAt(track.length() - 1); //移除最后一个

        //尝试放一个右括号
        track.append(")");
        backtrack(left, right -1, track);
        track.deleteCharAt(track.length() - 1); //移除最后一个
    }
}
