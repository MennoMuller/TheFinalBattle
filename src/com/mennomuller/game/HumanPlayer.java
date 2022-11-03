package com.mennomuller.game;

import com.mennomuller.actions.Action;
import com.mennomuller.characters.Fighter;
import com.mennomuller.gear.Gear;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HumanPlayer extends Player {
    Scanner input = new Scanner(System.in);

    public HumanPlayer(BattleArena arena) {
        super(arena);
    }

    @Override
    public Action chooseAction(boolean isItem, Fighter f, ArrayList<Action> options) {
        if (!isItem && options.size() == 1) {
            return options.get(0);
        } else {
            arena.displayGameStatus(f);
            if (isItem) {
                System.out.println("\nSelect an item:");
            } else {
                System.out.println("\nSelect action for " + f.NAME + ":");
            }
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ": " + options.get(i).NAME);
            }
            int choice;
            while (true) {
                try {
                    choice = input.nextInt() - 1;
                    return options.get(choice);
                } catch (InputMismatchException e) {
                    System.out.println("Not a number");
                    input.next();
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Not a valid option");
                }
            }
        }
    }

    @Override
    public Fighter chooseTarget(ArrayList<Fighter> options) {
        if (options.size() == 1) {
            return options.get(0);
        } else {
            System.out.println("\nSelect Target:");
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ": " + options.get(i));
            }
            int choice;
            while (true) {
                try {
                    choice = input.nextInt() - 1;
                    return options.get(choice);
                } catch (InputMismatchException e) {
                    System.out.println("Not a number");
                    input.next();
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Not a valid option");
                }
            }
        }
    }

    @Override
    public Gear chooseGear(Fighter f) {
        return f.getParty().unusedGear.get(0);
    }
}
