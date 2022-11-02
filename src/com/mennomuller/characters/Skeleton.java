package com.mennomuller.characters;

import com.mennomuller.actions.BoneCrunch;

public class Skeleton extends Fighter {
    public Skeleton() {
        super("SKELETON");
        availableActions.add(new BoneCrunch());
        maxHP = 5;
        currHP = maxHP;
    }
}
