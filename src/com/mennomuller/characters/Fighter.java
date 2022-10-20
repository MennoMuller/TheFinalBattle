package com.mennomuller.characters;

public abstract class Fighter {
    public final String NAME;


    protected Fighter(String name) {
        NAME = name;
    }

    public void takeTurn(){
        System.out.println("It is "+NAME+"'s turn...");
        doNothing();
    }

    public void doNothing(){
        System.out.println(NAME+" did NOTHING.");
    }
}
