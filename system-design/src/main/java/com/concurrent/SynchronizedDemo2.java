package com.concurrent;

/**
 * @author xushichao
 * @date 2023/3/27 14:42
 * @desc
 */
public class SynchronizedDemo2 {

    /***
     * 同步语句块的实现使用的是 monitorenter 和 monitorexit 指令
     */
    public void methodSyncBlock() {
        synchronized (this) {
            System.out.println("synchronized 代码块");
        }
    }

    public synchronized static void methodStatic() {
        System.out.println("synchronized static 方法");
    }

    public synchronized  void methodInstance() {
        System.out.println("synchronized 方法");
    }

}
