package com.mennomuller.characters;

import com.mennomuller.game.Party;

import java.util.ArrayList;
import java.util.Random;

public abstract class Fighter {
    protected final Random random = new Random();
    public final String NAME;
    private Party party;
    protected ArrayList<Action> availableActions;
    protected int maxHP, currHP;

    protected Fighter(String name) {
        NAME = name;
        availableActions = new ArrayList<>();
        availableActions.add(Action.DO_NOTHING);
    }

    public ArrayList<Action> getAvailableActions() {
        return availableActions;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    public Party getParty() {
        return party;
    }

    public void takeTurn() {
        System.out.println("It is " + NAME + "'s turn...");
        doAction(party.player.chooseAction(this));
    }

    public void doAction(Action action) {
        Fighter targetFighter = switch (action.target) {
            case ALLY -> party.player.chooseTarget(party);
            case ENEMY -> party.player.chooseTarget(party.player.getEnemies(this));
            case NONE -> null;
            case SELF -> this;
        };
        System.out.print(NAME + action.message1);
        if (targetFighter != null) {
            if (targetFighter.equals(this)) {
                System.out.println("themselves" + action.message2);
            } else {
                System.out.println(targetFighter.NAME + action.message2);
            }
            int damage;
            if (action.maxDmg == action.minDmg) {
                damage = action.maxDmg;
            } else {
                damage = action.minDmg + random.nextInt(action.maxDmg - action.minDmg + 1);
            }
            targetFighter.takeDamage(damage);
        } else {
            System.out.println();
        }
    }

    public void takeDamage(int damage) {
        if (currHP - damage < 0) {
            damage = currHP;
        }
        currHP -= damage;
        System.out.println(NAME + " took " + damage + " damage! (" + currHP + "/" + maxHP + " HP)");

    }

    public enum Action {
        DO_NOTHING(" did NOTHING.", Target.NONE, "", 0, 0),
        PUNCH(" PUNCHED ", Target.ENEMY, " as hard as they could.", 1, 1),
        BONE_CRUNCH(" used BONE CRUNCH on ", Target.ENEMY, ".", 0, 1);
        public final String message1, message2;
        public final Target target;
        public final int minDmg, maxDmg;

        Action(String message1, Target target, String message2, int minDmg, int maxDmg) {
            this.message1 = message1;
            this.message2 = message2;
            this.target = target;
            this.minDmg = minDmg;
            this.maxDmg = maxDmg;
        }
    }

    public enum Target {
        SELF,
        ALLY,
        ENEMY,
        NONE
    }
}
