package com.game.dao;

import com.game.players.Player;
import java.util.ArrayList;
import java.util.List;

public class PlayerDAO {
    private List<Player> players = new ArrayList<>();

    public void savePlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(Player player) {
        players.remove(player);
    }

    public Player getPlayer(String name) {
        return players.stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null);
    }

    public List<Player> getAllPlayers() {
        return players;
    }

    public List<Player> getTopPlayers(int count) {
        players.sort((p1, p2) -> Integer.compare(p2.getScore(), p1.getScore()));
        return players.subList(0, Math.min(count, players.size()));
    }
}
