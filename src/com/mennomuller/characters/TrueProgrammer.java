package com.mennomuller.characters;

import com.mennomuller.actions.Attack;
import com.mennomuller.gear.Gear;

import java.util.Scanner;

public class TrueProgrammer extends Fighter {
    public TrueProgrammer(String name) {
        super(name);
        availableActions.add(Attack.punch());
        maxHP = 25;
        currHP = maxHP;
        equip(new Gear("Sword", Attack.slash()));
    }

    public static TrueProgrammer createPlayerCharacter() {
        Scanner input = new Scanner(System.in);
        System.out.print("Insert name: ");
        return new TrueProgrammer(input.nextLine());
    }
}
