package com.mennomuller.game;

import com.mennomuller.characters.Fighter;

public abstract class Player {
    private final BattleArena arena;
    public Player(BattleArena arena){
        this.arena = arena;
    }

    public Party getEnemies(Fighter fighter){
        if(arena.evilParty.equals(fighter.getParty())){
            return arena.heroParty;
        } else {
            return arena.evilParty;
        }
    }

    public abstract Fighter.Action chooseAction(Fighter f);

    public abstract Fighter chooseTarget(Party p);
}
