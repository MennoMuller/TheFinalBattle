package com.mennomuller.game;

import com.mennomuller.characters.Fighter;
import com.mennomuller.characters.Skeleton;
import com.mennomuller.characters.TrueProgrammer;
import com.mennomuller.characters.UncodedOne;
import com.mennomuller.util.TextHandler;

import java.util.ArrayList;
import java.util.Scanner;

public class BattleArena {
    public Party heroParty;
    public Party evilParty;
    private final ArrayList<Party> evilParties = new ArrayList<>();
    private Player heroPlayer;
    private Player evilPlayer;
    ArrayList<Fighter> allFighters;
    private final int BAR_LENGTH = 46;

    public void fight() {
        for (Party evil : evilParties) {
            evilParty = evil;
            allFighters = new ArrayList<>();
            allFighters.addAll(heroParty.getMembers());
            allFighters.addAll(evilParty.getMembers());
            displayGameStatus(allFighters.get(0));
            System.out.println();
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
        heroParty = new Party(heroPlayer, members);
    }

    public void addEvilParty(Fighter... members) {
        evilParties.add(new Party(evilPlayer, members));
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
        heroParty.addPotions(3);
        addEvilParty(new Skeleton());
        evilParties.get(0).addPotions(1);
        addEvilParty(new Skeleton(), new Skeleton());
        evilParties.get(1).addPotions(1);
        addEvilParty(new UncodedOne());
        evilParties.get(2).addPotions(1);
        fight();
    }

    public void displayGameStatus(Fighter turnTaker) {
        System.out.println("=".repeat(BAR_LENGTH) + " BATTLE " + "=".repeat(BAR_LENGTH));
        for (Fighter f : heroParty.getMembers()) {
            if (f.equals(turnTaker)) {
                TextHandler.printlnColor(f.toString(), TextHandler.Color.YELLOW);
            } else {
                System.out.println(f);
            }
        }
        System.out.println("-".repeat(BAR_LENGTH + 2) + " VS " + "-".repeat(BAR_LENGTH + 2));
        for (Fighter f : evilParty.getMembers()) {
            if (f.equals(turnTaker)) {
                TextHandler.printlnColor(f.toString(), TextHandler.Color.YELLOW);
            } else {
                System.out.println(f);
            }
        }
        System.out.println("=".repeat(BAR_LENGTH * 2 + 8));
    }
}
