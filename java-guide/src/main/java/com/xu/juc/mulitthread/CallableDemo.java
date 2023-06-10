package com.xu.juc.mulitthread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author xushichao
 * @date 2023/6/6 10:57
 * @desc
 */
public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());


        new Thread(futureTask, "aaa").start();

        //同一个任务只会执行一次,重启一个线程执行相同的task,不会进去任务
        new Thread(futureTask, "bbb").start();
        System.out.println(Thread.currentThread().getName() + "正在执行");

        //如果非要task的返回值;
        //类似自旋锁;,做完跳出循环,获得callable的值;
        while (!futureTask.isDone()) {

        }

        int i = 121;
        //get是阻塞的方法,一般放在最后执行
        System.out.println("resutl:" + (i + futureTask.get()));



    }
}

class MyThread implements Callable<Integer> {

    @Override
    public Integer call() {
        try {
            TimeUnit.SECONDS.sleep(5);
            System.out.println("call");
//            throw  new InterruptedException();
        } catch (InterruptedException e) {
            e.printStackTrace();
//futuretask的get方法也可以接受到处理异常的 返回信息;
            return 4444;
        }

        return 555;
    }

}
