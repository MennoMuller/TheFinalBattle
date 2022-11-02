package com.mennomuller.actions;

import com.mennomuller.characters.Fighter;

import java.util.Random;

public abstract class Action {
    protected final Random random = new Random();
    public final String NAME;
    public final TargetType TARGET_TYPE;


    protected Action(String NAME, TargetType TARGET_TYPE) {
        this.NAME = NAME;
        this.TARGET_TYPE = TARGET_TYPE;
    }

    public abstract void perform(Fighter user, Fighter... targets);

    public enum TargetType {
        SELF,
        ALLY,
        ENEMY,
        NONE
    }
}



