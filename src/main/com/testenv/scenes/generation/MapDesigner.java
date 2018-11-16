package com.testenv.scenes.generation;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;

public class MapDesigner extends Application {

    private static final String mapName = "MyMap"; // название файла, сохраняется в src/resources
    private static final int width = 800; // ширина карты
    private static final int height = 600; // длина карты
    private static final int partX = 20; //кол-во блоков по иксу (желательно указывать такое число, что width % partX = 0)
    private static final int partY = 20; //кол-во блоков по игреку (желательно указывать такое число, что height % partY = 0)
    private static final int unitWidth = width / partX; // ширина одного блока
    private static final int unitHeight = height / partY; // длина одного блока

    private int[][] map;
    private Group root;

    @Override
    public void start(Stage stage) {
        map = new int[partX][partY];
        root = new Group();
        Scene scene = new Scene(root, width, height);

        scene.setOnMouseDragged(event -> onDraw(event.getX(), event.getY()));
        scene.setOnMouseDragEntered(event -> onDraw(event.getX(), event.getY()));
        scene.setOnMouseClicked(event -> onDraw(event.getX(), event.getY()));

        stage.setScene(scene);
        stage.show();
    }

    private void onDraw(double x, double y) {
        double posX = x - (x % unitWidth);
        double posY = y - (y % unitHeight);
        Rectangle unit = new Rectangle(posX, posY, unitWidth, unitHeight);
        unit.setFill(Color.BLACK);
        root.getChildren().add(unit);
        int mapX = (int)(posX / unitWidth);
        int mapY = (int)(posY / unitHeight);
        map[mapY][mapX] = 1;
    }

    @Override
    public void stop() throws Exception {
        File file = new File("src\\resources\\" + mapName + ".txt");
        if (!file.exists()) {
            if (!file.createNewFile()) {
                super.stop();
            }
        }
        FileWriter fw = new FileWriter(file);
        for (int i = 0; i < partX; i++) {
            for (int j = 0; j < partY; j++) {
                if (i != partX - 1 || j != partY - 1) {
                    fw.write(map[i][j] + ", ");
                } else {
                    fw.write(String.valueOf(map[i][j]));
                }
            }
            fw.write("\n");
        }
        fw.close();
        super.stop();
    }
}
