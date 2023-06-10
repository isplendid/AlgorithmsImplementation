package com.concurrent;

/**
 * @author xushichao
 * @date 2023/3/27 10:36
 * @desc  单例模式- 双重校验锁实现单例
 */
public class Singleton {

    private volatile static Singleton uniqueInstance;

    private Singleton() {}


    /***
     *
     * @return
     */
    public Singleton getInstance() {
        //先判断对象是否已经实例过，没有实例化过才进入加锁代码
        if(null == uniqueInstance) {
            //类对象加锁
            synchronized (Singleton.class) {
                if(null == uniqueInstance) {
                    uniqueInstance = new Singleton();
                }
            }
        }

        return uniqueInstance;
    }


}
