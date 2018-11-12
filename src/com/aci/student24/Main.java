package com.aci.student24;

import com.aci.student24.scene.Renderer;
import com.aci.student24.scene.pojo.Map;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    private Renderer renderer;
    private Map map;
    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        stage.setScene(new Scene(root, 1200, 900, Color.DARKGRAY));
        stage.show();

        while(! gameEnded() ) {
            tick(root);
        }
    }

    private boolean gameEnded() {
        return false;
    }

    private void tick(Group group) {
        renderer.clear();

        // game logic here

        renderer.draw(map);
    }
}
