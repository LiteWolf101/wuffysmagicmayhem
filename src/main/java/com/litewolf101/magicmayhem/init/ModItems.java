package com.litewolf101.magicmayhem.init;

import com.litewolf101.magicmayhem.item.ItemUpgrade;
import de.kitsunealex.silverfish.util.RegistryUtils;
import net.minecraft.item.Item;

public class ModItems {

    public static Item UPGRADE;

    public static void registerItems() {
        UPGRADE = RegistryUtils.registerItem(ItemUpgrade.class);
    }

}
