package com.mennomuller.game;

import com.mennomuller.actions.Attack;

public class DefenseModifier {
    public final String NAME;
    private final int reduction;
    private final Attack.DamageType type;

    public DefenseModifier(String NAME, int reduction, Attack.DamageType type) {
        this.reduction = reduction;
        this.NAME = NAME;
        this.type = type;
    }

    public int processDamage(int damage, Attack.DamageType type, boolean showMessage) {
        if (this.type == null || this.type == type) {
            if (showMessage) {
                System.out.println(NAME + " reduced the damage by " + reduction);
            }
            return damage - reduction;
        } else {
            return damage;
        }
    }
}
