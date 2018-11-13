package com.testenv.scenes.pathfind.scene2;

import com.testenv.bl.Settings;
import com.testenv.models.Size;

public class TankWorldSettings implements Settings {

    @Override
    public double getTickSpeed() {
        return 50;
    }

    @Override
    public double getTickAngle() {
        return 360;
    }

    @Override
    public Size getMapSize() {
        return new Size(800, 800);
    }

    @Override
    public Size getTankSize() {
        return new Size(50, 50);
    }

    @Override
    public Size getBlockSize() {
        return new Size(50, 50);
    }
}
