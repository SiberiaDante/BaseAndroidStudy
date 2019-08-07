package com.siberiadante.customview.turntableview.model;

import java.io.Serializable;

public class TurnItemModel implements Serializable {
    private String title;//1000,
    private int lipoCoin = -1;//1000
    private int chance;//    2250

    public TurnItemModel(String title, int lipoCoin) {
        this.title = title;
        this.lipoCoin = lipoCoin;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLipoCoin() {
        return lipoCoin;
    }

    public void setLipoCoin(int lipoCoin) {
        this.lipoCoin = lipoCoin;
    }

    public int getChance() {
        return chance;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }
}
