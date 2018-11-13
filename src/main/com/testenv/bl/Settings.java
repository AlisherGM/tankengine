package com.testenv.bl;

import com.testenv.models.Size;

public interface Settings {
    double getTickSpeed();
    double getTickAngle();
    Size getMapSize();
    Size getTankSize();
    Size getBlockSize();
}
