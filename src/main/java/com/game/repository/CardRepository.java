package com.game.repository;

import com.game.cards.Card;
import java.util.ArrayList;
import java.util.List;

public class CardRepository {
    private List<Card> cards = new ArrayList<>();

    public void addCard(Card card) {
        cards.add(card);
    }

    public void removeCard(Card card) {
        cards.remove(card);
    }

    public List<Card> getAllCards() {
        return cards;
    }

    public Card findCardByName(String name) {
        return cards.stream().filter(card -> card.getName().equals(name)).findFirst().orElse(null);
    }

    public List<Card> filterByType(String type) {
        List<Card> result = new ArrayList<>();
        for (Card card : cards) {
            if (card.getType().equals(type)) {
                result.add(card);
            }
        }
        return result;
    }
}
