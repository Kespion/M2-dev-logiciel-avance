package com.game.players;

import com.game.cards.Card;
import java.util.ArrayList;
import java.util.List;

/**
 * Représente une crate de jeu décrite par un nom, des points de vie, un deck de cartes et un score.
 */
public class Player {
    private String name;
    private int healthPoints;
    private List<Card> deck;
    private int score;

    /**
     * Constructeur pour créer un joueur avec un nom et des points de vie initiaux.
     * Le deck est initialisé comme une liste vide, et le score commence à 0.
     *
     * @param name Le nom du joueur.
     * @param healthPoints Les points de vie du joueur.
     */
    public Player(String name, int healthPoints) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.deck = new ArrayList<>();
        this.score = 0;
    }

    public String getName() { return name; }
    public int getHealthPoints() { return healthPoints; }
    public List<Card> getDeck() { return deck; }
    public int getScore() { return score; }

    /**
     * Ajoute une carte au deck du joueur.
     *
     * @param card La carte à ajouter au deck.
     */
    public void addCardToDeck(Card card) {
        deck.add(card);
    }

    /**
     * Retire une carte du deck du joueur.
     *
     * @param card La carte à retirer du deck.
     */
    public void removeCardFromDeck(Card card) {
        deck.remove(card);
    }

    /**
     * Guérit le joueur en augmentant ses points de vie.
     *
     * @param points Le nombre de points de vie à ajouter.
     */
    public void heal(int points) {
        this.healthPoints += points;
    }

    /**
     * Inflige des dégâts au joueur en diminuant ses points de vie.
     *
     * @param damage Le nombre de points de dégâts à infliger.
     */
    public void takeDamage(int damage) {
        this.healthPoints -= damage;
    }

    /**
     * Permet au joueur de jouer une carte à partir de son deck en spécifiant l'index de la carte.
     * La carte est ensuite retirée du deck.
     *
     * @param index L'index de la carte à jouer dans le deck.
     * @return La carte jouée.
     */
    public Card playCard(int index) {
        return deck.remove(index);
    }

    /**
     * Vérifie si le joueur est encore en vie (c'est-à-dire si ses points de vie sont supérieurs à 0).
     *
     * @return true si le joueur est en vie, false sinon.
     */
    public boolean isAlive() {
        return healthPoints > 0;
    }

    /**
     * Augmente le score du joueur d'un certain nombre de points.
     *
     * @param increment Le nombre de points à ajouter au score du joueur.
     */
    public void increaseScore(int increment) {
        this.score += increment;
    }

    /**
     * Affiche toutes les cartes du deck du joueur, avec leur description.
     */
    public void displayDeck() {
        for (Card card : deck) {
            System.out.println(card.getDescription());
        }
    }

    /**
     * Trouve la carte la plus puissante dans le deck du joueur.
     *
     * @return La carte la plus puissante, ou null si le deck est vide.
     */
    public Card findStrongestCard() {
        return deck.stream().max((c1, c2) -> Integer.compare(c1.getPower(), c2.getPower())).orElse(null);
    }

    /**
     * Trie le deck du joueur par puissance de manière décroissante.
     */
    public void sortDeckByPower() {
        deck.sort((c1, c2) -> Integer.compare(c2.getPower(), c1.getPower()));
    }

    /**
     * Fournit un résumé des informations du joueur, incluant son nom, ses points de vie, son score et la taille de son deck.
     *
     * @return Un résumé sous forme de chaîne de caractères des informations du joueur.
     */
    public String getPlayerSummary() {
        return String.format("Player: %s, Health: %d, Score: %d, Deck Size: %d", name, healthPoints, score, deck.size());
    }
}
