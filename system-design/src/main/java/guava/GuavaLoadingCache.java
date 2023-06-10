package guava;

import com.google.common.cache.*;

import com.google.common.cache.CacheBuilder;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author xushichao
 * @date 2023/2/22 21:59
 * @desc
 */
public class GuavaLoadingCache {
    public static void main(String[] args) {
        LoadingCache<String, Optional<List<String>>> loadingCache = CacheBuilder
                .newBuilder()
                .expireAfterWrite(3, TimeUnit.SECONDS)
                .removalListener(notification -> System.out.println("cache expired, remove key : " + notification.getKey()))
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
