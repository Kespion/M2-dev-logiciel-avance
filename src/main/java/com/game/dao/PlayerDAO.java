package com.game.dao;

import com.game.players.Player;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsable de la gestion des joueurs dans une base de données simulée.
 * Elle permet d'ajouter, de supprimer, de récupérer un joueur ou d'obtenir des listes de joueurs.
 */
public class PlayerDAO {
    private List<Player> players = new ArrayList<>();

    /**
     * Sauvegarde un joueur dans la "base de données".
     * Le joueur est ajouté à la liste des joueurs.
     *
     * @param player Le joueur à sauvegarder.
     */
    public void savePlayer(Player player) {
        players.add(player);
    }

    /**
     * Supprime un joueur de la "base de données".
     * Le joueur est retiré de la liste des joueurs.
     *
     * @param player Le joueur à supprimer.
     */
    public void removePlayer(Player player) {
        players.remove(player);
    }

    /**
     * Récupère un joueur par son nom.
     *
     * @param name Le nom du joueur à rechercher.
     * @return Le joueur correspondant au nom, ou null si aucun joueur n'est trouvé.
     */
    public Player getPlayer(String name) {
        return players.stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null);
    }

    /**
     * Récupère tous les joueurs dans la base de données.
     *
     * @return La liste de tous les joueurs.
     */
    public List<Player> getAllPlayers() {
        return players;
    }

    /**
     * Récupère les joueurs les mieux classés selon leur score.
     * La liste des joueurs est triée par score décroissant, puis la sous-liste des meilleurs joueurs est retournée.
     *
     * @param count Le nombre de joueurs à récupérer (en fonction du classement).
     * @return La liste des meilleurs joueurs, limitée par le paramètre count.
     */
    public List<Player> getTopPlayers(int count) {
        players.sort((p1, p2) -> Integer.compare(p2.getScore(), p1.getScore()));
        return players.subList(0, Math.min(count, players.size()));
    }
}
