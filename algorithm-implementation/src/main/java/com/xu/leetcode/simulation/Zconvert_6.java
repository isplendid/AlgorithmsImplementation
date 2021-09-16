package com.xu.leetcode.simulation;

/**
 * @author xushichao
 * @date 2021/9/9 11:02 PM
 * @desc
 */
public class Zconvert_6 {
    class Solution {
        public String convert(String s, int numRows) {
            if (numRows == 1) {
                return s;
            }
            StringBuilder[] res = new StringBuilder[numRows];
            for (int i = 0; i < numRows; i++) {
                res[i] = new StringBuilder();
            }

            //遍历字符串s指针
            int index = 0;
            //来来回回的行指针
            int row = 0;
            int len = s.length();
            while (index < len) {
                //从上往下
                while (index < len && row < numRows) {
                    char ch = s.charAt(index++);
                    res[row].append(ch);
                    row++;
                }
                if (index == len) {
                    break;
                }
                row = numRows - 2;
                //从下往上
                while (index < len && row >= 0) {
                    char ch = s.charAt(index++);
                    res[row].append(ch);
                    row--;
                }

                row += 2;
            }

            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < numRows; i++) {
                ans.append(res[i]);
            }
            return ans.toString();
        }

    }


}
