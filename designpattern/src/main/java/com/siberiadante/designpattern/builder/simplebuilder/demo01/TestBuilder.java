package com.siberiadante.designpattern.builder.simplebuilder.demo01;

/**
 * create date: 2018/8/2
 */
public class TestBuilder {

    public static void main(String[] args) {
        Builder builder = new MacBookBuilder();
        Directer directer = new Directer(builder);
        directer.construct("英特尔主板", "Retina显示器");
        System.out.println( builder.create().toString());
    }
}
