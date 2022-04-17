package com.xu;

import org.pf4j.ExtensionPoint;

import java.util.List;

/**
 * @author xushichao
 * @date 2022/2/13 10:22 PM
 * @desc 假设我们需要一个通知用户的功能
 * 需要注意的是，我们一定要继承 ExtensionPoint 接口，表示这是一个扩展点
 */
public interface Notice extends ExtensionPoint {
    boolean notice(List<Long> userIds);
}
