package com.dante.designpattern.factory.abstractf;

import com.dante.designpattern.factory.abstractf.colorf.Color;
import com.dante.designpattern.factory.abstractf.shapef.Shape;

/**
 * create date: 2018/11/6
 */
public abstract class AbstractFactory {
    public abstract Color getColor(String color);
    public abstract Shape getShape(String shape);
}
