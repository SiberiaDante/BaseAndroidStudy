package com.siberiadante.designpattern.builder.simplebuilder;

/**
 * create date: 2018/7/30
 * update date: 2018/7/30
 * create by SiberiaDante
 * email: 2654828081@qq.com
 * github: https://github.com/SiberiaDante
 * blog: http://www.cnblogs.com/shen-hua/
 * describe:
 */
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
