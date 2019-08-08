package com.dante.designpattern.factory.abstractf.shapef;


/**
 * create date: 2018/11/6
 */
public class SquareShape implements Shape {
    @Override
    public void draw() {
        System.out.println("---------draw square------------");
    }
}