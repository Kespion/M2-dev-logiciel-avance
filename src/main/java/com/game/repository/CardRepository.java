package com.game.repository;

import com.game.cards.Card;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsable de la gestion des cartes dans un Repository.
 * Elle permet d'ajouter, de supprimer, de récupérer toutes les cartes,
 * de trouver une carte par son nom et de filtrer les cartes par type.
 */
public class CardRepository {
    private List<Card> cards = new ArrayList<>();

    /**
     * Ajoute une carte au dépôt.
     *
     * @param card La carte à ajouter au dépôt.
     */
    public void addCard(Card card) {
        cards.add(card);
    }

    /**
     * Supprime une carte du dépôt.
     *
     * @param card La carte à supprimer du dépôt.
     */
    public void removeCard(Card card) {
        cards.remove(card);
    }

    /**
     * Récupère toutes les cartes présentes dans le dépôt.
     *
     * @return La liste de toutes les cartes du dépôt.
     */
    public List<Card> getAllCards() {
        return cards;
    }

    /**
     * Trouve une carte dans le dépôt en utilisant son nom.
     *
     * @param name Le nom de la carte à rechercher.
     * @return La carte correspondant au nom, ou null si aucune carte n'est trouvée.
     */
    public Card findCardByName(String name) {
        return cards.stream().filter(card -> card.getName().equals(name)).findFirst().orElse(null);
    }

    /**
     * Filtre les cartes du dépôt par type.
     *
     * @param type Le type de cartes à rechercher.
     * @return Une liste des cartes correspondant au type spécifié.
     */
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
