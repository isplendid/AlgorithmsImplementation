package com.xu.posting;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xushichao
 * @date 2021/5/10 6:11 PM
 * @desc
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        List<Integer> res = list.stream().filter(t -> isEven(t)).collect(Collectors.toList());
        System.out.println(res.size());
    }
    private static boolean isEven(Integer val) {
        return val % 2 ==0;
    }
}
