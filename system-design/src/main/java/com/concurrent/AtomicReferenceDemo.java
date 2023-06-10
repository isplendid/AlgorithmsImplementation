package com.concurrent;

/**
 * @author xushichao
 * @date 2023/3/27 14:21
 * @desc
 * 从 JDK 1.5 开始，提供了AtomicReference类来保证引用对象之间的原子性，
 * 你可以把多个变量放在一个对象里来进行 CAS 操作.
 * 所以我们可以使用锁或者利用AtomicReference类把多个共享变量合并成一个共享变量来操作

 */
public class AtomicReferenceDemo {
}
