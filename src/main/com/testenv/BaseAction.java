package com.testenv;

import com.testenv.models.UserAction;

public class BaseAction implements UserAction {
    private int id;
    private double angle;
    private boolean move;

    public BaseAction(int id, double angle, boolean move) {
        this.id = id;
        this.angle = angle;
        this.move = move;
    }

    @Override
    public int tankId() {
        return id;
    }

    @Override
    public double angle() {
        return angle;
    }

    @Override
    public boolean move() {
        return move;
    }
}
