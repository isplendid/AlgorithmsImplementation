package com.xu.basic.aop.proxy;

/**
 * @author xushichao
 * @date 2021/7/10 6:19 PM
 * @desc  委托类
 */
public class SomeImpl implements ISome {
    @Override
    public void doSome() {
        System.out.println("原有方法");
    }
}
