package com.xu.callback;

/**
 * Created by sop on 2020/09/2020/9/10 15:28
 *
 * @Description:
 */
public class People {
    Printer printer = new Printer();
    /*
     * 同步回调
     */
    public void goToPrintSyn(Callback callback, String text) {
        printer.print(callback, text);
    }

    /*
     * 异步回调
     */
    public void goToPrintASyn(Callback callback, String text) {
        new Thread(new Runnable() {
            public void run() {
                printer.print(callback, text);
            }
        }).start();
    }
}
