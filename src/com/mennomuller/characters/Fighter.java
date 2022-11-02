package com.mennomuller.characters;

import com.mennomuller.actions.Action;
import com.mennomuller.actions.DoNothing;
import com.mennomuller.actions.UseItem;
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
        availableActions.add(new DoNothing());
        availableActions.add(new UseItem());
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getCurrHP() {
        return currHP;
    }

    public ArrayList<Action> getAvailableActions() {
        ArrayList<Action> currentActions = new ArrayList<>();
        for (Action action : availableActions) {
            if (action.isEnabledFor(this)) {
                currentActions.add(action);
            }
        }
        return currentActions;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    public Party getParty() {
        return party;
    }

    public void takeTurn() {
        if (isAlive()) {
            System.out.println("It is " + NAME + "'s turn...");
            doAction(party.player.chooseAction(false, this, this.getAvailableActions()));
        }
    }

    public void doAction(Action action) {
        Fighter targetFighter = switch (action.TARGET_TYPE) {
            case ALLY -> party.player.chooseTarget(party.getAliveMembers());
            case ENEMY -> party.player.chooseTarget(party.player.getEnemies(this));
            case NONE -> null;
            case SELF -> this;
        };
        action.perform(this, targetFighter);

    }

    public void takeDamage(int damage) {
        if (currHP - damage < 0) {
            damage = currHP;
        }
        currHP -= damage;
        System.out.println(NAME + " took " + damage + " damage! (" + currHP + "/" + maxHP + " HP)");
        if (currHP == 0) {
            die();
        }
    }

    public void heal(int healing) {
        if (currHP + healing > maxHP) {
            healing = maxHP - currHP;
        }
        currHP += healing;
        System.out.println(NAME + " recovered " + healing + " HP! (" + currHP + "/" + maxHP + " HP)");
    }

    public void die() {
        System.out.println(NAME + " died!");
    }

    public boolean isAlive() {
        return currHP > 0;
    }

    @Override
    public String toString() {
        return NAME + " (" + currHP + "/" + maxHP + ")";
    }
}
