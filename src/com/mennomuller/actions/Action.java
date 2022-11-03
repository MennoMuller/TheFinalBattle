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

    public boolean isEnabledFor(Fighter f) {
        return true;
    }

    public abstract void perform(Fighter user, Fighter... targets);

    public void printMsg(String msg, Fighter user) {
        if (!user.getParty().player.getArena().inAnalysisMode()) {
            System.out.println(msg);
        }
    }

    public enum TargetType {
        SELF,
        ALLY,
        ENEMY,
        NONE
    }
}



