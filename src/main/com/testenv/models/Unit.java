package com.testenv.models;

import javafx.scene.paint.Paint;

public abstract class Unit implements Drawable {
    public Coordinate coordinate;
    public Paint color;

    public Unit(double x, double y, Paint color){
        this.coordinate = new Coordinate(x, y);
        this.color = color;
    }
    public Unit(Coordinate coordinate, Paint color){
        this.coordinate = coordinate;
        this.color = color;
    }

    public double getX() {
        return coordinate.getX();
    }

    public double getY() {
        return coordinate.getY();
    }


    public Unit setX(double x) {
        this.coordinate.setX(x);
        return this;
    }

    public Unit setY(double y) {
        this.coordinate.setY(y);
        return this;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }
}
