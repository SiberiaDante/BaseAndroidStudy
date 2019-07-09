package com.siberiadante.designpattern.singleton;

/**
 * 懒汉式，lazy初始化,线程安全：
 */
public class Singleton02 {

    private static Singleton02 singleton02;

    private Singleton02() {
    }

    public static synchronized Singleton02 getInstance() {
        if (singleton02 == null) {
            singleton02 = new Singleton02();
        }
        return singleton02;
    }
}
