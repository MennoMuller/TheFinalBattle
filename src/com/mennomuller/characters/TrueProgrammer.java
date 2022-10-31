package com.mennomuller.characters;

import java.util.Scanner;

public class TrueProgrammer extends Fighter{
    protected TrueProgrammer(String name) {
        super(name);
        availableActions.add(Action.PUNCH);
        maxHP = 25;
        currHP = maxHP;
    }
    public static TrueProgrammer createPlayerCharacter(){
        Scanner input = new Scanner(System.in);
        System.out.print("Insert name: ");
        return new TrueProgrammer(input.nextLine());
    }
}
