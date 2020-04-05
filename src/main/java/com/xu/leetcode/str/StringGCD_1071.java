package com.xu.leetcode.str;

/**
 * Created by sop on 2020/3/12.
 */
public class StringGCD_1071 {
    public String gcdOfStrings(String str1, String str2) {
        // 假设str1是N个x，str2是M个x，那么str1+str2肯定是等于str2+str1的。
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        // 辗转相除法求gcd。
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    private int gcd(int a, int b) {
        return b == 0? a: gcd(b, a % b);
    }


    //链接：https://leetcode-cn.com/problems/greatest-common-divisor-of-strings/solution/java-hen-jian-ji-yi-yan-jiu-neng-kan-ming-bai-by-s/

}
