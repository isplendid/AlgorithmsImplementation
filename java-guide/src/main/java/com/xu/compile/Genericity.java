package com.xu.compile;

/**
 * @author xushichao
 * @date 2021/3/9 5:24 PM
 * @desc
 */
public class Genericity {
    public static class Container<T> {
        public  T obj;
    }

    public static void putErrorTypeContainer(Container container) {
        container.obj = "cdw";
    }
    public static void main(String...args) throws Exception {
        Container<Integer> container = new Container<Integer>();
        putErrorTypeContainer(container);
        System.out.println(container.obj);
        //结果是 "cdw" ，因为泛型擦除
    }
}
