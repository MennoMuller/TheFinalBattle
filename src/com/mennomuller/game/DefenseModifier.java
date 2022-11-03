package com.mennomuller.game;

public class DefenseModifier {
    public final String NAME;
    private final int reduction;

    public DefenseModifier(String NAME, int reduction) {
        this.reduction = reduction;
        this.NAME = NAME;
    }

    public int processDamage(int damage, boolean showMessage) {
        if (showMessage) {
            System.out.println(NAME + " reduced the damage by " + reduction);
        }
        return damage - reduction;
    }
}
