package com.xu.basic.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xushichao
 * @date 2022/5/9 7:44 PM
 * @desc
 */
public class TestList {
    public static void main(String[] args) {
        List<Integer>  list = new ArrayList<>();
        list.addAll(Arrays.asList(1,2,3,4,5));

        List<Integer>  removeList = new ArrayList<>();
        removeList.addAll(Arrays.asList(3,4,5,6,7));

        list.removeAll(removeList);
        System.out.println(list);
        System.out.println(removeList);

    }
}
