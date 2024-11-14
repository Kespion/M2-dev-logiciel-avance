package com.game.players;

import com.game.cards.Card;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private int healthPoints;
    private List<Card> deck;
    private int score;

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

    public void addCardToDeck(Card card) {
        deck.add(card);
    }

    public void removeCardFromDeck(Card card) {
        deck.remove(card);
    }

    public void heal(int points) {
        this.healthPoints += points;
    }

    public void takeDamage(int damage) {
        this.healthPoints -= damage;
    }

    public Card playCard(int index) {
        return deck.remove(index);
    }

    public boolean isAlive() {
        return healthPoints > 0;
    }

    public void increaseScore(int increment) {
        this.score += increment;
    }

    public void displayDeck() {
        for (Card card : deck) {
            System.out.println(card.getDescription());
        }
    }

    public Card findStrongestCard() {
        return deck.stream().max((c1, c2) -> Integer.compare(c1.getPower(), c2.getPower())).orElse(null);
    }

    public void sortDeckByPower() {
        deck.sort((c1, c2) -> Integer.compare(c2.getPower(), c1.getPower()));
    }

    public String getPlayerSummary() {
        return String.format("Player: %s, Health: %d, Score: %d, Deck Size: %d", name, healthPoints, score, deck.size());
    }
}
