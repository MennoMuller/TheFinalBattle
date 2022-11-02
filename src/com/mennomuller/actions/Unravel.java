package com.mennomuller.actions;

import com.mennomuller.characters.Fighter;

public class Unravel extends Action {
    public Unravel() {
        super("UNRAVEL", TargetType.ENEMY);
    }

    @Override
    public void perform(Fighter user, Fighter... targets) {
        Fighter target = targets[0];
        System.out.println(user.NAME + " tried to UNRAVEL " + target.NAME + "'s code.");
        target.takeDamage(random.nextInt(3));
    }

}
