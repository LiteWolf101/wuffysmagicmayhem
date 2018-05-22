package com.litewolf101.magicmayhem.block;

import com.litewolf101.magicmayhem.util.EnumTreeType;
import de.kitsunealex.silverfish.util.ISubtypeHolder;
import net.minecraft.block.material.Material;

import java.util.Arrays;

public class BlockMMLog extends BlockLogBase implements ISubtypeHolder {

    public BlockMMLog() {
        super("log", Material.WOOD);
        setHardness(1.5F);
        setResistance(1.2F);
    }

    @Override
    public String[] getSubNames() {
        return Arrays.stream(EnumTreeType.values()).map(EnumTreeType::getName).toArray(String[]::new);
    }

}
