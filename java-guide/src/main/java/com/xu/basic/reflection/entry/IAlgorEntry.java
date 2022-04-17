package com.xu.basic.reflection.entry;

/**
 * @author xushichao
 * @date 2022/2/9 3:39 PM
 * @desc
 */
public interface IAlgorEntry<INPUT> {

    RoutingKeys createRoutingKeys(INPUT rawInput);

    AbstractCommonAlgorInput<?> buildInput(INPUT rawInput);

}
