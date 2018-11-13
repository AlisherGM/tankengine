package com.testenv;

import com.testenv.bl.Algorithm;
import com.testenv.bl.SessionFabric;
import com.testenv.bl.Settings;
import com.testenv.models.*;
import javafx.application.Application;
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
        Settings settings = new TankWorldSettings();
        SessionFabric session = new SessionFabric(settings);
        map = session.buildMap();
        renderer = session.buildRender(stage);

        algorithms = new ArrayList<>();
        players = new HashMap<>();
        initScene(session);
        tick();
        /*while (true) {
            Thread.sleep(1000);
            tick(session);
        }*/

    }

    private void initScene(SessionFabric session) {

        Tank tank = session.buildTank(1, 100, 100, 90);
        Block block1 = session.buildBlock(400, 500, 0);
        Block block2 = session.buildBlock(780, 600, 0);
        map.addTanks(tank);
        map.addBlocks(block1, block2);

        List<Tank> tanks = new ArrayList<>();

        tanks.add(tank);
        players.put(1, new Player(tanks));

        algorithms.add(new Strategy());
    }

    private void tick() {
        renderer.clear();

        List<List<UserAction>> actions = algorithms.stream().map(a -> a.move(players.get(a.getId()), map)).collect(Collectors.toList());

        actions.forEach(as -> as.forEach(a -> map.apply(a)));

        renderer.draw(map);
    }
}
