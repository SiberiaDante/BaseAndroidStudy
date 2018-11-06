package com.siberiadante.designpattern.builder.simplebuilder;

/**
 * create date: 2018/8/2
 */
public class Directer {
    private Builder builder = null;

    public Directer(Builder builder) {
        this.builder = builder;
    }

    public void construct(String display, String keyboard) {
        builder.buildDisplay(display);
        builder.buildKeyboard(keyboard);
        builder.buildOs();
    }
}
