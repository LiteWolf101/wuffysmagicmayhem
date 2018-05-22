package com.litewolf101.magicmayhem.block;

import com.litewolf101.magicmayhem.MagicMayhem;
import de.kitsunealex.silverfish.block.BlockPillarBase;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockLogBase extends BlockPillarBase {

    public BlockLogBase(String blockName, Material material) {
        super(blockName, material);
        setCreativeTab(MagicMayhem.CREATIVE_TAB);
    }

    public BlockLogBase(String blockName, Material material, MapColor mapColor) {
        super(blockName, material, mapColor);
        setCreativeTab(MagicMayhem.CREATIVE_TAB);
    }

    @Override
    public boolean isWood(IBlockAccess world, BlockPos pos) {
        return true;
    }

    @Override
    public boolean canSustainLeaves(IBlockState state, IBlockAccess world, BlockPos pos) {
        return true;
    }

}
