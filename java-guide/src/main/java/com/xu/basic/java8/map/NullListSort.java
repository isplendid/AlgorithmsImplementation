package com.xu.basic.java8.map;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author xushichao
 * @date 2021/1/8 8:30 AM
 * @desc
 */
public class NullListSort {

    public static void main(String[] args) {
        List<Com> list = new ArrayList<>();
        list.add(new Com("hello", 10));
        list.add(new Com("abc", 7));
        list.add(new Com("yes", 16));
        //Collections.sort(list);
        List<Com> reslist = list.stream().sorted(Comparator.comparing(Com::getAge)).collect(Collectors.toList());
        System.out.println(reslist);


    }





    static class Com {
        private String name;
        private int age;

        public Com(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Com{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
