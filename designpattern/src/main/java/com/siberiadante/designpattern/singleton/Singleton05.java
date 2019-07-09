package com.siberiadante.designpattern.singleton;

/**
 * 静态内部类,lazy初始化,线程安全：
 * 区别第三种,Singleton 类被装载了，instance 不一定被初始化。因为 SingletonHolder 类没有被主动使用；
 * 只有通过显式调用 getInstance 方法时，才会显式装载 SingletonHolder 类，从而实例化
 */
public class Singleton05 {

    private Singleton05() {
    }

    public static Singleton05 getInstance() {
        return Singleton05Holder.s;
    }

    public static class Singleton05Holder {
        private static final Singleton05 s = new Singleton05();
    }

}
