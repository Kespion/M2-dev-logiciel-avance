package com.game.cards;


/**
 * Représente une crate de jeu décrite par un nom, une puissance, un type et une rareté.
 */
public class Card {
    private String name;
    private int power;
    private String type;
    private String rarity;

    /**
     * Constructeur pour créer une carte avec les attributs spécifiés.
     *
     * @param name Le nom de la carte.
     * @param power La puissance de la carte.
     * @param type Le type de la carte (par exemple, "attaque", "défense").
     * @param rarity La rareté de la carte (par exemple, "commune", "rare").
     */
    public Card(String name, int power, String type, String rarity) {
        this.name = name;
        this.power = power;
        this.type = type;
        this.rarity = rarity;
    }

    public String getName() { return name; }
    public int getPower() { return power; }
    public String getType() { return type; }
    public String getRarity() { return rarity; }

    /**
     * Applique l'effet de la carte en fonction de sa puissance et de sa rareté.
     * Si la rareté est "rare", la puissance est doublée.
     *
     * @return La valeur de l'effet de la carte.
     */
    public int useEffect() {
        return power * (rarity.equals("rare") ? 2 : 1);
    }

    /**
     * Augmente la puissance de la carte d'une valeur spécifiée.
     *
     * @param increment La valeur d'augmentation de la puissance.
     */
    public void increasePower(int increment) {
        this.power += increment;
    }

    /**
     * Change le type de la carte.
     *
     * @param newType Le nouveau type de la carte.
     */
    public void changeType(String newType) {
        this.type = newType;
    }

    /**
     * Vérifie si la carte est plus forte qu'une autre carte.
     *
     * @param otherCard La carte à comparer.
     * @return True si cette carte a une puissance supérieure à celle de l'autre carte, false sinon.
     */
    public boolean isStrongerThan(Card otherCard) {
        return this.power > otherCard.getPower();
    }

    /**
     * Vérifie si la carte a le même type qu'une autre carte.
     *
     * @param otherCard La carte à comparer.
     * @return True si les deux cartes ont le même type, false sinon.
     */
    public boolean isSameType(Card otherCard) {
        return this.type.equals(otherCard.getType());
    }

    /**
     * Fournit une description détaillée de la carte, incluant son nom, son type, sa puissance et sa rareté.
     *
     * @return La description de la carte sous forme de chaîne de caractères.
     */
    public String getDescription() {
        return String.format("%s [%s]: Power %d, Rarity %s", name, type, power, rarity);
    }
}
