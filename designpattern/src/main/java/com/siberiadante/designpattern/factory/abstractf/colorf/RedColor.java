package com.siberiadante.designpattern.factory.abstractf.colorf;

/**
 * create date: 2018/11/6
 */
public class RedColor implements Color {
    @Override
    public void fill() {
        System.out.println("-----fill red color---------");
    }
}