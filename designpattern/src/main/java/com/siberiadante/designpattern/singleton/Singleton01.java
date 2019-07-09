package com.siberiadante.designpattern.singleton;

/**
 * 懒汉式，lazy初始化，线程不安全,多线程中无法工作：
 */
public class Singleton01 {

    private static Singleton01 singleton01;

    private Singleton01() {
    }

    public static Singleton01 getInstance() {
        if (singleton01 == null) {
            singleton01 = new Singleton01();
        }
        return singleton01;
    }

}
