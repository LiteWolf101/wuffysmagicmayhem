package com.litewolf101.magicmayhem.block;

import com.google.common.collect.Lists;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.IShearable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import java.util.List;

public class BlockLeavesBase extends BlockMM implements IShearable {

    public BlockLeavesBase(String blockName) {
        super(blockName, Material.LEAVES);
        setHardness(0.2F);
        setLightOpacity(1);
        setSoundType(SoundType.PLANT);
    }

    public BlockLeavesBase(String blockName, MapColor mapColor) {
        super(blockName, Material.LEAVES, mapColor);
        setHardness(0.2F);
        setLightOpacity(1);
        setSoundType(SoundType.PLANT);
    }

    @Override
    public boolean isShearable(@Nonnull ItemStack item, IBlockAccess world, BlockPos pos) {
        return true;
    }

    @Nonnull
    @Override
    public List<ItemStack> onSheared(@Nonnull ItemStack stack, IBlockAccess world, BlockPos pos, int fortune) {
        return Lists.newArrayList(new ItemStack(this, 1, 0));
    }

    @SuppressWarnings("deprecation")
    @Override
    @SideOnly(Side.CLIENT)
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @SuppressWarnings("deprecation")
    @Override
    @SideOnly(Side.CLIENT)
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean canRenderInLayer(IBlockState state, BlockRenderLayer layer) {
        return layer == BlockRenderLayer.CUTOUT;
    }

}
