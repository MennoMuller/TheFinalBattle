package com.mennomuller.game;

import com.mennomuller.characters.Fighter;
import com.mennomuller.characters.Skeleton;
import com.mennomuller.characters.TrueProgrammer;
import com.mennomuller.characters.UncodedOne;

import java.util.ArrayList;
import java.util.Scanner;

public class BattleArena {
    public Party heroParty;
    public Party evilParty;
    private final ArrayList<Party> evilParties = new ArrayList<>();
    private Player heroPlayer;
    private Player evilPlayer;
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

    public void setHeroParty(Fighter... members) {
        heroParty = new Party(heroPlayer, this, members);
    }

    public void addEvilParty(Fighter... members) {
        evilParties.add(new Party(evilPlayer, this, members));
    }

    public void askGameMode() {
        Scanner input = new Scanner(System.in);
        System.out.println("1 - Player vs Computer\n2 - Player vs Player\n3 - Computer vs Computer");
        int choice;
        while (true) {
            try {
                System.out.print("Please select a game mode: ");
                choice = input.nextInt();
                if (choice >= 1 && choice <= 3) {
                    heroPlayer = switch (choice) {
                        case 1, 2 -> new HumanPlayer(this);
                        default -> new AIPlayer(this);
                    };
                    evilPlayer = switch (choice) {
                        case 1, 3 -> new AIPlayer(this);
                        default -> new HumanPlayer(this);
                    };
                    break;
                } else {
                    System.out.println("Not a valid option.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Not a number");
            }
        }
    }

    public void setupGame() {
        askGameMode();
        setHeroParty(TrueProgrammer.createPlayerCharacter());
        addEvilParty(new Skeleton());
        addEvilParty(new Skeleton(), new Skeleton());
        addEvilParty(new UncodedOne());
        fight();
    }
}
