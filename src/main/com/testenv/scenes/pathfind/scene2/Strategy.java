package com.testenv.scenes.pathfind.scene2;

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
        double angle = Math.toDegrees(cos > 0 ? Math.asin(sin) : Math.PI - Math.asin(sin));
        if(angle > 180) angle -= 360;
        if(angle < -180) angle += 360;
        if(hypotenuse < 25) return new BaseAction(tank.getId(), BaseAction.Direction.DOWN, false, tank);
        if(Math.abs(angle) > 135) return new BaseAction(tank.getId(), BaseAction.Direction.LEFT, true, tank);
        if(Math.abs(angle) < 45) return new BaseAction(tank.getId(), BaseAction.Direction.RIGHT, true, tank);
        if(angle < 0) return new BaseAction(tank.getId(), BaseAction.Direction.UP, true, tank);
        return new BaseAction(tank.getId(), BaseAction.Direction.DOWN, true, tank);
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
