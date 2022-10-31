package com.mennomuller.game;

import com.mennomuller.characters.Fighter;

import java.util.ArrayList;
import java.util.Scanner;

public class HumanPlayer extends Player {
    Scanner input = new Scanner(System.in);

    public HumanPlayer(BattleArena arena) {
        super(arena);
    }

    @Override
    public Fighter.Action chooseAction(Fighter f) {
        ArrayList<Fighter.Action> options = f.getAvailableActions();
        if (options.size() == 1) {
            return options.get(0);
        } else {
            System.out.println("\nSelect action for "+f.NAME+":");
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ": " + options.get(i).name().replace('_', ' '));
            }
            int choice;
            while (true) {
                try {
                    choice = input.nextInt() - 1;
                    return options.get(choice);
                } catch (IllegalArgumentException e) {
                    System.out.println("Not a number");
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Not a valid option");
                }
            }
        }
    }

    @Override
    public Fighter chooseTarget(Party p) {
        ArrayList<Fighter> options = p.getMembers();
        if (options.size() == 1) {
            return options.get(0);
        } else {
            System.out.println("\nSelect Target:");
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ": " + options.get(i).NAME);
            }
            int choice;
            while (true) {
                try {
                    choice = input.nextInt() - 1;
                    return options.get(choice);
                } catch (IllegalArgumentException e) {
                    System.out.println("Not a number");
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Not a valid option");
                }
            }
        }
    }
}
