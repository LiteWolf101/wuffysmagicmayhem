package litewolf101.wuffysmagicmayhem.blocks;

import litewolf101.wuffysmagicmayhem.handlers.EnumHandler;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

/**
 * Created by LiteWolf101 on 11/24/2017.
 */
public class BlockBubbleshroom extends Block implements IMetaBlockName {
    public BlockBubbleshroom(String name, Material material) {
        super(material.PLANTS);
        setUnlocalizedName(name);
        setRegistryName(name);
        setDefaultState(this.blockState.getBaseState().withProperty(BUBBLESHROOMTYPE, EnumHandler.BubbleshroomType.GRAY));
    }
    public static final PropertyEnum BUBBLESHROOMTYPE = PropertyEnum.create("bubbleshroom_type", EnumHandler.BubbleshroomType.class);

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {BUBBLESHROOMTYPE});
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        EnumHandler.BubbleshroomType type = (EnumHandler.BubbleshroomType) state.getValue(BUBBLESHROOMTYPE);
        return type.getID();
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(BUBBLESHROOMTYPE, EnumHandler.BubbleshroomType.values()[meta]);
    }

    @Override
    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list) {
        for(int i = 0; i < EnumHandler.BubbleshroomType.values().length; i++){
            list.add(new ItemStack(this, 1, i));
        }
    }

    @Override
    public String getSpecialName(ItemStack stack) {
        return EnumHandler.BubbleshroomType.values()[stack.getItemDamage()].getName();
    }

    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
        return new ItemStack(Item.getItemFromBlock(this), 1, this.getMetaFromState(world.getBlockState(pos)));
    }
}
