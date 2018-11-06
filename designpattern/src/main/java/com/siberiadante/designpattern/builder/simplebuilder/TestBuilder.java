package com.siberiadante.designpattern.builder.simplebuilder;

import android.util.Log;

/**
 * create date: 2018/8/2
 */
public class TestBuilder {

    public TestBuilder() {
        Builder builder = new MacBookBuilder();
        Directer directer = new Directer(builder);
        directer.construct("英特尔主板", "Retina显示器");
        Log.e("Build Test", builder.create().toString());
    }
}
