package com.xu.basic.java8.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xushichao
 * @date 2021/1/8 8:08 AM
 * @desc
 */
public class MapMain {

    public static void main(String[] args) {
        Map<String, List<String>> map1 = new HashMap<>();
//
//        //方法一：
        map1.computeIfAbsent("xsc", k -> new ArrayList<>()).add("hello");
        map1.computeIfAbsent("xsc", k -> new ArrayList<>()).add("hello2");

//        map.get("xsc").add("world");
       System.out.println("method1： " + map1);

//        //方法二：
//        map.putIfAbsent("xsc", new ArrayList<>());
//        map.get("xsc").add("hello");
//        map.get("xsc").add("world");
//        System.out.println(map);
//
//
//
//        //方法三：
//        System.out.println(map.getOrDefault("xsc1", new ArrayList<>()));

    }
}
