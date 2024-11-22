package com.game.matches;

import com.game.players.Player;
import com.game.cards.Card;
import com.game.utils.GameUtils;

/**
 * Classe représentant un match entre deux joueurs. Le match consiste en une série de tours
 * où chaque joueur joue une carte et effectue des actions comme attaquer, se soigner ou se défendre.
 * Le match continue jusqu'à ce qu'un joueur perde tous ses points de vie ou que l'un des joueurs
 * n'ait plus de cartes à jouer.
 */
public class Match {

    private Player player1;
    private Player player2;
    private int roundCounter;

    /**
     * Constructeur pour créer un match entre deux joueurs.
     *
     * @param player1 Le premier joueur du match.
     * @param player2 Le second joueur du match.
     */
    public Match(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.roundCounter = 0;
    }

    /**
     * Démarre le match entre les deux joueurs. Le match se déroule par rounds, et chaque joueur joue à tour de rôle.
     * Le match se termine lorsqu'un joueur est éliminé ou qu'un des joueurs n'a plus de cartes.
     */
    public void startMatch() {
        System.out.println("\nLe match commence entre " + player1.getName() + " et " + player2.getName() + " !");

        // Le match continue tant que les deux joueurs sont vivants et ont des cartes dans leur deck
        while (player1.isAlive() && player2.isAlive() && !player1.getDeck().isEmpty() && !player2.getDeck().isEmpty()) {
            System.out.println("\n*** Round " + ++roundCounter + " ***");

            // Le joueur 1 joue son tour
            playTurn(player1, player2);

            // Vérification si le joueur 2 est toujours en vie après le tour du joueur 1
            if (!player2.isAlive()) break;

            // Le joueur 2 joue son tour
            playTurn(player2, player1);

            System.out.println(player1.getName() + " : " + player1.getHealthPoints() + " HP");
            System.out.println(player2.getName() + " : " + player2.getHealthPoints() + " HP");
        }

        // Déclare le gagnant une fois le match terminé
        declareWinner();
    }

    /**
     * Effectue le tour d'un joueur, qui peut jouer une carte et effectuer une action selon le type de la carte.
     *
     * @param attacker Le joueur qui attaque (qui joue son tour).
     * @param defender Le joueur qui défend (qui subit l'attaque ou l'effet).
     */
    private void playTurn(Player attacker, Player defender) {
        if (attacker.getDeck().isEmpty()) return;  // Si le joueur n'a plus de cartes, il ne joue pas

        // Le joueur joue la première carte de son deck
        Card card = attacker.playCard(0);

        switch (card.getType()) {
            case "Heal":
                // Si la carte est de type "Heal", le joueur se soigne
                attacker.heal(GameUtils.applyHealing(15, 5));
                System.out.println(attacker.getName() + " utilise " + card.getName() + " et regagne des points de vie.");
                break;

            case "Defense":
                // Si la carte est de type "Defense", le joueur se protège
                System.out.println(attacker.getName() + " utilise " + card.getName() + " pour se protéger.");
                break;

            case "Attack":
                // Si la carte est de type "Attack", le joueur attaque l'autre joueur
                int damage = GameUtils.calculateDamage(card.getPower(), 1);
                if (GameUtils.isCriticalHit(0.2)) {  // 20% de chance de coup critique
                    damage = GameUtils.applyCriticalHit(damage);
                    System.out.println("Coup critique !");
                }
                defender.takeDamage(damage);
                System.out.println(attacker.getName() + " utilise " + card.getName() + " et inflige " + damage + " dégâts à " + defender.getName());
                break;

            default:
                // Si la carte est de type inconnu, un message est affiché
                System.out.println(attacker.getName() + " utilise une carte inconnue !");
        }
    }

    /**
     * Déclare le gagnant du match en fonction de l'état des joueurs.
     * Le joueur avec des points de vie restants est déclaré vainqueur.
     */
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
