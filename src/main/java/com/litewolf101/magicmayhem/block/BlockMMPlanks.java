package com.litewolf101.magicmayhem.block;

import com.litewolf101.magicmayhem.util.EnumTreeType;
import de.kitsunealex.silverfish.util.ISubtypeHolder;
import net.minecraft.block.material.Material;

import java.util.Arrays;

public class BlockMMPlanks extends BlockMM implements ISubtypeHolder {

    public BlockMMPlanks() {
        super("planks", Material.WOOD);
        setHardness(1.2F);
        setResistance(1F);
    }

    @Override
    public String[] getSubNames() {
        return Arrays.stream(EnumTreeType.values()).map(EnumTreeType::getName).toArray(String[]::new);
    }

}
