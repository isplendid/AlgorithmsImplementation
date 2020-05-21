package com.xu.interview.multithread;

/**
 * Created by sop on 2020/5/17.
 * 开启两个线程交替打印如下字符串：
 * A1B2C3D45E6F7G8H9I10J11K12L13M14N 15O16P17Q18R19S20T21U22V23W24X25Y26
 * 线程1负责输出字母线程二负责输出数字
 */
public class TwoThreadTurnPrint_A1 {
    private static char start = 'A' -1;
    static Object lock = new Object();

    /***
     * 1. 线程1 首先 唤醒(notify) 等待锁的线程2，然后线程1放弃锁 wait 跳出同步代码块
     * 2. 线程2获取到锁后唤醒(notify)线程1,然后线程2自己放弃锁，跳出同步代码块
     * 3. 线程1获取锁接着第一步同步代码块后面执行打印出了大写字母A,接着唤醒(notify)线程2
     * 4. 线程2获取到锁后接着第二步的同步代码块后打印出数字1
     * 5.线程2获取到锁后接着第二步的同步代码块后打印出数字1
     * 注意：线程调用notify方法虽然会唤醒在等待锁的线程，但是当前线程不会立即释放锁  同时被唤醒线程也不会立刻得到锁,
     * 而是要等待当前线程执行完同步代码块的线程,当前线程才释放锁, 被唤醒线程才能得到
     * @param args
     */
    public static void main(String[] args) {


//
//        new Thread(() -> {
//          for(int i=1; i<=26; i++){
//              synchronized (lock){
//                  lock.notify();  // 字母
//                  try {
//                      lock.wait();
//                  } catch (InterruptedException e) {
//                      e.printStackTrace();
//                  }
//                  System.out.print((char)(start + i));
//                  lock.notify();
//              }
//
//          }
//
//        },"letter").start();
//
//
//        new Thread(() -> {
//            for(int i=1; i<=26; i++){
//                synchronized (lock){
//                    lock.notify();  //数字
//                    try {
//                        lock.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.print(i);
//                }
//            }
//
//        },"digit").start();

    String str1= "abc";
        String str2 = "bcd";
        System.out.println("va: "+str1.compareTo(str2));

        String i= "002";
        int value = Integer.parseInt(i);
        System.out.println(value);
        System.out.println(String.valueOf(value).length() != i.length());

    }

}
