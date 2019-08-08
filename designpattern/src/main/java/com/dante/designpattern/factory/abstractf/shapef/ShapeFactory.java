package com.dante.designpattern.factory.abstractf.shapef;

import com.dante.designpattern.factory.abstractf.AbstractFactory;
import com.dante.designpattern.factory.abstractf.colorf.Color;

/**
 * create date: 2018/11/6
 */
public class ShapeFactory extends AbstractFactory {
    @Override
    public Color getColor(String color) {
        return null;
    }

    @Override
    public Shape getShape(String shape) {
        if (null == shape)
            return null;
        if (shape.equalsIgnoreCase("RECTANGLE")) {
            return new RectangleShape();
        }
        if (shape.equalsIgnoreCase("SQUARE")) {
            return new SquareShape();
        }
        return null;
    }
}
