package com.xu.work;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author xushichao
 * @date 2021/2/9 11:18 AM
 * @desc
 */
public class CollectionSet {
    public static void main(String[] args) {
        Set<Integer> s1 = new HashSet<Integer>(Arrays.asList(1,2,3,4,5));
        Set<Integer> s2 = new HashSet<Integer>(Arrays.asList(1,2,3,7,8));
        s2.retainAll(s1);
        System.out.println(s1);
        System.out.println(s2);
    }
}
