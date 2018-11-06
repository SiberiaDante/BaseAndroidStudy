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
public abstract class Builder {
    public abstract void buildDisplay(String display);

    public abstract void buildKeyboard(String keyboard);

    public abstract void buildOs();

    public abstract Computer create();

}
