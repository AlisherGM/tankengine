package com.testenv.scenes.pathfind.scene1;

import com.testenv.bl.ClickableAlgorithm;
import com.testenv.models.Map;
import com.testenv.models.Player;
import com.testenv.models.Tank;
import com.testenv.models.UserAction;

import java.util.List;
import java.util.stream.Collectors;

public class Strategy implements ClickableAlgorithm {
    static double x=150, y=150;

    @Override
    public List<UserAction> move(Player player, Map map) {
        return player.getTanks().stream()
                .map(t -> getAction(t, map)).collect(Collectors.toList());
    }

    private UserAction getAction(Tank tank, Map map) {
        Double hypotenuse = Math.sqrt(Math.pow(x - tank.getX(), 2) + Math.pow(y - tank.getY(), 2));
        Double cos = (x - tank.getX()) / hypotenuse;
        Double sin = (y - tank.getY()) / hypotenuse;
        Double angle = Math.toDegrees(cos > 0 ? Math.asin(sin) : Math.PI - Math.asin(sin));
        angle = (angle) - tank.getAngle();
        if (angle > 180) angle -= 360;
        return new BaseAction(tank.getId(), angle, true);
    }

    @Override
    public Integer getId() {
        return 1;
    }

    public void onClick(double x, double y) {
        System.out.println(x + " " + y);
        Strategy.x = x;
        Strategy.y = y;
    }
}
