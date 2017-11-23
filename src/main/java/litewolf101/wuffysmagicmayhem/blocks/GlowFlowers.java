package litewolf101.wuffysmagicmayhem.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

/**
 * Created by Ethan Migit on 11/17/2017.
 */
public class GlowFlowers extends Block {

    protected static final AxisAlignedBB FLAT_AABB = new AxisAlignedBB(0.125D, 0.0D, 0.125D, 0.875D, 0.125D, 0.875D);

    @Nullable
    @SuppressWarnings("deprecation")
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
        return NULL_AABB;
    }

    @SuppressWarnings("deprecation")
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return FLAT_AABB;
    }

    @SideOnly(Side.CLIENT)
    @SuppressWarnings("deprecation")
    public AxisAlignedBB getSelectedBoundingBox(IBlockState state, World worldIn, BlockPos pos)
    {
        return FLAT_AABB;
    }

    @SuppressWarnings("deprecation")
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    public GlowFlowers(String name, Material material) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        this.setSoundType(SoundType.PLANT);
    }
    @Override
    @SuppressWarnings("deprecation")
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    @Override
    public boolean isPassable(IBlockAccess worldIn, BlockPos pos) {
        return true;
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean isFullBlock(IBlockState state)
    {
        return false;
    }

    @Override
    public boolean getUseNeighborBrightness(IBlockState state) {
        return super.getUseNeighborBrightness(state);
    }
}
