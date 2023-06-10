package com.xu;

import java.util.HashSet;
import java.util.TreeSet;

/**
 * @author xushichao
 * @date 2023/3/30 21:59
 * @desc
 */
public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        //Class c = Class.forName("com.xu.demo");
        HashSet<String> set1 = new HashSet<>();
        String s1 = "xu";
        String s2 = "shi";
        String s3 = "chao";
        set1.add(s1);
        set1.add(s2);
        set1.add(s3);
        System.out.println(set1.hashCode());


        HashSet<String> set2 = new HashSet<>();
        String s11 = "xu";
        String s21 = "shi";
        String s31 = "chao";
        set2.add(s31);
        set2.add(s21);
        set2.add(s11);
        System.out.println(set2.hashCode());

        TreeSet treeSet = new TreeSet();
        treeSet.add("xushichao");
        treeSet.hashCode();
    }
}
