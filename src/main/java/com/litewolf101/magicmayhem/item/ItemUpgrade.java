package com.litewolf101.magicmayhem.item;

import com.litewolf101.magicmayhem.util.EnumUpgradeType;
import de.kitsunealex.silverfish.util.ISubtypeHolder;

import java.util.Arrays;

public class ItemUpgrade extends ItemMM implements ISubtypeHolder {

    public ItemUpgrade() {
        super("upgrade");
    }

    @Override
    public String[] getSubNames() {
        return Arrays.stream(EnumUpgradeType.values()).map(EnumUpgradeType::getName).toArray(String[]::new);
    }

}
