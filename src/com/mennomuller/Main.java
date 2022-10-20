package com.mennomuller;

import com.mennomuller.characters.Skeleton;
import com.mennomuller.characters.TrueProgrammer;
import com.mennomuller.game.BattleArena;
import com.mennomuller.game.Party;

public class Main {

    public static void main(String[] args) {
        BattleArena arena = new BattleArena();
        Party heroParty = new Party(TrueProgrammer.createPlayerCharacter());
        Party evilParty = new Party(new Skeleton());
        arena.heroParty = heroParty;
        arena.evilParty = evilParty;
        arena.fight();
    }
}
