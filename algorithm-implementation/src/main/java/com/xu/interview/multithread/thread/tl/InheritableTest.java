package com.xu.interview.multithread.thread.tl;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author xushichao
 * @date 2023/5/25 19:13
 * @desc
 */
public class InheritableTest {

    static ThreadLocal<String> local = new ThreadLocal<>();

    static ExecutorService poolExecutor = Executors.newFixedThreadPool(1);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        InheritableTest test = new InheritableTest();
        test.test();;

    }
    private void test() throws ExecutionException, InterruptedException {


        local.set("天王老子");
        Future future = poolExecutor.submit(new Task("任务1"));

        future.get();

        Future future2 = poolExecutor.submit(new Task("任务2"));

        future2.get();

        System.out.println("父线程的值："+local.get());
    }

    class Task implements Runnable{

        String str;
        Task(String str){
            this.str = str;
        }
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+":"+local.get());
            local.set(str);
            System.out.println(local.get());
        }
    }



}
