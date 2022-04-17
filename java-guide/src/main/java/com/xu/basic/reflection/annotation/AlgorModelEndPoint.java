package com.xu.basic.reflection.annotation;

import com.xu.basic.reflection.IModelInput;
import com.xu.basic.reflection.IModelOutput;
import com.xu.basic.reflection.ModelExecutionResource;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author xushichao
 * @date 2022/2/9 2:04 PM
 * @desc
 */
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AlgorModelEndPoint {

    /**
     * EndPoint插入点Key的前缀
     */
    String MODEL_KEY_HOLDER_SUFFIX = "algorithm.model.";

    /**
     * 支持两种方式指定ModelKey:
     * 1. 字符串常量方式，即指定一个模型管理平台注册的modelKey
     * 2. 变量，变量是通过算法版本管理中的算法参数来实现的。要求格式为：${algorithm.model.xxx.yyyy}
     * @return
     */
    String modelKey();

    /**
     * 当前这个EndPoint的执行方式：
     * 1. LOCAL 本地执行，即模型加载待业务方本地内存进行执行；
     * 2. REMOTE 远程执行，即模型加载到ModelServer上，通过RPC的方式调用执行；
     * @return
     */
    ModelExecutionResource executionType() default ModelExecutionResource.LOCAL;

    /**
     * 批量执行模型的时候，每一批的大小
     * @return
     */
    int batchSize() default 20;

    /**
     * 当前EndPoint的执行顺序，ordinal小的先执行
     * @return
     */
    int ordinal() default 0;

    /**
     * 当前EndPoint是否懒加载，满足条件的时候再执行，默认直接执行
     * @return
     */
    boolean lazyExecution()  default false;

    /**
     * 获取其他数据所需要的输入PB的Class
     * @return
     */
    Class<? extends IModelInput> inputClass() default IModelInput.class;

    /**
     * 获取其他数据所需要的输出PB的Class
     * @return
     */
    Class<? extends IModelOutput> outputClass() default IModelOutput.class;
}