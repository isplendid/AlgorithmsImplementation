package com.xu.company.ali;

/**
 * Created by sop on 2020/09/2020/9/2 17:28
 *
 * @Description:
 */
public class InturnPrint {
    static class SoulutionTask implements Runnable{
        static int value = 0;
        @Override
        public void run() {
            while (value <= 100){
                synchronized (SoulutionTask.class){
                    System.out.println(Thread.currentThread().getName() + ":" + value++);
                    SoulutionTask.class.notify();
                    try {
                        SoulutionTask.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class SoulutionTask2 implements Runnable{
        static int value = 0;
        @Override
        public void run() {
            while (value <= 100){
                synchronized (this){
                    System.out.println(Thread.currentThread().getName() + ":" + value++);
                    this.notify();
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        new Thread(new SoulutionTask(), "偶数").start();
        new Thread(new SoulutionTask(), "奇数").start();
    }
}
