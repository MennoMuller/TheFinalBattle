package com.mennomuller.game;

import com.mennomuller.characters.Fighter;

import java.util.ArrayList;
import java.util.List;

public class Party {
    private final ArrayList<Fighter> members;
    public Player player;

    public Party(Player player, BattleArena arena, Fighter... members) {
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
}
