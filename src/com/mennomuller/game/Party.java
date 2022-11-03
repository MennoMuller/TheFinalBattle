package com.mennomuller.game;

import com.mennomuller.actions.Action;
import com.mennomuller.characters.Fighter;
import com.mennomuller.gear.Gear;
import com.mennomuller.items.HealthPotion;

import java.util.ArrayList;
import java.util.List;

public class Party {
    private final ArrayList<Fighter> members;
    public final ArrayList<Action> items = new ArrayList<>();
    public final ArrayList<Gear> unusedGear = new ArrayList<>();
    public Player player;

    public Party(Player player, Fighter... members) {
        this.members = new ArrayList<>(List.of(members));
        this.player = player;
        for (Fighter member : members) {
            member.setParty(this);
        }
    }

    public ArrayList<Fighter> getMembers() {
        return members;
    }

    public boolean isDefeated() {
        for (Fighter member : members) {
            if (member.isAlive()) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<Fighter> getAliveMembers() {
        ArrayList<Fighter> aliveMembers = new ArrayList<>();
        for (Fighter member : members) {
            if (member.isAlive()) {
                aliveMembers.add(member);
            }
        }
        return aliveMembers;
    }

    public void addPotions(int number) {
        for (int i = 0; i < number; i++) {
            items.add(new HealthPotion());
        }
    }

    public void addGear(Gear... gear) {
        unusedGear.addAll(List.of(gear));
    }
}
