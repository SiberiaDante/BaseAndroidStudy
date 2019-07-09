package com.siberiadante.model;

public class ResFrame {
    private String path;
    private int delay;

    public ResFrame(String path, int delay) {
        this.path = path;
        this.delay = delay;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }
}
