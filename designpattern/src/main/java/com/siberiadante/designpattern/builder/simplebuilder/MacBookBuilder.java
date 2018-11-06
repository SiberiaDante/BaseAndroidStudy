package com.siberiadante.designpattern.builder.simplebuilder;

import android.os.Build;
import android.util.Log;

/**
 * create date: 2018/7/30
 * update date: 2018/7/30
 * create by SiberiaDante
 * email: 2654828081@qq.com
 * github: https://github.com/SiberiaDante
 * blog: http://www.cnblogs.com/shen-hua/
 * describe:
 */
public class MacBookBuilder extends Builder {
    private Computer macBookComputer;

    public MacBookBuilder() {
        macBookComputer = new MacBookComputer();
    }

    public MacBookBuilder setDisplay(String display) {
        buildDisplay(display);
        return this;
    }

    @Override
    public void buildDisplay(String display) {
        macBookComputer.setDisplay(display);
    }

    @Override
    public void buildKeyboard(String keyboard) {
        macBookComputer.setKeyboard(keyboard);
    }

    @Override
    public void buildOs() {
        macBookComputer.setOs();
    }

    @Override
    public Computer create() {
        Log.e("Build Test", macBookComputer.toString());
        return macBookComputer;
    }

    public MacBookBuilder setKeyboard(String keyboard) {
        buildKeyboard(keyboard);
        return this;
    }

    public MacBookBuilder setOs() {
        buildOs();
        return this;
    }

//    public static class Builder {
//        private MacBookBuilder builder;
//
//        public Builder() {
//            builder = new MacBookBuilder();
//        }
//
//        public Builder setDisplay(String display) {
//            builder.buildDisplay(display);
//            return this;
//        }
//
//        public Builder setOs() {
//            builder.buildOs();
//            return this;
//        }
//
//        public Builder setKeyboard(String keyboard) {
//            builder.buildKeyboard(keyboard);
//            return this;
//        }
//    }

}
