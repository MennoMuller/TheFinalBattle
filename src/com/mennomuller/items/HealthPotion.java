package com.mennomuller.items;

import com.mennomuller.characters.Fighter;

public class HealthPotion extends Consumable {

    public HealthPotion() {
        super("HEALTH POTION", TargetType.SELF);
    }

    @Override
    public void perform(Fighter user, Fighter... targets) {
        if (!user.getParty().player.getArena().inAnalysisMode()) {
            System.out.println(user.NAME + " used a HEALTH POTION.");
        }
        user.heal(10);
        user.getParty().items.remove(this);
    }
}
