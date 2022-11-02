package com.mennomuller.game;

import com.mennomuller.actions.Action;
import com.mennomuller.characters.Fighter;

import java.util.ArrayList;
import java.util.Random;

public class AIPlayer extends Player {
    Random random = new Random();

    public AIPlayer(BattleArena arena) {
        super(arena);
    }

    @Override
    public Action chooseAction(boolean isItem, Fighter f, ArrayList<Action> options) {
        if (options.size() == 1) {
            return options.get(0);
        }
        int choice;
        if (isItem) {
            choice = random.nextInt(options.size());
        } else {
            if (!f.getParty().items.isEmpty() && f.getCurrHP() / (double) f.getMaxHP() < 0.5 && random.nextDouble() < 0.25) {
                choice = 1;
            } else {
                choice = random.nextInt(options.size() - 2) + 2;
            }
        }
        return options.get(choice);
    }

    @Override
    public Fighter chooseTarget(ArrayList<Fighter> options) {
        int choice = random.nextInt(options.size());
        return options.get(choice);
    }
}
