package com.mennomuller.characters;

import com.mennomuller.actions.Attack;
import com.mennomuller.actions.CannonShot;
import com.mennomuller.gear.Gear;

public class Skorin extends Fighter {
    public Skorin() {
        super("Skorin");
        availableActions.add(Attack.punch());
        maxHP = 15;
        currHP = maxHP;
        equip(new Gear("Cannon of Consolas", new CannonShot()));
    }
}
