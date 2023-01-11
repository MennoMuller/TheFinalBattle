package com.mennomuller.characters;

import com.mennomuller.actions.Attack;

public class Skeleton extends Fighter {
    public Skeleton() {
        super("SKELETON");
        availableActions.add(Attack.boneCrunch());
        maxHP = 15;
        currHP = maxHP;
    }
}
