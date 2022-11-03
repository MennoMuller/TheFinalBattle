package com.mennomuller.characters;

import com.mennomuller.actions.Punch;

import java.util.Scanner;

public class TrueProgrammer extends Fighter {
    public TrueProgrammer(String name) {
        super(name);
        availableActions.add(new Punch());
        maxHP = 25;
        currHP = maxHP;
    }

    public static TrueProgrammer createPlayerCharacter() {
        Scanner input = new Scanner(System.in);
        System.out.print("Insert name: ");
        return new TrueProgrammer(input.nextLine());
    }
}
