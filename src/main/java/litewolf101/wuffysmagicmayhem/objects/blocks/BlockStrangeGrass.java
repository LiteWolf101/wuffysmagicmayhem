package litewolf101.wuffysmagicmayhem.objects.blocks;

import litewolf101.wuffysmagicmayhem.WuffysMagicMayhem;
import litewolf101.wuffysmagicmayhem.init.BlocksInit;
import litewolf101.wuffysmagicmayhem.init.ItemsInit;
import litewolf101.wuffysmagicmayhem.objects.blocks.item.ItemBlockVariants;
import litewolf101.wuffysmagicmayhem.utils.IHasModel;
import litewolf101.wuffysmagicmayhem.utils.IMetaName;
import litewolf101.wuffysmagicmayhem.utils.handlers.EnumBulbHandler;
import net.minecraft.block.BlockBush;
import net.minecraft.block.SoundType;
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

import java.util.Random;

/**
 * Created by LiteWolf101 on 7/7/2018.
 */
public class BlockStrangeGrass extends BlockBush implements IHasModel, IMetaName {
    public static final PropertyEnum<EnumBulbHandler.EnumType> HAS_BULB = PropertyEnum.<EnumBulbHandler.EnumType>create("has_bulb", EnumBulbHandler.EnumType.class);

    public BlockStrangeGrass(String name, Material material) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setSoundType(SoundType.PLANT);
        setCreativeTab(WuffysMagicMayhem.CREATIVE_TAB);
        setDefaultState(this.blockState.getBaseState().withProperty(HAS_BULB, EnumBulbHandler.EnumType.NO_BULB));
        setTickRandomly(true);

        BlocksInit.BLOCKS.add(this);
        ItemsInit.ITEMS.add(new ItemBlockVariants(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public int damageDropped(IBlockState state) {
        return ((EnumBulbHandler.EnumType)state.getValue(HAS_BULB)).getMeta();
    }

    @Override
    public int tickRate(World worldIn) {
        return 200;
    }

    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {

        for(EnumBulbHandler.EnumType strangeGrass$enumtype : EnumBulbHandler.EnumType.values()) {

            items.add(new ItemStack(this, 1, strangeGrass$enumtype.getMeta()));
        }
    }

    @Override
    @SuppressWarnings("deprecation")
    public IBlockState getStateFromMeta(int meta) {

        return this.getDefaultState().withProperty(HAS_BULB, EnumBulbHandler.EnumType.byMetadata(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state) {

        return ((EnumBulbHandler.EnumType)state.getValue(HAS_BULB)).getMeta();
    }

    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {

        return new ItemStack(Item.getItemFromBlock(this), 1, getMetaFromState(world.getBlockState(pos)));
    }

    @Override
    protected BlockStateContainer createBlockState() {

        return new BlockStateContainer(this, new IProperty[] {HAS_BULB});
    }

    @Override
    public String getSpecialName(ItemStack stack) {

        return EnumBulbHandler.EnumType.values()[stack.getItemDamage()].getName();
    }

    @Override
    public void registerModels() {
        for(int i = 0; i < EnumBulbHandler.EnumType.values().length; i++)
        {
            WuffysMagicMayhem.proxy.registerVariantRenderer(Item.getItemFromBlock(this), i, "strange_grass_" + EnumBulbHandler.EnumType.values()[i].getName(), "inventory");
        }
    }

    @Override
    public void updateTick(World world, BlockPos pos, IBlockState state, Random rand) {
        world.scheduleUpdate(pos, this, 200);
        changeStateRandomly(world, state, pos);
    }

    @Override
    public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
        world.scheduleUpdate(pos, this, 200);
    }

    public void changeStateRandomly(World world, IBlockState state, BlockPos pos) {
        Random random = new Random();
        int randInt = random.nextInt(100);
        if (randInt < 50) {
            world.setBlockState(pos, state.withProperty(HAS_BULB, EnumBulbHandler.EnumType.NO_BULB));
        } else if (randInt >= 50) {
            world.setBlockState(pos, state.withProperty(HAS_BULB, EnumBulbHandler.EnumType.HAS_BULB));
        }
    }
}
