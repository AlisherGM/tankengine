package com.testenv.models;

import javafx.scene.Group;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public abstract class RectangleUnit extends Unit {
    private Size size;
    private double angle;

    public RectangleUnit(int x, int y, int width, int height, double angle, Paint color) {
        super(x-width/2, y-height/2, color);
        size = new Size(width, height);
        this.angle = angle;
    }

    @Override
    public void draw(Group root) {
        Rectangle rc = new Rectangle();
        rc.setX(x);
        rc.setY(y);
        rc.setFill(color);
        rc.setWidth(size.getWidth());
        rc.setHeight(size.getHeight());
        rc.setRotate(angle);
        root.getChildren().addAll(rc);
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
}
