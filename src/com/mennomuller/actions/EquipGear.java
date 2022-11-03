package com.mennomuller.actions;

import com.mennomuller.characters.Fighter;
import com.mennomuller.gear.Gear;

public class EquipGear extends Action {
    public EquipGear() {
        super("EQUIP GEAR", TargetType.SELF);
    }

    @Override
    public void perform(Fighter user, Fighter... targets) {
        Gear selection = user.getParty().player.chooseGear(user);
        user.equip(selection);
        if (!user.getParty().player.getArena().inAnalysisMode()) {
            System.out.println(user.NAME + " equipped " + selection.name().toUpperCase() + ".");
        }
    }

    @Override
    public boolean isEnabledFor(Fighter f) {
        return !f.getParty().unusedGear.isEmpty();
    }
}
