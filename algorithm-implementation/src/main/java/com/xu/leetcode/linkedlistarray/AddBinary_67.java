package com.xu.leetcode.linkedlistarray;

/**
 * Created by sop on 2019/2/16.
 *
 * Given two binary strings, return their sum (also a binary string).

 The input strings are both non-empty and contains only characters 1 or 0.

 Example 1:

 Input: a = "11", b = "1"
 Output: "100"
 Example 2:

 Input: a = "1010", b = "1011"
 Output: "10101"
 */
public class AddBinary_67 {

    public String addBinary1(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        int i=0, carry =0;
        String res = "";
        while( i<aLen || i< bLen || carry != 0) {
            int x = (i<aLen) ? Character.getNumericValue(a.charAt(aLen -1 -i)): 0;
            int y = (i<bLen) ? Character.getNumericValue(b.charAt(bLen -1 -i)): 0;
            res = (x + y + carry) % 2 + res;
            carry = (x + y + carry) /2;
            i++;
        }
        return  res;
    }

    /** if you don't want to use getNumericValue:
     * int x=(i<alen)?((a.charAt(alen-1-i)=='1')?1:0):0;
     int y=(i<blen)?((b.charAt(blen-1-i)=='1')?1:0):0;
     */
}
