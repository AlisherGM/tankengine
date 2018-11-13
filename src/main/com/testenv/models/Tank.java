package com.testenv.models;

import javafx.scene.paint.Paint;

public class Tank extends RectangleUnit {
    private int id;
    public Tank(double x, double y, Size size, double angle, Paint color, int id) {
        super(x, y, size, angle, color);
        this.id = id;
    }
    public int getId() {
        return id;
    }
}
