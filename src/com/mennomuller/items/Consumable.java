package com.mennomuller.items;

import com.mennomuller.actions.Action;

public abstract class Consumable extends Action {
    protected Consumable(String NAME, TargetType TARGET_TYPE) {
        super(NAME, TARGET_TYPE);
    }
}
