package litewolf101.wuffysmagicmayhem.objects.blocks;

import litewolf101.wuffysmagicmayhem.WuffysMagicMayhem;
import litewolf101.wuffysmagicmayhem.init.BlocksInit;
import litewolf101.wuffysmagicmayhem.init.ItemsInit;
import litewolf101.wuffysmagicmayhem.objects.blocks.item.ItemBlockVariants;
import litewolf101.wuffysmagicmayhem.utils.IHasModel;
import litewolf101.wuffysmagicmayhem.utils.IMetaName;
import litewolf101.wuffysmagicmayhem.utils.handlers.EnumWoodHandler;
import litewolf101.wuffysmagicmayhem.world.worldgen.trees.WorldGenAshenedTree;
import litewolf101.wuffysmagicmayhem.world.worldgen.trees.WorldGenDarkenedTree;
import litewolf101.wuffysmagicmayhem.world.worldgen.trees.WorldGenEnchantedTree;
import litewolf101.wuffysmagicmayhem.world.worldgen.trees.WorldGenStarlightTree;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

/**
 * Created by LiteWolf101 on 7/10/2018.
 */
public class BlockSaplings extends BlockBush implements IHasModel, IMetaName, IGrowable {
    public static final PropertyEnum<EnumWoodHandler.EnumType> VARIANT = PropertyEnum.<EnumWoodHandler.EnumType>create("variant", EnumWoodHandler.EnumType.class);
    protected static final AxisAlignedBB SAPLING_AABB = new AxisAlignedBB(0.09999999403953552D, 0.0D, 0.09999999403953552D, 0.8999999761581421D, 0.800000011920929D, 0.8999999761581421D);
    public BlockSaplings(String name, Material material) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setSoundType(SoundType.PLANT);
        setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, EnumWoodHandler.EnumType.STARLIGHT));
        setCreativeTab(WuffysMagicMayhem.CREATIVE_TAB);

        BlocksInit.BLOCKS.add(this);
        ItemsInit.ITEMS.add(new ItemBlockVariants(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    @SuppressWarnings("deprecation")
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return SAPLING_AABB;
    }

    @Override
    public int damageDropped(IBlockState state) {
        return ((EnumWoodHandler.EnumType)state.getValue(VARIANT)).getMeta();
    }

    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {

        for(EnumWoodHandler.EnumType wmmsapling$enumtype : EnumWoodHandler.EnumType.values()) {

            items.add(new ItemStack(this, 1, wmmsapling$enumtype.getMeta()));
        }
    }

    @Override
    @SuppressWarnings("deprecation")
    public IBlockState getStateFromMeta(int meta) {

        return this.getDefaultState().withProperty(VARIANT, EnumWoodHandler.EnumType.byMetadata(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state) {

        return ((EnumWoodHandler.EnumType)state.getValue(VARIANT)).getMeta();
    }

    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {

        return new ItemStack(Item.getItemFromBlock(this), 1, getMetaFromState(world.getBlockState(pos)));
    }

    @Override
    protected BlockStateContainer createBlockState() {

        return new BlockStateContainer(this, new IProperty[] {VARIANT});
    }


    @Override
    public void registerModels() {
        for(int i = 0; i < EnumWoodHandler.EnumType.values().length; i++)
        {
            WuffysMagicMayhem.proxy.registerVariantRenderer(Item.getItemFromBlock(this), i, EnumWoodHandler.EnumType.values()[i].getName() + "_sapling", "inventory");
        }
    }

    @Override
    public String getSpecialName(ItemStack stack) {
        return EnumWoodHandler.EnumType.values()[stack.getItemDamage()].getName();
    }

    @Override
    public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
        for (int i = 1; i < 20; i++){
            if (!worldIn.isAirBlock(pos.up(i))){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
        return (double) worldIn.rand.nextFloat() < 0.45D;
    }

    @Override
    public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {
        this.generateTree(worldIn, pos, state, rand);
    }

    private void generateTree(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        WorldGenerator treeGen;

        switch (state.getValue(VARIANT)) {
            case STARLIGHT:
                default:
                treeGen = new WorldGenStarlightTree(true);
                break;

            case DARKENED:
                treeGen = new WorldGenDarkenedTree(true);
                break;

            case ENCHANTED:
                treeGen = new WorldGenEnchantedTree(true);
                break;

            case ASHENED:
                treeGen = new WorldGenAshenedTree(true);
                break;
        }


        worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 4);

        if (!treeGen.generate(worldIn, rand, pos)) {
            worldIn.setBlockState(pos, state, 4);
        }
    }
}
