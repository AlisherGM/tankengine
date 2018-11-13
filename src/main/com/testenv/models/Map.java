package com.testenv.models;

import com.testenv.bl.Settings;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Map implements Drawable {

    private static final Paint color = Color.DARKGRAY;
    private Settings settings;
    private List<Block> blocks;
    private List<Tank> tanks;

    public Map(Settings settings) {
        this.settings = settings;
        this.blocks = new ArrayList<Block>();
        this.tanks = new ArrayList<Tank>();
    }

    @Override
    public void draw(Group root) {
        tanks.forEach(tank -> tank.draw(root));
        blocks.forEach(block -> block.draw(root));
    }

    public void addBlocks(Block... blocks) {
        this.blocks.addAll(Arrays.asList(blocks));
    }

    public void addTanks(Tank... tanks) {
        this.tanks.addAll(Arrays.asList(tanks));
    }

    public List<Block> getBlocks() {
        return blocks;
    }

    public List<Tank> getTanks() {
        return tanks;
    }

    public void apply(UserAction action) {
        if(action.move()) {
            Tank tank = tanks.stream().filter(t -> t.getId() == action.tankId()).findFirst().get();
            tank.setAngle(tank.getAngle() + action.angle());
            tank.x = (tank.x + settings.getTickSpeed()) * Math.cos(tank.getAngle());
            tank.y = (tank.x + settings.getTickSpeed()) * Math.sin(tank.getAngle());
        }
    }
}
