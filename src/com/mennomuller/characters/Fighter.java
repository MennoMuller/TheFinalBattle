package com.mennomuller.characters;

import com.mennomuller.actions.Action;
import com.mennomuller.actions.DoNothing;
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
        if (isAlive()) {
            System.out.println("It is " + NAME + "'s turn...");
            doAction(party.player.chooseAction(this));
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

    public void die() {
        System.out.println(NAME + " died!");
    }

    public boolean isAlive() {
        return currHP > 0;
    }


}
