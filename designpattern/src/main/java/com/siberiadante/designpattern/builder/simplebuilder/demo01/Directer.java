package com.siberiadante.designpattern.builder.simplebuilder.demo01;


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
