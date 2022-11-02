package com.mennomuller.actions;

import com.mennomuller.characters.Fighter;

public class DoNothing extends Action {
    public DoNothing() {
        super("DO NOTHING", TargetType.NONE);
    }

    @Override
    public void perform(Fighter user, Fighter... targets) {
        System.out.println(user.NAME + " did NOTHING.");
    }
}
