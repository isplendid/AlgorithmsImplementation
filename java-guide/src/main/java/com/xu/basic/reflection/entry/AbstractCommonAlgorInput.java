package com.xu.basic.reflection.entry;

import com.xu.basic.reflection.annotation.BaseInput;

/**
 * @author xushichao
 * @date 2022/2/9 3:42 PM
 * @desc
 */
public abstract class AbstractCommonAlgorInput<T> extends BaseInput {
    protected int batchIndex;
    protected final T value;
    protected Object userObject;

    public AbstractCommonAlgorInput(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

}
