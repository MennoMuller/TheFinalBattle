package com.mennomuller.actions;

import com.mennomuller.characters.Fighter;

public class Attack extends Action {
    private final String message1;
    private final String message2;
    private final int minDmg, maxDmg;
    private final double hitRate;

    public Attack(String NAME, String message1, String message2, int minDmg, int maxDmg, double hitRate) {
        super(NAME, TargetType.ENEMY);
        this.message1 = message1;
        this.message2 = message2;
        this.minDmg = minDmg;
        this.maxDmg = maxDmg;
        this.hitRate = hitRate;
    }

    @Override
    public void perform(Fighter user, Fighter... targets) {
        Fighter target = targets[0];
        printMsg(user.NAME + message1 + target.NAME + message2, user);
        if (random.nextDouble() < hitRate) {
            target.takeDamage(maxDmg == minDmg ? maxDmg : random.nextInt(maxDmg - minDmg) + minDmg);
        } else {
            printMsg(user.NAME + " MISSED!", user);
        }
    }

    public static Attack punch() {
        return new Attack("PUNCH", " PUNCHED ", " with their fists.", 1, 1, 1.0);
    }

    public static Attack slash() {
        return new Attack("SLASH", " SLASHED ", " with their SWORD.", 2, 2, 1.0);
    }

    public static Attack boneCrunch() {
        return new Attack("BONE CRUNCH", " used BONE CRUNCH on ", ".", 1, 1, 0.5);
    }

    public static Attack stab() {
        return new Attack("STAB", " STABBED ", " with their DAGGER.", 1, 1, 1.0);
    }

    public static Attack unravel() {
        return new Attack("UNRAVEL", " tried to UNRAVEL ", "'s code.", 0, 2, 1.0);
    }

    public static Attack quickShot() {
        return new Attack("QUICK SHOT", " SHOT an arrow at ", " with their BOW.", 3, 3, 0.5);
    }
}
