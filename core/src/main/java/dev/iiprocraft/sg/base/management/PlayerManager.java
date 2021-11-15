package dev.iiprocraft.sg.base.management;

import dev.iiprocraft.sg.base.player.SGPlayer;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

public class PlayerManager implements dev.iiprocraft.sg.api.player.PlayerManager {

    private final Map<UUID, SGPlayer> players = new ConcurrentHashMap<>();

    @Override
    public SGPlayer getSGPlayer(UUID id) {
        return players.get(id);
    }

    public void updatePlayerWith(SGPlayer player, Function<SGPlayer, SGPlayer> update) {
        players.computeIfPresent(player.getId(), (k, v) -> update.apply(v));

        //TODO update data into database
        //TODO Should be synchronized for performance
        /* synchronized(mainInstance/apiInstance) {
                //core.getStorage().update();
            }
        */

    }

    public void insertPlayer(UUID id) {
        //TODO SGPlayer player = getStorage().loadPlayer(id);
        //TODO players.putIfAbsent(id, player);
    }

    public void remove(UUID id) {
        players.remove(id);
    }

}
