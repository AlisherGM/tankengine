package com.aci.student24.scene.pojo;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Block extends RectangleUnit {
    private final static Paint color = Color.DARKSLATEGRAY;

    public Block(int x, int y, int width, int height) {
        super(x, y, width, height, color);
    }
}
