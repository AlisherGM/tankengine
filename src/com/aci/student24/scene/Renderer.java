package com.aci.student24.scene;

import com.aci.student24.scene.param.Size;
import com.aci.student24.scene.pojo.dao.Drawable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class Renderer {
    private final static Paint color = Color.DARKGRAY;
    private Group root;

    public Renderer(Size size, Stage stage) {
        root = new Group();
        stage.setScene(new Scene(root, size.getWidth(), size.getHeight(), color));
        stage.show();
    }

    public void draw(Drawable item) {
        item.draw(root);
    }

    public void clear() {
        root.getChildren().clear();
    }
}