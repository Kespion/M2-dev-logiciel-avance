package com.game.matches;

import com.game.players.Player;
import com.game.cards.Card;
import com.game.utils.GameUtils;

public class Match {
    private Player player1;
    private Player player2;
    private int roundCounter;

    public Match(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.roundCounter = 0;
    }

    public void startMatch() {
        System.out.println("\nLe match commence entre " + player1.getName() + " et " + player2.getName() + " !");

        while (player1.isAlive() && player2.isAlive() && !player1.getDeck().isEmpty() && !player2.getDeck().isEmpty()) {
            System.out.println("\n*** Round " + ++roundCounter + " ***");

            // Joueur 1 joue une carte
            playTurn(player1, player2);

            // Vérification si le joueur 2 est toujours en vie
            if (!player2.isAlive()) break;

            // Joueur 2 joue une carte
            playTurn(player2, player1);

            System.out.println(player1.getName() + " : " + player1.getHealthPoints() + " HP");
            System.out.println(player2.getName() + " : " + player2.getHealthPoints() + " HP");
        }

        declareWinner();
    }

    private void playTurn(Player attacker, Player defender) {
        if (attacker.getDeck().isEmpty()) return;

        Card card = attacker.playCard(0);

        switch (card.getType()) {
            case "Heal":
                attacker.heal(GameUtils.applyHealing(15, 5));
                System.out.println(attacker.getName() + " utilise " + card.getName() + " et regagne des points de vie.");
                break;

            case "Defense":
                System.out.println(attacker.getName() + " utilise " + card.getName() + " pour se protéger.");
                break;

            case "Attack":
                int damage = GameUtils.calculateDamage(card.getPower(), 1);
                if (GameUtils.isCriticalHit(0.2)) {  // 20% chance of critical hit
                    damage = GameUtils.applyCriticalHit(damage);
                    System.out.println("Coup critique !");
                }
                defender.takeDamage(damage);
                System.out.println(attacker.getName() + " utilise " + card.getName() + " et inflige " + damage + " dégâts à " + defender.getName());
                break;

            default:
                System.out.println(attacker.getName() + " utilise une carte inconnue !");
        }
    }

    private void declareWinner() {
        if (player1.isAlive() && !player2.isAlive()) {
            System.out.println("\n" + player1.getName() + " remporte le match !");
        } else if (player2.isAlive() && !player1.isAlive()) {
            System.out.println("\n" + player2.getName() + " remporte le match !");
        } else {
            System.out.println("\nMatch nul ! Les deux joueurs sont épuisés.");
        }
    }
}
