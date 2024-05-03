//package com.xu2023;
//
//import org.checkerframework.checker.units.qual.C;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author xushichao
// * @date 2023/1/30 17:27
// * @desc
// *
// * knowledge:
// * char: The char data type is a single 16-bit Unicode character. It has a minimum value of '\\u0000' (or 0) and a maximum value of '\\uffff' (or 65,535 inclusive).
// */
//public class Codec {
//
//    // Encodes a list of strings to a single string.
//    public String encode(List<String> strs) {
//     StringBuilder sb = new StringBuilder();
//     for(String str:strs) {
//         sb.append(int2Str(str.length()));
//         sb.append(str);
//     }
//     return sb.toString();
//    }
//
//
//    /**
//     * 存储字符串长度， 长度 -> char[2]
//     * @param
//     * @return
//     * eg: 5,  char[0]= '\u0005','\u0000';
//     *
//     */
//    private String int2Str(int x) {
//        char[] bytes = new char[2];
//        //bytes[0]存低16位，bytes[1]存高16位
//        bytes[0] = (char) (x & 0xFFFF);
//        bytes[1] = (char) ((x >> 16) & 0xFFFF);
//        return new String(bytes);
//    }
//
//
//    /***
//     * 异或解码，从utf字符解码成数字
//     * @param s
//     * @return
//     */
//    private int str2Int(String s) {
//        char[] bytes = s.toCharArray();
//        int x = 0;
//        x = x ^(int) bytes[0];
//        x = x ^ ((int)bytes[1] << 16);
//        return x;
//    }
//
//    // Decodes a single string to a list of strings.
//    public List<String> decode(String s) {
//        List<String> res = new ArrayList<>();
//        int i=0;
//        while(i<s.length()) {
//            int len = str2Int(s.substring(i, i+2));
//            i +=2;
//            res.add(s.substring(i, i+len));
//            i +=len;
//        }
//        return res;
//    }
//
//    // Decodes bytes string to integer
//    public int stringToInt(String bytesStr) {
//        int result = 0;
//        for(char b : bytesStr.toCharArray())
//            result = (result << 16) + (int)b;
//        return result;
//    }
//
//    public static void main1(String[] args) {
//        Codec c= new Codec();
//
//        String s = "hello, wrorld";
//        int sInt = c.str2Int(s);
//
//        System.out.println(sInt);
//
//        String s2 = c.int2Str(sInt);
//        System.out.println(s2);
//
//    }
//
//    public static void main(String[] args) {
//        List<String> inputs = new ArrayList<>();
//        inputs.add("Helloyeswhodhdaxddc");
//        inputs.add("World@@");
//        Codec codec = new Codec();
//        String s1 = codec.encode(inputs);
//        System.out.println("s1: " + s1);
//        List<String> de = codec.decode(s1);
//        System.out.println("list: "+de);
//    }
//}
//
//// Your Codec object will be instantiated and called as such:
//// Codec codec = new Codec();
//// codec.decode(codec.encode(strs));
//
//
////Follow up: Could you write a generalized algorithm to work on any possible set of characters?