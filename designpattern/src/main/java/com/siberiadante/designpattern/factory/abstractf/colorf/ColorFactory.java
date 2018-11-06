package com.siberiadante.designpattern.factory.abstractf.colorf;

import com.siberiadante.designpattern.factory.abstractf.AbstractFactory;
import com.siberiadante.designpattern.factory.abstractf.shapef.Shape;

/**
 * create date: 2018/11/6
 */
public class ColorFactory extends AbstractFactory {
    @Override
    public Color getColor(String color) {
        if (null == color)
            return null;
        if (color.equalsIgnoreCase("RED")) {
            return new RedColor();
        }
        if (color.equalsIgnoreCase("Blue")) {
            return new BlueColor();
        }
        return null;
    }

    @Override
    public Shape getShape(String shape) {
        return null;
    }
}