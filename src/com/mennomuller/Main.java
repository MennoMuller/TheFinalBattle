package com.mennomuller;

import com.mennomuller.characters.Skeleton;
import com.mennomuller.characters.TrueProgrammer;
import com.mennomuller.game.BattleArena;
import com.mennomuller.game.Party;

public class Main {

    public static void main(String[] args) {
        BattleArena arena = new BattleArena();
        Party heroParty = new Party(false, arena, TrueProgrammer.createPlayerCharacter());
        arena.heroParty = heroParty;
        Party evilParty = new Party(true, arena, new Skeleton());
        arena.evilParties.add(evilParty);
        evilParty = new Party(true, arena, new Skeleton(), new Skeleton());
        arena.evilParties.add(evilParty);
        arena.fight();
    }
}
