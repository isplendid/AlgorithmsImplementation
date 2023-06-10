package threadlocal;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.threadpool.TtlExecutors;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xushichao
 * @date 2022/9/7 11:20
 * @desc  解决线程池场景下的变量传递问题
 * 1.ThreadLocal：父子线程不会传递threadLocal副本到子线程中
 * 2.InheritableThreadLocal：在子线程创建的时候，父线程会把threadLocal拷贝到子线中（但是线程池的子线程不会频繁创建，就不会传递信息）
 * 3.TransmittableThreadLocal：解决了2中线程池无法传递线程本地副本的问题，在构造类似Runnable接口对象时进行初始化。
 *
 * 4. TTL内存泄漏的问题
 *
 */
public class TransmittableThreadLocalTest {
    public static void main(String[] args) throws Exception {
        // 1. threadLocal测试
        // -- 输出结果：线程1null
        //            线程2null
        threadLocalTest();
        System.out.println("============================");
        System.out.println();

        // 2. ITL测试
        // -- 输出结果：子线程1我是主线程
        itlTest();
        // -- 输出结果：子线程1我是主线程
        //            子线程2我是主线程
        // -- 结论：InheritableThreadLocal只会在线程初始化的时候将父线程的值拷贝到子线程（仅拷贝一次）
        itlTestThreadPoolTest();
        System.out.println("============================");
        System.out.println();

        // 3. TTL测试
        // 输出结果：我是线程1：我是主线程
        //         修改主线程
        //         我是线程2：修改主线程
        // -- 结论：TTL能在线程池中传递
        ttlTest();
    }
    // TTL测试
    private static void ttlTest() throws InterruptedException {
        TransmittableThreadLocal<String> local = new TransmittableThreadLocal<>();
        local.set("我是主线程");
        //生成额外的代理
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        //**核心装饰代码！！！！！！！！！**
        executorService = TtlExecutors.getTtlExecutorService(executorService);
        CountDownLatch c1 = new CountDownLatch(1);
        CountDownLatch c2 = new CountDownLatch(1);
        executorService.submit(() -> {
            System.out.println("我是线程1：" + local.get());
            c1.countDown();
        });
        c1.await();
        local.set("修改主线程");
        System.out.println(local.get());
        executorService.submit(() -> {
            System.out.println("我是线程2：" + local.get());
            c2.countDown();
        });
        c2.await();
    }
    // ITL测试
    private static void itlTestThreadPoolTest() {
        ThreadLocal<String> local = new InheritableThreadLocal<>();
        try {
            local.set("我是主线程");
            ExecutorService executorService = Executors.newFixedThreadPool(1);
            CountDownLatch c1 = new CountDownLatch(1);
            CountDownLatch c2 = new CountDownLatch(1);
            //初始化init的时候，赋予了父线程的ThreadLocal的值
            executorService.execute(() -> {
                System.out.println("线程1" + local.get());
                c1.countDown();
            });
            c1.await();
            //主线程修改值
            local.set("修改主线程");
            //再次调用，查看效果
            executorService.execute(() -> {
                System.out.println("线程2" + local.get());
                c2.countDown();
            });
            c2.await();
            executorService.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //使用完毕，清除线程中ThreadLocalMap中的key。
            local.remove();
        }
    }

    /***
     * InheritableThreadLocal 测试
     * @throws InterruptedException
     */
    private static void itlTest() throws InterruptedException {
        ThreadLocal<String> local = new InheritableThreadLocal<>();
        local.set("我是主线程");
        new Thread(() -> {
            System.out.println("子线程1" + local.get());
        }).start();
        Thread.sleep(2000);
    }

    /***
     * ThreadLocal测试
     */
    private static void threadLocalTest() {
        ThreadLocal<String> local = new ThreadLocal<>();
        try {
            local.set("我是主线程");
            ExecutorService executorService = Executors.newFixedThreadPool(1);
            CountDownLatch c1 = new CountDownLatch(1);
            CountDownLatch c2 = new CountDownLatch(1);
            executorService.execute(() -> {
                System.out.println("线程1" + local.get());
                c1.countDown();
            });
            c1.await();
            executorService.execute(() -> {
                System.out.println("线程2" + local.get());
                c2.countDown();
            });
            c2.await();
            executorService.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //使用完毕，清除线程中ThreadLocalMap中的key。
            local.remove();
        }
    }

    private static void testTheadLocal() throws InterruptedException {
        ThreadLocal<String> local = new ThreadLocal<>(); // InheritableThreadLocal 会传递
        local.set("mainThread");

        new Thread(new Runnable() {
            @Override
            public void run() {
                //local.set("threadName1");
                System.out.println(local.get());
            }
        }, "thread1").start();
        Thread.sleep(1000);
        System.out.println(local.get());

    }

    public static void main2(String[] args) throws InterruptedException {
        testTheadLocal();
        //threadLocalTest();
    }


}
