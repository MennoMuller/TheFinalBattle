package com.mennomuller.game;

import com.mennomuller.characters.Fighter;

import java.util.ArrayList;
import java.util.Random;

public class AIPlayer extends Player {
    Random random = new Random();

    public AIPlayer(BattleArena arena) {
        super(arena);
    }

    @Override
    public Fighter.Action chooseAction(Fighter f) {
        ArrayList<Fighter.Action> options = f.getAvailableActions();
        if(options.size()==1){
            return Fighter.Action.DO_NOTHING;
        }
        int choice = random.nextInt(options.size()-1)+1;
        return options.get(choice);
    }

    @Override
    public Fighter chooseTarget(Party p) {
        int choice = random.nextInt(p.getMembers().size());
        return p.getMembers().get(choice);
    }
}
