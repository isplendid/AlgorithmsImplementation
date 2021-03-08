package com.xu.basic.regex;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author xushichao
 * @date 2021/1/8 10:28 AM
 * @desc
 */
public class SetTest {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1,2,3,4,5));

        Set<Integer> set2 = new HashSet<>(Arrays.asList(2,3,4,5,6,7,8,9));

        set1.retainAll(set2);
        System.out.println(set1);


    }
}
