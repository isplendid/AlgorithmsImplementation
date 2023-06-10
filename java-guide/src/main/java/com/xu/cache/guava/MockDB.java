package com.xu.cache.guava;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;

import java.util.*;

/**
 * @author xushichao
 * @date 2022/8/25 11:04 AM
 * @desc
 */
public class MockDB {

    public static List<String> getCityListFromDB(String cityId) {
        System.out.println("getting from DB,cityId:" + cityId + " please wait...");
        List<String> returnList = null;
        // 模仿从数据库中取数据
        try {
            switch (cityId) {
                case "0101":
                    returnList = ImmutableList.of("上海", "北京", "广州", "深圳");
                    break;
            }
        } catch (Exception e) {
            // 记日志
        }
        Queue q = new LinkedList();
        Stack s = new Stack();
        return Optional.fromNullable(returnList).or(Collections.EMPTY_LIST);
    }

}
