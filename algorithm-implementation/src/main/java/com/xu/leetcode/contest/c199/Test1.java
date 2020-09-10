package com.xu.leetcode.contest.c199;

/**
 * Created by sop on 2020/7/26.
 */
public class Test1 {

//    public String restoreString(String s, int[] indices) {
//
//            char[] chars = new char[s.length()];
//            for(int i=0; i<s.length();i++){
//                chars[indices[i]] = s.charAt(i);
//            }
//            return new String(chars);
//    }

    public int minFlips(String target) {
        int c = 0;
        int count = 0;
        int len = target.length();
        while (c < len && target.charAt(c) == '0') {
            c++;
        } //找到第一个1
        while (c < len) {
            count++;
            if (count % 2 == 1) { //找0
                while (c < len && target.charAt(c) == '1' ) {
                    c++;
                }
            } else { //找1
                while (c < len && target.charAt(c) == '0') {
                    c++;
                }
            }
        }

        return count;

    }

    public static void main(String[] args) {
//        String s= "aaiougrt";
//        int[] i = new int[]{4,0,2,6,7,3,1,5};  //arigatou
//        Test1 t = new Test1();
//        System.out.println(t.restoreString(s,i));

        String target = "0000";
        Test1 t = new Test1();
        System.out.println(t.minFlips(target));
    }
}
