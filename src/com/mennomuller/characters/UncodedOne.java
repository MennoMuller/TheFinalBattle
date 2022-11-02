package com.mennomuller.characters;

import com.mennomuller.actions.Unravel;

public class UncodedOne extends Fighter {
    public UncodedOne() {
        super("The UNCODED ONE");
        availableActions.add(new Unravel());
        maxHP = 15;
        currHP = maxHP;
    }
}
