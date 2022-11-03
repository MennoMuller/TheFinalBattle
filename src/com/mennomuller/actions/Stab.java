package com.mennomuller.actions;

import com.mennomuller.characters.Fighter;

public class Stab extends Action {
    public Stab() {
        super("STAB", TargetType.ENEMY);
    }

    @Override
    public void perform(Fighter user, Fighter... targets) {
        Fighter target = targets[0];
        if (!user.getParty().player.getArena().inAnalysisMode()) {
            System.out.println(user.NAME + " STABBED " + target.NAME + " with their DAGGER.");
        }
        target.takeDamage(1);
    }

}
