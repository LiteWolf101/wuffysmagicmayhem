package litewolf101.wuffysmagicmayhem.objects.blocks;

import litewolf101.wuffysmagicmayhem.WuffysMagicMayhem;
import litewolf101.wuffysmagicmayhem.init.BlocksInit;
import litewolf101.wuffysmagicmayhem.init.ItemsInit;
import litewolf101.wuffysmagicmayhem.objects.blocks.item.ItemBlockVariants;
import litewolf101.wuffysmagicmayhem.utils.IHasModel;
import litewolf101.wuffysmagicmayhem.utils.IMetaName;
import litewolf101.wuffysmagicmayhem.utils.handlers.EnumWoodHandler;
import net.minecraft.block.BlockLog;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import javax.annotation.Nullable;

/**
 * Created by LiteWolf101 on 7/6/2018.
 */
public class BlockLogs extends BlockLog implements IHasModel, IMetaName {
    public static final PropertyEnum<EnumWoodHandler.EnumType> VARIANT = PropertyEnum.<EnumWoodHandler.EnumType>create("variant", EnumWoodHandler.EnumType.class, new com.google.common.base.Predicate<EnumWoodHandler.EnumType>() {
        @Override
        public boolean apply(@Nullable EnumWoodHandler.EnumType apply) {
            return apply.getMeta() < 4;
        }
    });
    private String name;

    public BlockLogs(String name) {
        super();
        setUnlocalizedName(name);
        setRegistryName(name);
        setSoundType(SoundType.WOOD);
        setCreativeTab(WuffysMagicMayhem.CREATIVE_TAB);
        setHarvestLevel("axe", 0);
        setHardness(2F);
        setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, EnumWoodHandler.EnumType.STARLIGHT).withProperty(LOG_AXIS, BlockLog.EnumAxis.Y));

        BlocksInit.BLOCKS.add(this);
        ItemsInit.ITEMS.add(new ItemBlockVariants(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {

        for(EnumWoodHandler.EnumType wmmplanks$enumtype : EnumWoodHandler.EnumType.values()) {

            items.add(new ItemStack(this, 1, wmmplanks$enumtype.getMeta()));
        }
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        IBlockState state = this.getDefaultState().withProperty(VARIANT, EnumWoodHandler.EnumType.byMetadata((meta & 3) % 4));

        switch(meta & 12)
        {
            case 0:
                state = state.withProperty(LOG_AXIS, BlockLog.EnumAxis.Y);
                break;

            case 4:
                state = state.withProperty(LOG_AXIS, BlockLog.EnumAxis.X);
                break;

            case 8:
                state = state.withProperty(LOG_AXIS, BlockLog.EnumAxis.Z);
                break;

            default:
                state = state.withProperty(LOG_AXIS, BlockLog.EnumAxis.NONE);
        }

        return state;
    }

    //@SuppressWarnings("incomplete-switch")
    @Override
    public int getMetaFromState(IBlockState state)
    {
        int i = 0;
        i = i | ((EnumWoodHandler.EnumType)state.getValue(VARIANT)).getMeta();

        switch((BlockLog.EnumAxis)state.getValue(LOG_AXIS))
        {
            case X:
                i |= 4;
                break;

            case Y:
                i |= 8;
                break;

            case Z:
                i |= 12;
        }

        return i;
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {VARIANT,LOG_AXIS});
    }

    @Override
    public int damageDropped(IBlockState state) {
        return ((EnumWoodHandler.EnumType)state.getValue(VARIANT)).getMeta();
    }

    @Override
    public String getSpecialName(ItemStack stack) {

        return EnumWoodHandler.EnumType.values()[stack.getItemDamage()].getName();
    }

    @Override
    public void registerModels() {
        for(int i = 0; i < EnumWoodHandler.EnumType.values().length; i++)
        {
            WuffysMagicMayhem.proxy.registerVariantRenderer(Item.getItemFromBlock(this), i, "log_" + EnumWoodHandler.EnumType.values()[i].getName(), "inventory");
        }
    }

    protected ItemStack getSilkTouchDrop(IBlockState state)
    {
        return new ItemStack(Item.getItemFromBlock(this), 1, ((EnumWoodHandler.EnumType)state.getValue(VARIANT)).getMeta());
    }

    @Override
    public boolean canBeReplacedByLeaves(IBlockState state, IBlockAccess world, BlockPos pos) {
        return false;
    }
}
