package com.mennomuller.characters;

import com.mennomuller.actions.Attack;

public class UncodedOne extends Fighter {
    public UncodedOne() {
        super("The UNCODED ONE");
        availableActions.add(Attack.unravel());
        maxHP = 50;
        currHP = maxHP;
    }
}
