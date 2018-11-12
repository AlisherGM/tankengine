package com.aci.student24.scene.pojo;

import com.aci.student24.scene.param.Size;
import javafx.scene.Group;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public abstract class RectangleUnit extends Unit {
    private Size size;

    public RectangleUnit(int x, int y, int width, int height, Paint color) {
        super(x-width/2, y-height/2, color);
        size = new Size(width, height);
    }

    @Override
    public void draw(Group root) {
        Rectangle rc = new Rectangle();
        rc.setX(x);
        rc.setY(y);
        rc.setFill(color);
        rc.setWidth(size.getWidth());
        rc.setHeight(size.getHeight());
        root.getChildren().addAll(rc);
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
}
