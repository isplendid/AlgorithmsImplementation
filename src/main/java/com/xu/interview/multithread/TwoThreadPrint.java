//package com.xu.interview.multithread;
//
///**
// * Created by sop on 2020/5/15.
// * <p>
// * 交替打印字符串
// */
//public class TwoThreadPrint {
//    private static String str = "abcdef";
//
//    private static int index = 0;
//    private final static Object lock = new Object();
//
//    public static void main(String[] args) {
//
//        new Thread(() -> {
//            while (index < str.length()) {
//                synchronized (lock) {
//                    try {
//                        if (index % 2 == 1) {
//                            lock.wait();
//                        } else {
//                            System.out.print(str.charAt(index % str.length()));
//                            index++;
//                        }
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    } finally {
//                        lock.notify();
//                    }
//                }
//            }
//        }, "thread1").start();
//        new Thread(() -> {
//            while (index < str.length()) {
//                synchronized (lock) {
//                    try {
//                        if (index % 2 == 0) {
//                            lock.wait();
//                        } else {
//                            System.out.print(str.charAt(index % str.length()));
//                            index++;
//                            if (index % str.length() == 0) {
//                                System.out.println();
//                            }
//                        }
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    } finally {
//                        lock.notify();
//                    }
//                }
//            }
//        }, "thread2").start();
//    }
//}
