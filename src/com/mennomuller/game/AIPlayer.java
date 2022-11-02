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
    public Action chooseAction(Fighter f) {
        ArrayList<Action> options = f.getAvailableActions();
        if (options.size() == 1) {
            return options.get(0);
        }
        int choice = random.nextInt(options.size() - 1) + 1;
        return options.get(choice);
    }

    @Override
    public Fighter chooseTarget(ArrayList<Fighter> options) {
        int choice = random.nextInt(options.size());
        return options.get(choice);
    }
}
