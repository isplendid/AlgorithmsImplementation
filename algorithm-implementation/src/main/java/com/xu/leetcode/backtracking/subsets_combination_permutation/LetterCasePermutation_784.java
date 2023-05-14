package com.xu.leetcode.backtracking.subsets_combination_permutation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author xushichao
 * @date 2023/1/2 19:58
 * @desc
 */
public class LetterCasePermutation_784 {



    //此方法有点绕，队列不好理解，
    public List<String> letterCasePermutation_bfs(String s) {
        List<String> res = new ArrayList<>();
        Queue<StringBuilder> queue = new LinkedList<>();
        queue.offer(new StringBuilder());
        while (!queue.isEmpty()) {
            StringBuilder curr = queue.peek();
            if (curr.length() == s.length()) {
                res.add(curr.toString());
                queue.poll();
            } else {
                int pos = curr.length();
                if (Character.isLetter(s.charAt(pos))) {
                    StringBuilder next = new StringBuilder(curr);
                    next.append((char) (s.charAt(pos) ^ 32));
                    queue.offer(next);
                }
                curr.append(s.charAt(pos));
            }
        }
        return res;
    }

    public List<String> letterCasePermutation(String s){
        List<String> res = new ArrayList<>();
        dfs(s.toCharArray(), 0, res);
        return res;
    }

    private void dfs(char[] arr, int pos, List<String> res) {
        while(pos < arr.length &&  Character.isDigit(arr[pos])){
            pos++;
        }
        if(pos == arr.length){
            res.add(new String(arr));
            return;
        }
        arr[pos] ^= 32;
        dfs(arr, pos+1, res);
        arr[pos] ^= 32;
        dfs(arr, pos +1, res);
    }


    public static void main(String[] args) {
      //String s = "a1b2";
        String s = "12345";
      LetterCasePermutation_784 letterPerm = new LetterCasePermutation_784();
      List<String> res = letterPerm.letterCasePermutation(s);
        System.out.println(res);
    }
}
