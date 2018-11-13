package com.testenv.scenes.pathfind.scene1;

import com.testenv.bl.Algorithm;
import com.testenv.bl.Renderer;
import com.testenv.bl.SessionFabric;
import com.testenv.bl.Settings;
import com.testenv.models.*;
import javafx.application.Application;
import javafx.application.Platform;
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
    Thread mainThread;

    @Override
    public void start(Stage stage) {
        Settings settings = new TankWorldSettings();
        SessionFabric session = new SessionFabric(settings);
        renderer = session.buildRender(stage);
        algorithms = new ArrayList<>();
        players = new HashMap<>();
        initScene(session);
        mainThread = new Thread(() -> {
            while (true) {
                Platform.runLater(this::tick);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    break;
                }
            }
        });
        mainThread.start();
}

    private void initScene(SessionFabric session) {
        Tank tank = session.buildTank(1, 100, 100, 0);
        Block block1 = session.buildBlock(400, 500, 0);
        Block block2 = session.buildBlock(780, 600, 0);
        map = session.buildMap();
        map.addTanks(tank);
        map.addBlocks(block1, block2);

        List<Tank> tanks = new ArrayList<>();

        tanks.add(tank);
        players.put(1, new Player(tanks));

        Strategy strategy = new Strategy();
        renderer.getScene().setOnMouseClicked (event -> strategy.onClick(event.getX(), event.getY()));

        algorithms.add(new Strategy());
    }

    private void tick() {
        renderer.clear();

        List<List<UserAction>> actions = algorithms.stream().map(a -> a.move(players.get(a.getId()), map)).collect(Collectors.toList());

        actions.forEach(as -> as.forEach(a -> map.apply(a)));

        renderer.draw(map);
    }
}
