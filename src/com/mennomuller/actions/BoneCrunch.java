package com.mennomuller.actions;

import com.mennomuller.characters.Fighter;

public class BoneCrunch extends Action {
    public BoneCrunch() {
        super("BONE CRUNCH", TargetType.ENEMY);
    }

    @Override
    public void perform(Fighter user, Fighter... targets) {
        Fighter target = targets[0];
        if (!user.getParty().player.getArena().inAnalysisMode()) {
            System.out.println(user.NAME + " used BONE CRUNCH on " + target.NAME + ".");
        }
        target.takeDamage(random.nextInt(2));
    }

}
