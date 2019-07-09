package com.siberiadante.designpattern.singleton;

/**
 * 饿汉式，lazy初始化,线程安全：
 */
public class Singleton04 {

    private static Singleton04 singleton04;

    private Singleton04() {
    }

    static {
        singleton04 = new Singleton04();
    }

    public static Singleton04 getInstance() {
        return singleton04;
    }
}
