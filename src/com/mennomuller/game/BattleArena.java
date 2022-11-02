package com.mennomuller.game;

import com.mennomuller.characters.Fighter;

import java.util.ArrayList;

public class BattleArena {
    public Party heroParty;
    public Party evilParty;
    public ArrayList<Party> evilParties = new ArrayList<>();
    ArrayList<Fighter> allFighters;

    public void fight() {
        for (Party evil : evilParties) {
            evilParty = evil;
            allFighters = new ArrayList<>();
            allFighters.addAll(heroParty.getMembers());
            allFighters.addAll(evilParty.getMembers());
            while (!heroParty.isDefeated() && !evilParty.isDefeated()) {
                for (Fighter character : allFighters) {
                    character.takeTurn();
                    System.out.println();
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (heroParty.isDefeated()) {
                return;
            }
        }
    }
}
