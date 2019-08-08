package com.dante.designpattern.singleton;

/**
 * 双重校验锁DCL(double-checked locking)，lazy初始化,线程安全：
 */
public class Singleton07 {
    private static Object obj = new Object();
    private volatile static Singleton07 singleton07;

    private Singleton07() {
    }

    public static Singleton07 getInstance() {
        if (null == singleton07) {
            synchronized (obj) {
                if (null == singleton07) {
                    singleton07 = new Singleton07();
                }
            }
        }
        return singleton07;
    }
}
