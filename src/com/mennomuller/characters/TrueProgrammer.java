package com.mennomuller.characters;

import java.util.Scanner;

public class TrueProgrammer extends Fighter{
    protected TrueProgrammer(String name) {
        super(name);
    }
    public static TrueProgrammer createPlayerCharacter(){
        Scanner input = new Scanner(System.in);
        System.out.print("Insert name: ");
        return new TrueProgrammer(input.nextLine());
    }
}
