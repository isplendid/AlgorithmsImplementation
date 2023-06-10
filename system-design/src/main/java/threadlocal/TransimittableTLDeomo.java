package threadlocal;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.TtlRunnable;
import com.alibaba.ttl.threadpool.TtlExecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xushichao
 * @date 2022/9/7 14:34
 * @desc 解决线程池中，父子线程本地线程副本传递的问题
 */
public class TransimittableTLDeomo {

    public static void main(String[] args) {
        // 用TransmittableThreadLocal
        TransmittableThreadLocal<Integer> ttl = new TransmittableThreadLocal<>();
// 1. 用TtlCallable.get(callable)包裹callable 或 用TtlRunnable.get(callable)包裹runnable
        Runnable runnable = () -> System.out.println("ttl信息：" + ttl.get());
        TtlRunnable.get(runnable);

// 2. 用TtlExecutors.getTtlExecutorService包裹
        ExecutorService ttlExecutorService = TtlExecutors.getTtlExecutorService(Executors.newFixedThreadPool(1));
        ttlExecutorService.execute(() -> System.out.println("ttl信息：" + ttl.get()));
    }
}
