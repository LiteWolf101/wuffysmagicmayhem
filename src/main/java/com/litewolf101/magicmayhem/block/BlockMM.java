package com.litewolf101.magicmayhem.block;

import com.litewolf101.magicmayhem.MagicMayhem;
import de.kitsunealex.silverfish.block.BlockBase;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;

public class BlockMM<T extends TileEntity> extends BlockBase<T> {

    public BlockMM(String blockName, Material material) {
        super(blockName, material);
        setCreativeTab(MagicMayhem.CREATIVE_TAB);
    }

    public BlockMM(String blockName, Material material, MapColor mapColor) {
        super(blockName, material, mapColor);
        setCreativeTab(MagicMayhem.CREATIVE_TAB);
    }

}
