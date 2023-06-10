package com.xu.annotation.test;

import java.lang.annotation.*;

/**
 * @author xushichao
 * @date 2022/5/30 6:18 PM
 * @desc
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DistributedLock {

    /**
     * 分布式锁key
     */
    String key();

    /**
     * 获取锁失败提示
     */
    String failMessage() default "";
}
