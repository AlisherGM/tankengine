package com.testenv;

import com.testenv.models.Block;
import com.testenv.models.Map;
import com.testenv.models.Size;
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
        var size = new Size(1000, 1000);
        var root = new Group();
        renderer = new Renderer(size, stage);
        stage.setScene(new Scene(root, 1200, 900, Color.DARKGRAY));
        stage.show();
        map = new Map(size);
        initMap(map);
        tick(root);
    }

    private void initMap(Map map) {
        map.addBlocks(new Block(100, 50, 100, 60));
    }

    private void tick(Group group) {
        //renderer.clear();

        // game logic here

        renderer.draw(map);
    }
}
