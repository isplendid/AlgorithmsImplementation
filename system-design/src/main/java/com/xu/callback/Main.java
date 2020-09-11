package com.xu.callback;

/**
 * Created by sop on 2020/09/2020/9/10 15:28
 *
 * @Description:
 */
public class Main {
    public static void main(String[] args) {  //同步回调
        People people = new People();
        Callback callback = new Callback() {
            @Override
            public void printFinished(String msg) {
                System.out.println("打印机告诉我的消息是 ---> " + msg);
            }
        };
        System.out.println("需要打印的内容是 ---> " + "打印一份简历");
        people.goToPrintSyn(callback, "打印一份简历");
        System.out.println("我在等待 打印机 给我反馈");
    }


    public static void main2(String[] args) {  //异步回调
        People people = new People();
        Callback callback = new Callback() {
            @Override
            public void printFinished(String msg) {
                System.out.println("打印机告诉我的消息是 ---> " + msg);
            }
        };
        System.out.println("需要打印的内容是 ---> " + "打印一份简历");
        people.goToPrintASyn(callback, "打印一份简历");
        System.out.println("我在等待 打印机 给我反馈");
    }

}
