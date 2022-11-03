package com.mennomuller.actions;

import com.mennomuller.characters.Fighter;

public class Slash extends Action {
    public Slash() {
        super("SLASH", TargetType.ENEMY);
    }

    @Override
    public void perform(Fighter user, Fighter... targets) {
        Fighter target = targets[0];
        if (!user.getParty().player.getArena().inAnalysisMode()) {
            System.out.println(user.NAME + " SLASHED " + target.NAME + " with their SWORD.");
        }
        target.takeDamage(2);
    }
}
