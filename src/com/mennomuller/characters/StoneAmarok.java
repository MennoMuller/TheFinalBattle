package com.mennomuller.characters;

import com.mennomuller.actions.Attack;
import com.mennomuller.game.DefenseModifier;

public class StoneAmarok extends Fighter {
    public StoneAmarok() {
        super("STONE AMAROK");
        availableActions.add(Attack.bite());
        defenseModifier = new DefenseModifier("STONE ARMOR", 1);
        maxHP = 4;
        currHP = maxHP;
    }
}
