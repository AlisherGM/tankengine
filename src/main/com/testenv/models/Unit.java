package com.testenv.models;

import javafx.scene.paint.Paint;

public abstract class Unit implements Drawable {
    public int x;
    public int y;
    public Paint color;

    public Unit(int x, int y, Paint color){
        this.x = x;
        this.y = y;
        this.color = color;
    }
}
