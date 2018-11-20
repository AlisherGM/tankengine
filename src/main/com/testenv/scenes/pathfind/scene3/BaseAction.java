package com.testenv.scenes.pathfind.scene3;

import com.testenv.models.Tank;
import com.testenv.models.UserAction;

public class BaseAction implements UserAction {
    public enum Direction {
        UP,
        RIGHT,
        DOWN,
        LEFT,
    }
    int id;
    Direction dir;
    boolean move;
    Tank tank;

    public BaseAction(int id, Direction dir, boolean move, Tank tank) {
        this.id = id;
        this.dir = dir;
        this.move = move;
        this.tank = tank;
    }

    @Override
    public int tankId() {
        return id;
    }

    @Override
    public double angle() {
        System.out.println(dir);
        System.out.println(tank.getAngle());
        switch (dir) {
            case UP:
                return -90 - tank.getAngle();
            case RIGHT:
                return 0 - tank.getAngle();
            case DOWN:
                return 90 - tank.getAngle();
            case LEFT:
                return 180 - tank.getAngle();
        }
        return 0;
    }

    @Override
    public boolean move() {
        return move;
    }
}
