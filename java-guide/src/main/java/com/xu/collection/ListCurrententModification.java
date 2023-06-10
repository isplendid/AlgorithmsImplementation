package com.xu.collection;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author xushichao
 * @date 2022/7/29 12:01 PM
 * @desc
 */
public class ListCurrententModification {
    public static void main(String[] args) {
        List list = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
        List subList = list.subList(1, 4);
        System.out.println(subList);
        subList.remove(1);
        System.out.println(list);
        list.add(0);
        try {
            subList.forEach(System.out::println);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
