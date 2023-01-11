package com.mennomuller.actions;

import com.mennomuller.characters.Fighter;

public class CannonShot extends Attack {
    private int shotCount = 0;

    public CannonShot() {
        super("CANNON SHOT", " SHOT at ", " with the CANNON OF CONSOLAS.", 1, 1, 1.0, DamageType.PHYSICAL);
    }

    @Override
    public void perform(Fighter user, Fighter... targets) {
        shotCount++;
        boolean fire = shotCount % 3 == 0;
        boolean elec = shotCount % 5 == 0;
        if (fire && elec) {
            super.perform(" SHOT an ELECTRIC FIRE BLAST at ", 5, 5, DamageType.ELECTRIC_FIRE, user, targets);
        } else if (fire) {
            super.perform(" SHOT a FIRE BLAST at ", 2, 2, DamageType.FIRE, user, targets);
        } else if (elec) {
            super.perform(" SHOT an ELECTRIC BLAST at ", 2, 2, DamageType.ELECTRIC, user, targets);
        } else {
            super.perform(user, targets);
        }
    }
}
