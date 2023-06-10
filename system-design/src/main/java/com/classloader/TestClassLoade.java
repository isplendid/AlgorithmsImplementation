package com.classloader;

/**
 * @author xushichao
 * @date 2023/4/5 22:30
 * @desc
 */
public class TestClassLoade {
    public static void main(String[] args) {
        ClassLoader loader = TestClassLoade.class.getClassLoader();
        while(loader!=null) {
            System.out.println(loader);
            loader = loader.getParent();
        }
    }
}
