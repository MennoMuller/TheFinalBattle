package com.mennomuller.game;

import com.mennomuller.characters.Fighter;

import java.util.ArrayList;
import java.util.List;

public class Party {
    ArrayList<Fighter> members;

    public Party(Fighter... members){
        this.members = new ArrayList<>(List.of(members));
    }

    public boolean isDefeated(){
        return false;
    }
}
