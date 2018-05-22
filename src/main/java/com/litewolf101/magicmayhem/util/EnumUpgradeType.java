package com.litewolf101.magicmayhem.util;

public enum EnumUpgradeType {

    POWER   ("power"),
    RANGE   ("range"),
    SPEED   ("speed");

    private String name;

    EnumUpgradeType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
