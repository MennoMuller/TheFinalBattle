package com.mennomuller.characters;

import com.mennomuller.actions.Attack;
import com.mennomuller.gear.Gear;

public class VinFletcher extends Fighter {
    public VinFletcher() {
        super("Vin Fletcher");
        availableActions.add(Attack.punch());
        maxHP = 15;
        currHP = maxHP;
        equip(new Gear("Vin's Bow", Attack.quickShot()));
    }
}