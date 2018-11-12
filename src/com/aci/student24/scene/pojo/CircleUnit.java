package com.aci.student24.scene.pojo;

import javafx.scene.Group;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class CircleUnit extends Unit {
    private int radius;

    public CircleUnit(int x, int y, int radius, Paint color) {
        super(x-radius/2, y-radius/2, color);
        this.radius = radius;
    }

    @Override
    public void draw(Group root) {
        Circle circle = new Circle(x, y, radius, color);
        root.getChildren().addAll(circle);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

}
