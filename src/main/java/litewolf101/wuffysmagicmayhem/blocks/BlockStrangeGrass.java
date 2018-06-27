package litewolf101.wuffysmagicmayhem.blocks;

import litewolf101.wuffysmagicmayhem.handlers.EnumHandler;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.MathHelper;

/**
 * Created by LiteWolf101 on 5/20/2018.
 */
public class BlockStrangeGrass extends BlockBush {
    public BlockStrangeGrass(String name, Material material) {
        super();
        setRegistryName(name);
        setUnlocalizedName(name);
        setSoundType(SoundType.PLANT);
    }
    public static final PropertyEnum<EnumHandler.StrangeGrassType> HAS_BULB_PROPERTY_ENUM = PropertyEnum.create("has_bulb", EnumHandler.StrangeGrassType.class);

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, HAS_BULB_PROPERTY_ENUM);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(HAS_BULB_PROPERTY_ENUM).ordinal();
    }

    @Override
    @SuppressWarnings("deprecation")
    public IBlockState getStateFromMeta(int meta) {
        EnumHandler.StrangeGrassType type = EnumHandler.StrangeGrassType.values()[MathHelper.clamp(meta, 0, EnumHandler.StrangeGrassType.values().length)];
        return getDefaultState().withProperty(HAS_BULB_PROPERTY_ENUM, type);
    }

    @Override
    public void getSubBlocks(CreativeTabs par2CreativeTabs, NonNullList<ItemStack> stackList) {
        for (int i = 0; i < EnumHandler.StrangeGrassType.values().length; i++) {
            stackList.add(new ItemStack(this, 1, i));
        }
    }
}
