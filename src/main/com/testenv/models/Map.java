package com.testenv.models;

import com.testenv.bl.Settings;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Map implements Drawable{

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

    public void apply(UserAction action) {
        tanks.stream().filter(t -> t.getId() == action.tankId()).forEach(tank -> {
            if(tank.getId() != action.tankId()) return;
            if (action.move()) {
                if(Math.abs(action.angle()) < 0.0000000001) {
                    tank.setX(tank.getX() + (settings.getTickSpeed() * Math.cos(Math.toRadians(tank.getAngle()))));
                    tank.setY(tank.getY() + (settings.getTickSpeed() * Math.sin(Math.toRadians(tank.getAngle()))));
                } else {
                    tank.setAngle(tank.getAngle() + Math.signum(action.angle()) *
                            Math.min(Math.abs(action.angle()), settings.getTickAngle()));
                }
            }
        });
    }

    public Size getSize() {
        return settings.getMapSize();
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
}
