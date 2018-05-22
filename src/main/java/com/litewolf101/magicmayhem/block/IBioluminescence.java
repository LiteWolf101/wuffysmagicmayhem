package com.litewolf101.magicmayhem.block;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public interface IBioluminescence {

    @SideOnly(Side.CLIENT)
    boolean shouldGlow(int meta, int side);

    @SideOnly(Side.CLIENT)
    default boolean shouldGlow(IBlockAccess world, BlockPos pos, IBlockState state, int side) {
        return shouldGlow(state.getBlock().getMetaFromState(state), side);
    }

    @SideOnly(Side.CLIENT)
    default boolean shouldGlow(ItemStack stack, int side) {
        return shouldGlow(stack.getMetadata(), side);
    }

}
