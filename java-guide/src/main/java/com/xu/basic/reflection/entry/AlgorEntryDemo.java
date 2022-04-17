package com.xu.basic.reflection.entry;

import com.xu.basic.reflection.annotation.AlgorithmEntry;

/**
 * @author xushichao
 * @date 2022/2/9 3:45 PM
 * @desc
 */
@AlgorithmEntry(key = "holmes.test.algor")
public class AlgorEntryDemo implements IAlgorEntry{
    @Override
    public RoutingKeys createRoutingKeys(Object rawInput) {
        return null;
    }

    @Override
    public AbstractCommonAlgorInput<?> buildInput(Object rawInput) {
        return null;
    }
}
