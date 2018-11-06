package com.siberiadante.designpattern.factory.abstractf.shapef;

/**
 * create date: 2018/11/6
 */
public class RectangleShape implements Shape {
    @Override
    public void draw() {
        System.out.println("----------draw rectangle------------");
    }
}