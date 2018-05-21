package litewolf101.wuffysmagicmayhem.blocks;

import litewolf101.wuffysmagicmayhem.blocks.itemblock.ISubtypeHolder;
import litewolf101.wuffysmagicmayhem.handlers.EnumHandler;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Random;

/**
 * Created by LiteWolf101 on 5/20/2018.
 */
public class BlockStrangeGrass extends BlockBush implements IGrowable, IShearable, ISubtypeHolder {
    public BlockStrangeGrass(String name, Material material) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setSoundType(SoundType.PLANT);
        setDefaultState(blockState.getBaseState().withProperty(hasBulb, false));
    }
    public static final PropertyBool hasBulb = PropertyBool.create("has_bulb");

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {hasBulb});
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return (state.getValue(hasBulb)).booleanValue() ? 1 : 0;
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(hasBulb, Boolean.valueOf(meta == 1));
    }

    @Override
    public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
        return true;
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
        return true;
    }

    @Override
    public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {

    }

    @Override
    public boolean isShearable(@Nonnull ItemStack item, IBlockAccess world, BlockPos pos) {
        return true;
    }

    @Override
    public List<ItemStack> onSheared(@Nonnull ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
        return null;
    }

    @Override
    public boolean isReplaceable(IBlockAccess worldIn, BlockPos pos)
    {
        return true;
    }

    @Override
    public String[] getSubNames() {
        return "with_bulb"
    }
}
