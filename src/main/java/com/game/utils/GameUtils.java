package com.game.utils;

public class GameUtils {

    public static int calculateDamage(int base, int modifier) {
        return base * modifier;
    }

    public static int generateRandomEffect() {
        return (int) (Math.random() * 10 + 1);
    }

    public static int applyCriticalHit(int damage) {
        return damage * 2;
    }

    public static int applyHealing(int baseHealing, int modifier) {
        return baseHealing + modifier;
    }

    public static int generateRandomDamage(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    public static int applyBonus(int baseValue, int bonus) {
        return baseValue + bonus;
    }

    public static boolean isCriticalHit(double chance) {
        return Math.random() < chance;
    }

    public static int calculateArmorReduction(int damage, int armor) {
        return Math.max(damage - armor, 0);
    }

    public static int applyPoisonEffect(int initialDamage, int poisonTurns) {
        return initialDamage + (poisonTurns * 2);
    }

    public static int restoreEnergy(int currentEnergy, int maxEnergy) {
        return Math.min(currentEnergy + 10, maxEnergy);
    }

    public static int calculateSpecialAttackDamage(int base, int multiplier, boolean isSpecial) {
        return isSpecial ? base * multiplier : base;
    }

    public static int calculateShieldBlock(int damage, int shieldStrength) {
        return Math.max(damage - shieldStrength, 0);
    }
}
