package com.testenv.models;

import javafx.scene.Group;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public abstract class RectangleUnit extends Unit {
    private Size size;
    private double angle;

    public RectangleUnit(double x, double y, Size size, double angle, Paint color) {
        super(x-size.getWidth()/2, y-size.getHeight()/2, color);
        this.size = size;
        this.angle = angle;
    }

    @Override
    public void draw(Group root) {
        Rectangle rc = new Rectangle();
        System.out.println(super.x + " " + super.y);
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
    public double getAngle(){
        return angle;
    }
    public void setAngle(double angle){
        this.angle = angle;
    }
}
