package com.testenv;

import com.testenv.bl.Algorithm;
import com.testenv.models.Map;
import com.testenv.models.Player;
import com.testenv.models.UserAction;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Strategy implements Algorithm {

    @Override
    public List<UserAction> move(Player player, Map map) {
        return player.getTanks().stream()
                .map(t -> new BaseAction(t.getId(), 0, true)).collect(Collectors.toList());
    }

    @Override
    public Integer getId() {
        return 1;
    }
}
