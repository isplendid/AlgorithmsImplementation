package com.xu.basic.reflection.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author xushichao
 * @date 2022/2/9 2:17 PM
 * @desc
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface AlgorithmVersion {
    // 在管理平台唯一的version key
    String key();

    //ContextFeature[] contextFeatures() default {};
}
