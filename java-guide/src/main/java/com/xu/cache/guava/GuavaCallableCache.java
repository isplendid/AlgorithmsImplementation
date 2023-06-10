package com.xu.cache.guava;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author xushichao
 * @date 2022/8/25 11:13 AM
 * @desc
 * 注意点： 由于guava cache是存在就取不存在就加载的机制，我们可以对缓存数据有修改的地方显示的把它清除掉，然后再有任务去取的时候就会去数据源重新加载，
 * 这样就可以最大程度上保证获取缓存的数据跟数据源是一致的。
 *
 * CallableCache的方式最大的特点在于可以在get的时候动态的指定load的数据源：
 *
 * 与 LoadingCache对比
 * 1）与上面例子唯一的不同就是没有在build的时候传入CacheLoader，而是在cache.get使用Cache的时候用传入Callable对象。
 * 2）
 */
public class GuavaCallableCache {
    public static void main(String[] args) {
        final String key = "0101";
        Cache<String, Optional<List<String>>> cache = CacheBuilder
                .newBuilder()
                .expireAfterWrite(3, TimeUnit.SECONDS)
                .removalListener(notification -> System.out.println("cache expired, remove key : " + notification.getKey()))
                .build();




        try {
            Optional<List<String>> optional;
            System.out.println("load from cache once : " + cache.get(key, () -> Optional.ofNullable(MockDB.getCityListFromDB(key))).orElse(null));
            Thread.sleep(2000);
            System.out.println("load from cache twice : " + cache.get(key, () -> Optional.ofNullable(MockDB.getCityListFromDB(key))).orElse(null));
            Thread.sleep(2000);
            System.out.println("load from cache third : " + cache.get(key, () -> Optional.ofNullable(MockDB.getCityListFromDB(key))).orElse(null));
            Thread.sleep(2000);
            final String nullKey = "0103";
            optional = cache.get(nullKey, () -> Optional.ofNullable(MockDB.getCityListFromDB(nullKey)));
            System.out.println("load not exist key from cache : " + optional.orElse(null));
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
