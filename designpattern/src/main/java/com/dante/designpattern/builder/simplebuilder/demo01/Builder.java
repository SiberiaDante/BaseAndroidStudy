package com.dante.designpattern.builder.simplebuilder.demo01;


public abstract class Builder {
    public abstract void buildDisplay(String display);

    public abstract void buildKeyboard(String keyboard);

    public abstract void buildOs();

    public abstract Computer create();

}
