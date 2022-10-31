package com.mennomuller.characters;

public class Skeleton extends Fighter {
    public Skeleton() {
        super("SKELETON");
        availableActions.add(Action.BONE_CRUNCH);
        maxHP = 5;
        currHP = maxHP;
    }
}
