package com.testenv.bl;


import com.testenv.Renderer;
import com.testenv.models.Block;
import com.testenv.models.Map;
import com.testenv.models.Tank;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SessionFabric {
    private Settings settings;

    public SessionFabric(Settings settings) {
        this.settings = settings;
    }

    public Map buildMap(){
        return new Map(settings);
    }

    public Tank buildTank(int id, int x, int y, double angle) {
        return new Tank(x, y, settings.getTankSize(), angle, Color.rgb(105, 42, 64), id);
    }

    public Block buildBlock(int x, int y, double angle){
        return new Block(x, y, settings.getBlockSize(), angle, Color.gray(0.3));
    }

    public Renderer buildRender(Stage stage){
        return new Renderer(settings.getMapSize(), stage);
    }
}
