package com.xu.callback;

/**
 * Created by sop on 2020/09/2020/9/10 15:26
 *
 * @Description:
 */
public class Printer { //打印机
    public void print(Callback callback, String text) {
        System.out.println("正在打印 . . . ");
        try {
            Thread.currentThread();
            Thread.sleep(3000);// 毫秒
        } catch (Exception e) {
        }
        callback.printFinished("打印完成");
    }
}
