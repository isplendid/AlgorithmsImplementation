package com.xu.task;

import com.google.common.util.concurrent.RateLimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author xushichao
 * @date 2022/9/2 20:19
 * @desc   单个 Task -> Result;  ResultPair<Task, Result>
 */
public abstract class SingleParaller<Task, Result> {
    private static final Logger logger = LoggerFactory.getLogger(SingleParaller.class);

    private final static RateLimiter LOG_LIMITER = RateLimiter.create(2);
    private final SingleTaskSplitter<Task> splitter;
    private final ThreadPoolTaskExecutor fetchFeatureExecutor;
    private final String taskName;

    private boolean isLatchTimeout = false;
    private int latchTimeoutCount = 0;
    private int latchTotalCount = 0;
    private int subTaskUnfinishedCount = 0;

    public SingleParaller(final List<Task> tasks, final int ratio, ThreadPoolTaskExecutor fetchFeatureExecutor, String taskName) {
        this(new SingleTaskSplitter<>(tasks, ratio), fetchFeatureExecutor, taskName);
    }

    public SingleParaller(SingleTaskSplitter<Task> taskSplitter, ThreadPoolTaskExecutor fetchFeatureExecutor, String taskName) {
        this.splitter = taskSplitter;
        this.fetchFeatureExecutor = fetchFeatureExecutor;
        this.taskName = taskName;
    }

    protected abstract Result executeTask(Task task);

    public List<ResultPair<Task, Result>> submitAndWait(final long latchWaitTime, final TimeUnit timeUnit) {
        final List<Task> mainTasks = splitter.getMainThreadTasks();
        final List<Task> subTasks = splitter.getSubThreadTasks();
        List<ResultPair<Task, Result>> results = new ArrayList<>();

        if (subTasks.isEmpty()) {
            for (Task task : mainTasks) {
                executeTaskQuietly(results, task);
            }
        } else {
            final ArrayList<Future<ResultPair<Task, Result>>> futures = new ArrayList<>(subTasks.size());
            final CountDownLatch countDownLatch = new CountDownLatch(subTasks.size());
            this.latchTotalCount = subTasks.size();

            for (final Task task : subTasks) {
                final Future<ResultPair<Task, Result>> future = fetchFeatureExecutor.submit(new Callable<ResultPair<Task, Result>>() {
                    @Override
                    public ResultPair<Task, Result> call() throws Exception {
                        try {
                            Result result = executeTask(task);
                            return new ResultPair<>(task, result);
                        } finally {
                            countDownLatch.countDown();
                        }
                    }
                });
                futures.add(future);
            }

            try {
                for (Task task : mainTasks) {
                    executeTaskQuietly(results, task);
                }

                waitCountDown(latchWaitTime, timeUnit, countDownLatch);
                for (int i = 0; i < futures.size(); i++) {
                    final Future<ResultPair<Task, Result>> resultPairFuture = futures.get(i);
                    if (resultPairFuture.isDone()) {
                        results.add(resultPairFuture.get());
                    } else {
                        results.add(new ResultPair<>(subTasks.get(i), (Result) null));
                        ++subTaskUnfinishedCount;
                    }
                }
                if (latchTimeoutCount > 0) {
                    logger.error("{}:分批执行任务，总任务数为{}个，{}个任务超时，{}个Future未拿到结果，超时时间：{}{}"
                            , taskName, latchTotalCount, latchTimeoutCount, subTaskUnfinishedCount, latchWaitTime, timeUnit
                    );
                }
            } catch (Exception e) {
                if (LOG_LIMITER.tryAcquire()) {
                    logger.error("#主线程加线程池并行Callable处理'{}'异常", taskName, e);
                }
            }

        }
        return results;
    }

    private void executeTaskQuietly(List<ResultPair<Task, Result>> results, Task task) {
        try {
            Result result = executeTask(task);
            results.add(new ResultPair<>(task, result));
        } catch (Exception e) {
            if (LOG_LIMITER.tryAcquire()) {
                logger.error("#主线程加线程池执行executeTask出错：{}", e);
            }
        }
    }

    private void waitCountDown(long latchWaitTime, TimeUnit timeUnit, CountDownLatch latch) throws InterruptedException {
        if (latchWaitTime > 0) {
            if (!latch.await(latchWaitTime, timeUnit)) {
                isLatchTimeout = true;
                latchTimeoutCount = (int) latch.getCount();
            }
        } else {
            latch.await();
        }
    }
    public boolean isLatchTimeout() {
        return isLatchTimeout;
    }

    public int getLatchTimeoutCount() {
        return latchTimeoutCount;
    }

    public int getLatchTotalCount() {
        return latchTotalCount;
    }

}
