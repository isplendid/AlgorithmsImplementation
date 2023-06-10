package com.concurrent;

import java.util.concurrent.*;
import java.util.function.Function;

/**
 * @author xushichao
 * @date 2023/5/18 11:00
 * @desc
 */

public class DelayQueueTest {

    public static final int SIZE = 10;

    public static void main(String[] args) {
        DelayQueueTest test = new DelayQueueTest();
        //初始化线程池
        BlockingQueue<Runnable> arrayBlockingQueue = new ArrayBlockingQueue<>(10);
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor
                (5, 10, 10, TimeUnit.MILLISECONDS,
                        arrayBlockingQueue, Executors.defaultThreadFactory(),
                        new ThreadPoolExecutor.AbortPolicy());

        DelayQueue<DelayedTask> delayTaskQueue = new DelayQueue<>();
        //模拟SIZE个延迟任务
        for (byte i = 0; i < SIZE; i++) {
            Long runAt = System.currentTimeMillis() + 1000 * i;
            String name = "Zhang_" + i;
            byte age = (byte)(10 + i);
            String gender = (i % 2 == 0 ? "male" : "female");
//            Student student = new StudentBuilder(name, age, gender).height(150 + i).province("ZheJiang").build();
//            delayTaskQueue.put(new DelayedTask<Student>(student, 1, function -> test.print(student), runAt));
        }

        while (true) {
            if (delayTaskQueue.size() == 0) {
                break;
            }
            try {
                //从延迟队列中取值,如果没有对象过期则取到null
                DelayedTask delayedTask = delayTaskQueue.poll();
                if (delayedTask != null) {
                    threadPool.execute(delayedTask);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        threadPool.shutdown();
    }


    public String print(Object object) {
        System.out.println(Thread.currentThread().getName());
        String str = ">>>junit log>>>" + object.getClass().getSimpleName() + ":" + object.toString();
        System.out.println(str);
        return str;
    }

    private static class DelayedTask<T> implements Delayed, Runnable {

        /**
         * 任务参数
         */
        private T taskParam;

        /**
         * 任务类型
         */
        private Integer type;

        /**
         * 任务函数
         */
        private Function<T, String> function;

        /**
         * 任务执行时刻
         */
        private Long runAt;

        public T getTaskParam() {
            return taskParam;
        }
        public Integer getType() {
            return type;
        }
        public Function<T, String> getFunction() {
            return function;
        }
        public Long getRunAt() {
            return runAt;
        }
        DelayedTask(T taskParam, Integer type, Function<T, String> function, Long runAt) {
            this.taskParam = taskParam;
            this.type = type;
            this.function = function;
            this.runAt = runAt;
        }
        @Override
        public void run() {
            if (taskParam != null) {
                function.apply(taskParam);
            }
        }
        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(this.runAt - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }
        @Override
        public int compareTo(Delayed o) {
            DelayedTask object = (DelayedTask)o;
            return this.runAt.compareTo(object.getRunAt());
        }
    }
}


