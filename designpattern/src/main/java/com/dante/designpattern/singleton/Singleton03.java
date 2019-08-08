package com.dante.designpattern.singleton;

/**
 * 饿汉式，不是lazy初始化,线程安全：
 */
public class Singleton03 {

    private static Singleton03 singleton03 = new Singleton03();

    private Singleton03() {
    }

    public static Singleton03 getInstance() {
        return singleton03;
    }
}
