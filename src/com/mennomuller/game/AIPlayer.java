package com.mennomuller.game;

import com.mennomuller.actions.Action;
import com.mennomuller.actions.EquipGear;
import com.mennomuller.actions.UseItem;
import com.mennomuller.characters.Fighter;
import com.mennomuller.gear.Gear;

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
                return new UseItem();
            } else if (f.getEquipment() == null && !f.getParty().unusedGear.isEmpty() && random.nextDouble() < 0.5) {
                return new EquipGear();
            } else {
                choice = options.size() - 1;
            }
        }
        return options.get(choice);
    }

    @Override
    public Fighter chooseTarget(ArrayList<Fighter> options) {
        int choice = random.nextInt(options.size());
        return options.get(choice);
    }

    @Override
    public Gear chooseGear(Fighter f) {
        ArrayList<Gear> options = f.getParty().unusedGear;
        int choice = random.nextInt(options.size());
        return options.get(choice);
    }
}
