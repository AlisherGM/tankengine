package com.testenv.scenes.pathfind.scene3;

import com.testenv.bl.Algorithm;
import com.testenv.bl.Renderer;
import com.testenv.bl.SessionFabric;
import com.testenv.bl.Settings;
import com.testenv.models.*;
import com.testenv.scenes.pathfind.scene3.strategy.Strategy;
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

    private static final int[][] MAP =
            {
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1},
                    {1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1},
                    {1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1},
                    {1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1},
                    {1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1},
                    {1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1},
                    {1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1},
                    {1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0 ,0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            };

    @Override
    public void start(Stage stage) {
        Settings settings = new TankWorldSettings();
        SessionFabric session = new SessionFabric(settings);
        renderer = session.buildRender(stage);
        algorithms = new ArrayList<>();
        players = new HashMap<>();
        initScene(session);
        Thread mainThread = new Thread(() -> {
            while (true) {
                Platform.runLater(this::tick);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    break;
                }
            }
        });
        mainThread.start();
}

    private void initScene(SessionFabric session) {
        map = session.buildMap();


        for(int x=0; x<16; x++) {
            for(int y=0; y<16; y++) {
                if(MAP[y][x] == 1) {
                    Block block = session.buildBlock(x * 50 + 25, y * 50 + 25, 0);
                    map.addBlocks(block);
                }
            }
        }


        Tank tank = session.buildTank(1, 75, 75, 0);

        Tank tank2 = session.buildTank(2, 175, 75, 0);

        Tank tank3 = session.buildTank(3, 75, 175, 0);

        Tank tank4 = session.buildTank(4, 175, 75, 0)

        List<Tank> tanks = new ArrayList<>();
        tanks.add(tank);
        tanks.add(tank2);
        tanks.add(tank3);
        tanks.add(tank4);
        players.put(1, new Player(tanks));

        map.addTanks(tank);
        map.addTanks(tank2);
        map.addTanks(tank3);
        map.addTanks(tank4);

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
