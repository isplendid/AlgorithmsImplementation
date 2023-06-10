package com.xu.lock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @author xushichao
 * @date 2023/3/25 19:46
 * @desc
 */
public class MultiThread {
    public static void main(String[] args) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        for(ThreadInfo threadInfo: threadInfos){
            System.out.println("["+ threadInfo.getThreadId() + "]" + threadInfo.getThreadName());
        }
    }

    /***
     * [5] Attach Listener //添加事件
     * [4] Signal Dispatcher // 分发处理给 JVM 信号的线程
     * [3] Finalizer //调用对象 finalize 方法的线程
     * [2] Reference Handler //清除 reference 线程
     * [1] main //main 线程,程序入口
     *
     *
     * 一个 Java 程序的运行是 main 线程和多个其他线程同时运行
     */

    //Thread.State;
}
