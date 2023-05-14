package com.xu2023;

/**
 * @author xushichao
 * @date 2023/1/28 21:22
 * @desc
 */
public class RomanNumber {
    //13
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num){
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < values.length; ++i) {
            int value = values[i];
            String symbol = symbols[i];
            while (num >= value) {
                num -= value;
                res.append(symbol);
            }
            if (num == 0) {
                break;
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {

    }
}
