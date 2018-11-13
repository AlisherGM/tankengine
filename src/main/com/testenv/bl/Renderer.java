package com.testenv.bl;

import com.testenv.models.Drawable;
import com.testenv.models.Size;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class Renderer {
    private final static Paint color = Color.DARKGRAY;
    private Group root;
    private Scene scene;

    public Renderer(Size size, Stage stage) {
        root = new Group();
        scene = new Scene(root, size.getWidth(), size.getHeight(), color);
        scene.setOnMouseClicked(event -> {
            System.out.println(event.getX() + " " + event.getY());
        });
        stage.setScene(scene);
        stage.show();
    }

    public void draw(Drawable item) {
        item.draw(root);
    }

    public void clear() {
        root.getChildren().clear();
    }

    public Scene getScene() {
        return scene;
    }

}
