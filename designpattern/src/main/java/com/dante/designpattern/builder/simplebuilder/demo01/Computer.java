package com.dante.designpattern.builder.simplebuilder.demo01;


public abstract class Computer {
    public String display;
    public String keyboard;
    public String os;

    public void setDisplay(String display) {
        this.display = display;
    }

    public void setKeyboard(String keyboard) {
        this.keyboard = keyboard;
    }

    public abstract void setOs();

    @Override
    public String toString() {
        return "Computer{" +
                "display='" + display + '\'' +
                ", keyboard='" + keyboard + '\'' +
                ", os='" + os + '\'' +
                '}';
    }
}
