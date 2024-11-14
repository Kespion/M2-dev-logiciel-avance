package com.game;

import com.game.cards.Card;
import com.game.players.Player;
import com.game.matches.Match;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialisation des joueurs
        System.out.println("Bienvenue dans l'arène !");
        System.out.print("Nom du Joueur 1 : ");
        Player player1 = new Player(scanner.nextLine(), 100);

        System.out.print("Nom du Joueur 2 : ");
        Player player2 = new Player(scanner.nextLine(), 100);

        // Ajout des cartes aux decks
        player1.addCardToDeck(new Card("Fireball", 10, "Attack", "rare"));
        player1.addCardToDeck(new Card("Healing Potion", 0, "Heal", "common"));
        player1.addCardToDeck(new Card("Ice Shard", 8, "Attack", "common"));

        player2.addCardToDeck(new Card("Thunder Strike", 12, "Attack", "rare"));
        player2.addCardToDeck(new Card("Shield Block", 0, "Defense", "common"));
        player2.addCardToDeck(new Card("Earth Smash", 9, "Attack", "common"));

        // Lancer le match
        Match match = new Match(player1, player2);
        match.startMatch();

        scanner.close();
    }
}
