package com.mennomuller.game;

import com.mennomuller.actions.Action;
import com.mennomuller.characters.Fighter;
import com.mennomuller.gear.Gear;

import java.util.ArrayList;

public abstract class Player {
    protected final BattleArena arena;

    public Player(BattleArena arena) {
        this.arena = arena;
    }

    public ArrayList<Fighter> getEnemies(Fighter fighter) {
        if (arena.evilParty.equals(fighter.getParty())) {
            return arena.heroParty.getAliveMembers();
        } else {
            return arena.evilParty.getAliveMembers();
        }
    }

    public abstract Action chooseAction(boolean isItem, Fighter f, ArrayList<Action> options);

    public abstract Fighter chooseTarget(ArrayList<Fighter> options);

    public abstract Gear chooseGear(Fighter f);

    public BattleArena getArena() {
        return arena;
    }
}
