package com.testenv;

import com.testenv.bl.Settings;
import com.testenv.models.Size;
import javafx.scene.Scene;

public class TankWorldSettings implements Settings {

    @Override
    public double getTickSpeed() {
        return 25;
    }

    @Override
    public double getTickAngle() {
        return 20;
    }

    @Override
    public Size getMapSize() {
        return new Size(1400, 800);
    }

    @Override
    public Size getTankSize() {
        return new Size(50, 50);
    }

    @Override
    public Size getBlockSize() {
        return new Size(30, 30);
    }
}
