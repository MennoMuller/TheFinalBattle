package com.mennomuller.game;

import com.mennomuller.actions.Action;
import com.mennomuller.characters.Fighter;

import java.util.ArrayList;

public abstract class Player {
    private final BattleArena arena;

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

    public abstract Action chooseAction(Fighter f);

    public abstract Fighter chooseTarget(ArrayList<Fighter> options);
}
