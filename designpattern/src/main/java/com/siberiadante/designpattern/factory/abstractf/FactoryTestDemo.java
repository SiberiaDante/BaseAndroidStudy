package com.siberiadante.designpattern.factory.abstractf;

import com.siberiadante.designpattern.factory.abstractf.colorf.Color;
import com.siberiadante.designpattern.factory.abstractf.shapef.Shape;

/**
 * create date: 2018/11/6
 */
public class FactoryTestDemo {
    public static void main(String[] args) {
        AbstractFactory colorFactory = FactoryProducer.getFactory("Color");
        Color redColor = colorFactory.getColor("RED");
        redColor.fill();
        AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");
        Shape rectangleShape = shapeFactory.getShape("RECTANGLE");
        rectangleShape.draw();
    }
}
