package com.mennomuller.game;

import com.mennomuller.actions.Action;
import com.mennomuller.actions.Attack;
import com.mennomuller.characters.*;
import com.mennomuller.gear.Gear;
import com.mennomuller.util.TextHandler;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BattleArena {
    public Party heroParty;
    public Party evilParty;
    private final ArrayList<Party> evilParties = new ArrayList<>();
    private Player heroPlayer;
    private Player evilPlayer;
    private boolean analysisMode = false;
    ArrayList<Fighter> allFighters;
    private final int BAR_LENGTH = 46, ANALYSIS_COUNT = 10000;
    private int gameCount = 0, loseCount = 0, winCount = 0;

    public void fight() {
        gameCount++;
        for (Party evil : evilParties) {
            evilParty = evil;
            allFighters = new ArrayList<>();
            allFighters.addAll(heroParty.getMembers());
            allFighters.addAll(evilParty.getMembers());
            displayGameStatus(allFighters.get(0));
            while (!heroParty.isDefeated() && !evilParty.isDefeated()) {
                for (Fighter character : allFighters) {
                    character.takeTurn();
                    if (!analysisMode) {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            if (heroParty.isDefeated()) {
                if (analysisMode) {
                    loseCount++;
                }
                return;
            } else {
                for (Action item : evilParty.items) {
                    if (!analysisMode) {
                        System.out.println("Got a " + item.NAME + "!");
                    }
                    heroParty.addItems(item);
                }
                for (Gear item : evilParty.unusedGear) {
                    if (!analysisMode) {
                        System.out.println("Got a " + item.name() + "!");
                    }
                    heroParty.addGear(item);
                }
            }
        }
        winCount++;
    }

    public void setHeroParty(Fighter... members) {
        heroParty = new Party(heroPlayer, members);
    }

    public void addEvilParty(Fighter... members) {
        evilParties.add(new Party(evilPlayer, members));
    }

    public void askGameMode() {

        Scanner input = new Scanner(System.in);
        System.out.println("1 - Player vs Computer\n2 - Player vs Player\n3 - Computer vs Computer\n" + TextHandler.color("4 - Game Balance Analysis", TextHandler.Color.GRAY));
        int choice;
        while (true) {
            try {
                System.out.print("Please select a game mode: ");
                choice = input.nextInt();
                if (choice >= 1 && choice <= 4) {
                    heroPlayer = switch (choice) {
                        case 1, 2 -> new HumanPlayer(this);
                        default -> new AIPlayer(this);
                    };
                    evilPlayer = switch (choice) {
                        case 1, 3, 4 -> new AIPlayer(this);
                        default -> new HumanPlayer(this);
                    };
                    analysisMode = choice == 4;
                    break;
                } else {
                    System.out.println("Not a valid option.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Not a number");
                input.next();
            }
        }
    }

    public boolean inAnalysisMode() {
        return analysisMode;
    }

    public void setupGame() {

        if (analysisMode) {
            setHeroParty(new TrueProgrammer("TRUE PROGRAMMER"), new VinFletcher());
        } else {
            setHeroParty(TrueProgrammer.createPlayerCharacter(), new VinFletcher());
        }
        heroParty.addPotions(3);
        evilParties.clear();
        addEvilParty(new Skeleton());
        evilParties.get(0).getMembers().get(0).equip(new Gear("Dagger", Attack.stab()));
        evilParties.get(0).addPotions(1);
        addEvilParty(new Skeleton(), new Skeleton());
        evilParties.get(1).addPotions(1);
        evilParties.get(1).addGear(new Gear("Dagger", Attack.stab()), new Gear("Dagger", Attack.stab()));
        addEvilParty(new UncodedOne());
        evilParties.get(2).addPotions(1);
        fight();

    }

    public void startUp() {
        askGameMode();
        if (analysisMode) {
            for (int i = 0; i < ANALYSIS_COUNT; i++) {
                setupGame();
            }
            System.out.println(gameCount + " games played");
            System.out.println(winCount + " won");
            System.out.println(loseCount + " lost");
            System.out.println((winCount / (double) gameCount) * 100 + "% victory");
        } else {
            setupGame();
        }
    }

    public void displayGameStatus(Fighter turnTaker) {
        if (!analysisMode) {
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
            System.out.println("=".repeat(BAR_LENGTH * 2 + 8) + "\n");
        }
    }
}
