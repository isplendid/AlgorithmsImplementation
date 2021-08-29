package com.xu.basic.aop.proxy;

import java.lang.reflect.Proxy;

/**
 * @author xushichao
 * @date 2021/7/10 6:24 PM
 * @desc 测试类
 */
public class Client {

    public static void main(String[] args) {
        // 生成类似$Proxy0.class文件，存储动态生成的动态类
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        ISome some = new SomeImpl();
        // 创建代理类
        ISome proxy = (ISome) Proxy.newProxyInstance(some.getClass().getClassLoader(), some.getClass().getInterfaces(), new DynamicProxy(some));
        // 执行代理类
        proxy.doSome();
    }
}
