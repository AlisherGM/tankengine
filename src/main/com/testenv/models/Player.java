package com.testenv.models;

import java.util.List;

public class Player {
    private List<Tank> tanks;

    public Player(List<Tank> tanks) {
        this.tanks = tanks;
    }

    public List<Tank> getTanks() {
        return tanks;
    }

}
