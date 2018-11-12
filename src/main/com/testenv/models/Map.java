package com.testenv.models;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.util.ArrayList;
import java.util.List;

public class Map implements Drawable {
    private static final Paint color = Color.DARKGRAY;
    private Size size;
    private List<Block> blocks;
    private List<Tank> tanks;

    public Map(Size size) {
        this.blocks = new ArrayList<Block>();
        this.tanks = new ArrayList<Tank>();
    }

    @Override
    public void draw(Group root) {
        tanks.forEach(tank -> tank.draw(root));
        blocks.forEach(block -> block.draw(root));
    }

    public void addBlocks(Block block) {
        blocks.add(block);
    }

    public void addTank(Tank tank) {
        tanks.add(tank);
    }
}
