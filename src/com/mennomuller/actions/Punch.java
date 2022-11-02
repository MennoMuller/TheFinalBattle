package com.mennomuller.actions;

import com.mennomuller.characters.Fighter;

public class Punch extends Action {
    public Punch() {
        super("PUNCH", TargetType.ENEMY);
    }

    @Override
    public void perform(Fighter user, Fighter... targets) {
        Fighter target = targets[0];
        System.out.println(user.NAME + " PUNCHED " + target.NAME + " with their fists.");
        target.takeDamage(1);
    }

}
