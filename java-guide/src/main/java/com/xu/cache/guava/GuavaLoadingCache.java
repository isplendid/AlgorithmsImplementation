package com.xu.cache.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author xushichao
 * @date 2022/8/25 11:05 AM
 * @desc
 *
 * 用法：
 * 1、removalListener：用来监听当缓存里面的key被移除时候触发的事件；
 * 2、build(new CacheLoader<String, Optional<String>>()：传入一个CacheLoader类，指定缓存中没有的时候调用 CacheLoader 类的load方法（所以一般需要重写该方法）；
 * 3、optional：当CacheLoader尝试获取数据库中不存在的数据会抛出异常，所以我们这里使用Optional可空对象处理一下
 * 4、Thread.sleep(2000)：缓存我们设置3秒过期，所以两次Sleep以后就会重新获取数据库。
 */
public class GuavaLoadingCache {

    public static void main(String[] args) {
        LoadingCache<String, Optional<List<String>>>  loadingCache = CacheBuilder
                .newBuilder()
                .expireAfterWrite(3, TimeUnit.SECONDS)
                .removalListener(removalNotification -> System.out.println(" cache expired, remove key: " + removalNotification.getKey()))
                .build(new CacheLoader<String, Optional<List<String>>>() {
                    @Override
                    public Optional<List<String>> load(String key) throws Exception {
                        return Optional.ofNullable(MockDB.getCityListFromDB(key));
                    }
                });


        try {
            System.out.println("load from cache once : " + loadingCache.get("0101").orElse(Lists.newArrayList()));
            Thread.sleep(2000);
            System.out.println("load from cache two : " + loadingCache.get("0101").orElse(Lists.newArrayList()));
            Thread.sleep(2000);
            System.out.println("load from cache three : " + loadingCache.get("0101").orElse(Lists.newArrayList()));
            Thread.sleep(2000);
            System.out.println("load not exist key from cache : " + loadingCache.get("0103").orElse(Lists.newArrayList()));

        } catch (ExecutionException | InterruptedException e) {
            //记录日志
        }
    }


}
