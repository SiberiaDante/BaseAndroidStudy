package com.dante.designpattern.factory.abstractf.colorf;

/**
 * create date: 2018/11/6
 */
public class BlueColor implements Color {
    @Override
    public void fill() {
        System.out.println("-----fill blue color---------");
    }
}