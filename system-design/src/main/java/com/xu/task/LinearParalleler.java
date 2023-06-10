package com.xu.task;

import com.alibaba.ttl.TtlRunnable;
import com.google.common.util.concurrent.RateLimiter;
import com.google.common.util.concurrent.SettableFuture;
import org.apache.commons.lang3.mutable.MutableInt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author xushichao
 * @date 2022/9/5 15:03
 * @desc List<Result> executeTask(List<Task> tasks); 批量获取
 */
public abstract class LinearParalleler<Task, Result> {
    private static final Logger logger = LoggerFactory.getLogger(LinearParalleler.class);

    private final static RateLimiter LOG_LIMITER = RateLimiter.create(2);

    private LinearTaskSplitter<Task> splitter;
    public final ThreadPoolTaskExecutor fetchFeatureExecutor;
    public final String taskName;

    private boolean isLatchTimeout = false;
    private int latchTimeoutCount = 0;
    private int latchTotalCount = 0;
    private int subTaskUnfinishCount = 0;
    private int subTaskErrorCount = 0;

    public LinearParalleler(List<Task> tasks, int ratio, int pieceSize, ThreadPoolTaskExecutor fetchFeatureExecutor, String taskName) {
        this(new LinearTaskSplitter<>(tasks, ratio, pieceSize), fetchFeatureExecutor, taskName);
    }

    public LinearParalleler(LinearTaskSplitter<Task> taskSplitter, ThreadPoolTaskExecutor fetchFeatureExecutor, String taskName) {
        this.splitter = taskSplitter;
        this.fetchFeatureExecutor = fetchFeatureExecutor;
        this.taskName = taskName;
    }


    protected abstract List<Result> executeTask(List<Task> tasks);

    public List<Result> submitAndWait(final long latchWaitTime, final TimeUnit timeUnit) {
        final List<ResultPair<List<Task>, List<Result>>> resultPairs = doSubmitAndWait(latchWaitTime, timeUnit);
        final ArrayList<Result> ret = new ArrayList<>(splitter.getTaskSize());

        final MutableInt index = new MutableInt(0);
        for (ResultPair<List<Task>, List<Result>> pair : resultPairs) {
            if (pair.result == null) {
                fillPositionWithNull(ret, index, pair);
                ++subTaskErrorCount;
            } else if (pair.result.size() != pair.task.size()) {
                fillPositionWithNull(ret, index, pair);
                ++subTaskErrorCount;
                if (LOG_LIMITER.tryAcquire()) {
                    logger.error("{}:输入任务数和拿到结果数量不一致，上游代码写错了，丢弃这部分结果:{},{}", taskName, pair.result.size(), pair.task.size());
                }

            } else {
                for (int i = 0; i < pair.result.size(); ++i) {
                    final Task t = pair.task.get(i);
                    if (t != splitter.get(index.intValue())) {
                        throw new IndexOutOfBoundsException(String.format("%s:输入和输出的Index对应出错:%s", taskName, index));
                    }
                    final Result r = pair.result.get(i);
                    ret.add(r);
                    index.increment();
                }
            }
        }
        if (ret.size() != splitter.getTaskSize()) {
            throw new IndexOutOfBoundsException(String.format("%s:输入和输出的元素个数对应不上：%s != %s", taskName, ret.size(), splitter.getTaskSize()));
        }
        return ret;
    }

    private void fillPositionWithNull(ArrayList<Result> ret, MutableInt index, ResultPair<List<Task>, List<Result>> pair) {
        for (Task task : pair.task) {
            if (task != splitter.get(index.intValue())) {
                throw new IndexOutOfBoundsException(String.format("%s:输入和输出的Index对应出错:%s", taskName, index));
            }
            ret.add(null);
            index.increment();
        }
    }


    private List<ResultPair<List<Task>, List<Result>>> doSubmitAndWait(final long latchWaitTime, final TimeUnit timeUnit) {

        final List<Task> mainTasks = splitter.getMainThreadTask();
        final List<List<Task>> subTasks = splitter.getSubThreadTasks();
        final List<ResultPair<List<Task>, List<Result>>> results = new ArrayList<>();

        if (subTasks.isEmpty()) {
            List<Result> mainResult = doExecuteTaskQuitely(mainTasks);
            results.add(new ResultPair<>(mainTasks, mainResult));
        } else {
            final ArrayList<Future<ResultPair<List<Task>, List<Result>>>> futures = new ArrayList<>(subTasks.size());
            final CountDownLatch latch = new CountDownLatch(subTasks.size());
            this.latchTotalCount = subTasks.size();
            for (final List<Task> task : subTasks) {
                final SettableFuture<ResultPair<List<Task>, List<Result>>> future = SettableFuture.create();
                fetchFeatureExecutor.submit(TtlRunnable.get(new Runnable() {
                    @Override
                    public void run() {
                        List<Result> resultList = null;
                        try {
                            resultList = doExecuteTaskQuitely(task);
                        } finally {
                            future.set(new ResultPair<>(task, resultList));
                            latch.countDown();
                        }
                    }
                }));
                futures.add(future);
            }

            try {
                final List<Result> mainResult = doExecuteTaskQuitely(mainTasks);
                results.add(new ResultPair<>(mainTasks, mainResult));
                waitCountDown(latchWaitTime, timeUnit, latch);
                for (int i = 0; i < futures.size(); ++i) {
                    final Future<ResultPair<List<Task>, List<Result>>> resultFuture = futures.get(i);
                    if (resultFuture.isDone()) {
                        results.add(resultFuture.get());
                    } else {
                        results.add(new ResultPair<>(subTasks.get(i), (List<Result>) null));
                        ++subTaskUnfinishCount;
                    }
                }
            } catch (Exception ex) {
                if (LOG_LIMITER.tryAcquire()) {
                    logger.error("{}:主线程加线程池并行Callable处理'{}'异常", taskName, ex);
                }
            }
        }
        if (subTaskUnfinishCount > 0) {
            logger.error("{}:分批执行任务，总任务数为{}个，{}个任务超时，{}个任务未完成，{}个任务出错，超时时间：{}{}"
                    , taskName, latchTotalCount, latchTimeoutCount, subTaskUnfinishCount, subTaskErrorCount, latchWaitTime, timeUnit
            );
        }
        return results;
    }

    private List<Result> doExecuteTaskQuitely(List<Task> subTasks) {
        try {
            return executeTask(subTasks);
        } catch (Exception ex) {
            if (LOG_LIMITER.tryAcquire()) {
                logger.error("{}:执行子任务列表失败:{}", taskName, subTasks.size(), ex);
            }
        }
        return null;
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

    public void setLatchTimeoutCount(int latchTimeoutCount) {
        this.latchTimeoutCount = latchTimeoutCount;
    }

    public int getLatchTotalCount() {
        return latchTotalCount;
    }

    public int getSubTaskUnfinishCount() {
        return subTaskUnfinishCount;
    }

    public int getSubTaskErrorCount() {
        return subTaskErrorCount;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LinearParalleler{");
        sb.append("splitter=").append(splitter);
        sb.append(", taskName='").append(taskName).append('\'');
        sb.append(", isLatchTimeout=").append(isLatchTimeout);
        sb.append(", latchTimeoutCount=").append(latchTimeoutCount);
        sb.append(", latchTotalCount=").append(latchTotalCount);
        sb.append(", subTaskUnfinishCount=").append(subTaskUnfinishCount);
        sb.append(", subTaskErrorCount=").append(subTaskErrorCount);
        sb.append('}');
        return sb.toString();
    }

}
