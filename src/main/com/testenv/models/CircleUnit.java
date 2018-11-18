package com.testenv.models;

import javafx.scene.Group;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class CircleUnit extends Unit {
    private double radius;

    public CircleUnit(double x, double y, double radius, Paint color) {
        super(x-radius/2, y-radius/2, color);
        this.radius = radius;
    }

    @Override
    public void draw(Group root) {
        Circle circle = new Circle(getX(), getY(), radius, color);
        root.getChildren().addAll(circle);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

}
