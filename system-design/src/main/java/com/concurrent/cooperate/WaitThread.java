package com.concurrent.cooperate;

/**
 * @author xushichao
 * @date 2023/3/28 11:01
 * @desc
 */
public class WaitThread  extends Thread{

    private volatile boolean fire = false;

    @Override
    public void run() {
        try {
            synchronized (this) {
                while (!fire){
                    System.out.println("wait....");
                    wait();
                }
                System.out.println("fired!");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void doFire() {
        this.fire= true;
        notify();
    }

    public static void main(String[] args) throws InterruptedException {
        WaitThread thread = new WaitThread();
        thread.start();
        Thread.sleep(1000);
        System.out.println("to do fire");
        thread.doFire();
    }

}
