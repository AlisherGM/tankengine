package com.testenv.bl;

import com.testenv.models.Map;
import com.testenv.models.Player;
import com.testenv.models.UserAction;

import java.util.List;

public interface Algorithm {
    List<UserAction> move(Player player, Map map);

    Integer getId();
}
