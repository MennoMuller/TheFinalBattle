package com.mennomuller.actions;

import com.mennomuller.characters.Fighter;

public class UseItem extends Action {
    public UseItem() {
        super("USE ITEM", TargetType.NONE);
    }

    @Override
    public void perform(Fighter user, Fighter... targets) {
        if (user.getParty().items.isEmpty()) {
            System.out.println("You have no items.");
            user.doAction(user.getParty().player.chooseAction(false, user, user.getAvailableActions()));
        } else {
            user.doAction(user.getParty().player.chooseAction(true, user, user.getParty().items));
        }
    }
}
