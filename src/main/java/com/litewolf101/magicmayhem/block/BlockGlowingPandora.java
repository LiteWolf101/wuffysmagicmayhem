package com.litewolf101.magicmayhem.block;

import codechicken.lib.vec.Cuboid6;
import com.google.common.collect.Lists;
import com.litewolf101.magicmayhem.client.render.RenderBlockSpecial;
import de.kitsunealex.silverfish.block.IRenderBoundsProvider;
import de.kitsunealex.silverfish.util.MathUtils;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Random;

public class BlockGlowingPandora extends BlockMM implements IPlantable, IRenderBoundsProvider, IBioluminescence {

    private static final AxisAlignedBB BOUNDING_BOX = MathUtils.divide(new Cuboid6(0D, 0D, 0D, 16D, 0.1D, 16D), 16D).aabb();

    public BlockGlowingPandora() {
        super("glowing_pandora", Material.PLANTS);
        setTickRandomly(true);
    }

    @Override
    public void updateTick(World world, BlockPos pos, IBlockState state, Random rand) {
        checkAndDrop(world, pos);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void neighborChanged(IBlockState state, World world, BlockPos pos, Block block, BlockPos sourcePos) {
        checkAndDrop(world, pos);
    }

    @Override
    public boolean canPlaceBlockAt(World world, @Nonnull BlockPos pos) {
        IBlockState soil = world.getBlockState(pos.down());
        return soil.getBlock().canSustainPlant(getDefaultState(), world, pos, EnumFacing.UP, this);
    }

    @Override
    public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
        return EnumPlantType.Plains;
    }

    @Override
    public IBlockState getPlant(IBlockAccess world, BlockPos pos) {
        return getDefaultState();
    }

    @SuppressWarnings("deprecation")
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess world, BlockPos pos) {
        return BOUNDING_BOX;
    }

    private void checkAndDrop(World world, BlockPos pos) {
        if(!canBlockStay(world, pos)) {
            IBlockState state = world.getBlockState(pos);
            dropBlockAsItem(world, pos, state, 0);
            world.setBlockToAir(pos);
        }
    }

    private boolean canBlockStay(IBlockAccess world, BlockPos pos) {
        IBlockState state = world.getBlockState(pos);

        if (state.getBlock() == this) {
            IBlockState soil = world.getBlockState(pos.down());
            return soil.getBlock().canSustainPlant(soil, world, pos.down(), net.minecraft.util.EnumFacing.UP, this);
        }

        return canSustainBush(world.getBlockState(pos.down()));
    }

    private boolean canSustainBush(IBlockState state) {
        return state.getBlock() == Blocks.GRASS || state.getBlock() == Blocks.DIRT || state.getBlock() == Blocks.FARMLAND;
    }

    @SuppressWarnings("deprecation")
    @Override
    public BlockFaceShape getBlockFaceShape(IBlockAccess world, IBlockState state, BlockPos pos, EnumFacing face) {
        return BlockFaceShape.UNDEFINED;
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
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return RenderBlockSpecial.RENDER_TYPE;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean canRenderInLayer(IBlockState state, BlockRenderLayer layer) {
        return layer == BlockRenderLayer.CUTOUT;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public List<Cuboid6> getRenderBounds(int meta) {
        return Lists.newArrayList(new Cuboid6(0D, 0D, 0D, 16D, 0.1D, 16D));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldGlow(int meta, int side) {
        return true;
    }

}
