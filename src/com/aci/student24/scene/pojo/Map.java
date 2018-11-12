package com.aci.student24.scene.pojo;

import com.aci.student24.scene.param.Size;
import com.aci.student24.scene.pojo.dao.Drawable;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.util.List;

public class Map implements Drawable {
    private static final Paint color = Color.DARKGRAY;
    private Size size;
    private List<Block> blocks;
    private List<Tank> tanks;

    public Map(int width, int height, List<Block> blocks, List<Tank> tanks) {
        this.blocks = blocks;
        this.tanks = tanks;
    }

    @Override
    public void draw(Group root) {
        tanks.forEach(tank -> tank.draw(root));
        blocks.forEach(block -> block.draw(root));
    }
}
