package com.testenv.models;

import javafx.scene.paint.Paint;

public class Tank extends RectangleUnit {
    private int id;
    public Tank(int x, int y, int width, int height, double angle, Paint color, int id) {
        super(x, y, width, height, angle, color);
        this.id = id;
    }
    public int getId() {
        return id;
    }
}
