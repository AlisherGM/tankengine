package com.testenv;

import com.testenv.bl.Algorithm;
import com.testenv.models.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Main extends Application {
    private Renderer renderer;
    private Map map;
    private List<Algorithm> algorithms;
    private HashMap<Integer, Player> players;

    @Override
    public void start(Stage stage) throws Exception {
        var size = new Size(1000, 1000);
        renderer = new Renderer(size, stage);
        map = new Map(size);
        algorithms = new ArrayList<>();
        players = new HashMap<>();
        initScene(map);

        tick();
    }

    private void initScene(Map map) {
        map.addBlocks(new Block(100, 50, 100, 60, 0));
        var tank = new Tank(300, 300, 100, 100, 45, Color.BLUE, 1);
        map.addTank(tank);
        var tanks = new ArrayList<Tank>();
        tanks.add(tank);
        players.put(1, new Player(tanks));
        algorithms.add(new Strategy());
    }

    private void tick() {
        renderer.clear();

        var actions = algorithms.stream().map(a -> a.move(players.get(a.getId()), map)).collect(Collectors.toList());

        actions.forEach(as->as.forEach(a->map.apply(a)));

        renderer.draw(map);
    }
}
