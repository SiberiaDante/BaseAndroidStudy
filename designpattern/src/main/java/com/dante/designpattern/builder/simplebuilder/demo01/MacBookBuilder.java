package com.dante.designpattern.builder.simplebuilder.demo01;


public class MacBookBuilder extends Builder {
    private Computer macBookComputer;

    public MacBookBuilder() {
        macBookComputer = new MacBookComputer();
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
        System.out.println(macBookComputer.toString());
        return macBookComputer;
    }

    public MacBookBuilder setDisplay(String display) {
        buildDisplay(display);
        return this;
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
