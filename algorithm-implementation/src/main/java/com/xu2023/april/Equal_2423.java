package com.xu2023.april;

import com.xu.algs.basic.In;

import java.util.*;

/**
 * @author xushichao
 * @date 2023/4/29 22:32
 * @desc
 */
public class Equal_2423 {
    public static boolean equalFrequency(String word) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c: word.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list);

        int first = list.get(0);

        int sum =0;

        for(Integer e:list) {
            sum += e;
        }
        int size = list.size();
        if(first == 1 && first * size == sum) {
            return true;
        }

        if(first * list.size() + 1 == sum) {
            return true;
        }

        return false;


    }

    public static void main(String[] args) {
        String word = "ddaccb";
        boolean res =equalFrequency(word);
        System.out.println(res);
    }
}
