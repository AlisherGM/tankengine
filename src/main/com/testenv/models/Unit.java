package com.testenv.models;

import javafx.scene.paint.Paint;

public abstract class Unit implements Drawable {
    public double x;
    public double y;
    public Paint color;

    public Unit(double x, double y, Paint color){
        System.out.println("->" + x + " " + y);
        this.x = x;
        this.y = y;
        this.color = color;
    }
}
