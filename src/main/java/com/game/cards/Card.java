package com.game.cards;

public class Card {
    private String name;
    private int power;
    private String type;
    private String rarity;

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

    public int useEffect() {
        return power * (rarity.equals("rare") ? 2 : 1);
    }

    public void increasePower(int increment) {
        this.power += increment;
    }

    public void changeType(String newType) {
        this.type = newType;
    }

    public boolean isStrongerThan(Card otherCard) {
        return this.power > otherCard.getPower();
    }

    public boolean isSameType(Card otherCard) {
        return this.type.equals(otherCard.getType());
    }

    public String getDescription() {
        return String.format("%s [%s]: Power %d, Rarity %s", name, type, power, rarity);
    }
}
