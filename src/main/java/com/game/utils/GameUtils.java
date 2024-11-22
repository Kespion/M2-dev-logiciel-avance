package com.game.utils;

/**
 * Classe utilitaire qui fournit des méthodes pour effectuer divers calculs et effets dans le cadre du jeu.
 * Ces méthodes permettent de gérer les dégâts, les effets aléatoires, les soins, les coups critiques, les bonus,
 * les réductions d'armure, et plus encore.
 */
public class GameUtils {

    /**
     * Calcule les dégâts en fonction d'un montant de base et d'un modificateur.
     *
     * @param base Le montant de base des dégâts.
     * @param modifier Le modificateur des dégâts (par exemple, un multiplicateur d'effet).
     * @return Le montant total des dégâts après application du modificateur.
     */
    public static int calculateDamage(int base, int modifier) {
        return base * modifier;
    }

    /**
     * Génère un effet aléatoire avec une valeur entre 1 et 10.
     *
     * @return Une valeur aléatoire d'effet.
     */
    public static int generateRandomEffect() {
        return (int) (Math.random() * 10 + 1);
    }

    /**
     * Applique un coup critique, doublant les dégâts.
     *
     * @param damage Les dégâts de base avant l'application du coup critique.
     * @return Les dégâts après application du coup critique (doublement des dégâts).
     */
    public static int applyCriticalHit(int damage) {
        return damage * 2;
    }

    /**
     * Applique un effet de soin en fonction d'une valeur de soin de base et d'un modificateur.
     *
     * @param baseHealing La quantité de soin de base.
     * @param modifier Le modificateur qui s'ajoute à la valeur de soin.
     * @return La quantité totale de soin après application du modificateur.
     */
    public static int applyHealing(int baseHealing, int modifier) {
        return baseHealing + modifier;
    }

    /**
     * Génère des dégâts aléatoires dans une plage donnée (min, max).
     *
     * @param min La valeur minimale des dégâts.
     * @param max La valeur maximale des dégâts.
     * @return Une valeur de dégâts aléatoire entre min et max.
     */
    public static int generateRandomDamage(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    /**
     * Applique un bonus à une valeur de base.
     *
     * @param baseValue La valeur de base à laquelle le bonus est appliqué.
     * @param bonus La valeur du bonus à ajouter.
     * @return La valeur de base augmentée du bonus.
     */
    public static int applyBonus(int baseValue, int bonus) {
        return baseValue + bonus;
    }

    /**
     * Détermine si un coup est un coup critique en fonction de la probabilité donnée.
     *
     * @param chance La chance que le coup soit critique (exprimée sous forme de nombre entre 0 et 1).
     * @return true si le coup est critique, sinon false.
     */
    public static boolean isCriticalHit(double chance) {
        return Math.random() < chance;
    }

    /**
     * Calcule la réduction des dégâts en fonction de l'armure du défenseur.
     *
     * @param damage La quantité de dégâts à appliquer.
     * @param armor La valeur de l'armure qui réduit les dégâts.
     * @return La quantité de dégâts après réduction par l'armure (ne peut pas être inférieure à 0).
     */
    public static int calculateArmorReduction(int damage, int armor) {
        return Math.max(damage - armor, 0);
    }

    /**
     * Applique un effet de poison qui augmente les dégâts au fil des tours.
     *
     * @param initialDamage Les dégâts initiaux infligés par le poison.
     * @param poisonTurns Le nombre de tours pendant lesquels le poison agit.
     * @return Les dégâts totaux infligés par le poison, augmentés à chaque tour.
     */
    public static int applyPoisonEffect(int initialDamage, int poisonTurns) {
        return initialDamage + (poisonTurns * 2);
    }

    /**
     * Restaure de l'énergie, sans dépasser l'énergie maximale.
     *
     * @param currentEnergy L'énergie actuelle du joueur.
     * @param maxEnergy L'énergie maximale que le joueur peut avoir.
     * @return La nouvelle quantité d'énergie après restauration, limitée par la capacité maximale.
     */
    public static int restoreEnergy(int currentEnergy, int maxEnergy) {
        return Math.min(currentEnergy + 10, maxEnergy);
    }

    /**
     * Calcule les dégâts d'une attaque spéciale en fonction d'un multiplicateur et d'un indicateur si l'attaque est spéciale.
     *
     * @param base Les dégâts de base de l'attaque.
     * @param multiplier Le multiplicateur appliqué si l'attaque est spéciale.
     * @param isSpecial Un indicateur si l'attaque est spéciale (true) ou non (false).
     * @return Les dégâts calculés en fonction de l'attaque spéciale.
     */
    public static int calculateSpecialAttackDamage(int base, int multiplier, boolean isSpecial) {
        return isSpecial ? base * multiplier : base;
    }

    /**
     * Calcule la réduction des dégâts par un bouclier, en fonction de sa résistance.
     *
     * @param damage Les dégâts d'attaque.
     * @param shieldStrength La résistance du bouclier.
     * @return Les dégâts restants après application du bouclier (ne peuvent pas être inférieurs à 0).
     */
    public static int calculateShieldBlock(int damage, int shieldStrength) {
        return Math.max(damage - shieldStrength, 0);
    }
}
