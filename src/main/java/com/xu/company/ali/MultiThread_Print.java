package com.xu.company.ali;

/**
 * Created by sop on 2020/09/2020/9/2 16:10
 *
 * 题目2：编码实现，两个线程严格交替打印这个字符串。
 * string str = "20200229";
 * @Description:
 */
public class MultiThread_Print {
    //static boolean flag = true;
    static Object lock = new Object();
    static volatile int index = 1;
    static String str = "20200229";

    public static void main(String[] args) {
        Thread first = new Thread(new FirstThread(),"first");
        first.start();
        Thread second = new Thread(new SecondThread(), "sencod");
        second.start();
    }

   static class FirstThread implements Runnable {

        @Override
        public void run() {
            while(true){
                System.out.println("enter first thread!");
                synchronized (lock){
                    if (index % 2 == 0) { //偶数 等待
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName()+": "+str.charAt(index++));
                    }else {

                    }
                }

            }//while

        }
    }


    static class SecondThread implements Runnable {

        @Override
        public void run() {

        }
    }
}
