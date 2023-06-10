package com.xu.task;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author xushichao
 * @date 2022/9/5 10:55
 * @desc
 */
public class SingleParallerTest {
    ThreadPoolTaskExecutor executor;
    @Before
    public void setUp() {
        executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(4);
        executor.setMaxPoolSize(16);
        executor.setQueueCapacity(512);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
    }

    @After
    public void clean() {
        executor.destroy();
    }


    private void checkAllEquals(final List<Integer> tasks, int ratio, int pieceSize) {
        SingleParaller<Integer, Long> paralleler = new SingleParaller<Integer, Long>(tasks, ratio, executor, "测试") {
            @Override
            protected Long executeTask(Integer integer) {
                return integer.longValue();
            }
        };
        List<ResultPair<Integer, Long>> results = paralleler.submitAndWait(500, TimeUnit.MILLISECONDS);
        Assert.assertEquals(results.size(), tasks.size());
        for(int i = 0; i<tasks.size(); ++i) {
            Assert.assertEquals(results.get(i).result.longValue(), results.get(i).task.longValue());
        }
        Assert.assertFalse(paralleler.isLatchTimeout());
        Assert.assertTrue(paralleler.getLatchTimeoutCount() >= 0);
        Assert.assertTrue(paralleler.getLatchTotalCount() >= 0);
    }

    private void checkAllNull(final List<Integer> tasks, int ratio, int pieceSize) {
        SingleParaller<Integer, Long> paraller = new SingleParaller<Integer, Long>(tasks, ratio, executor, "测试") {
            @Override
            protected Long executeTask(Integer integer) {
                return null;
            }
        };
        List<ResultPair<Integer, Long>> results = paraller.submitAndWait(500, TimeUnit.MILLISECONDS);
        Assert.assertEquals(results.size(), tasks.size());
        for(int i = 0; i<tasks.size(); ++i) {
            Assert.assertNull(results.get(i).result);
        }
    }


}
