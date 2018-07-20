package litewolf101.wuffysmagicmayhem.objects.blocks;

import litewolf101.wuffysmagicmayhem.WuffysMagicMayhem;
import litewolf101.wuffysmagicmayhem.init.BlocksInit;
import litewolf101.wuffysmagicmayhem.init.ItemsInit;
import litewolf101.wuffysmagicmayhem.objects.blocks.item.ItemBlockVariants;
import litewolf101.wuffysmagicmayhem.utils.IHasModel;
import litewolf101.wuffysmagicmayhem.utils.IMetaName;
import litewolf101.wuffysmagicmayhem.utils.handlers.EnumWoodHandler;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

/**
 * Created by LiteWolf101 on 7/6/2018.
 */
public class BlockPlank extends Block implements IHasModel, IMetaName {
    public static final PropertyEnum<EnumWoodHandler.EnumType> VARIANT = PropertyEnum.<EnumWoodHandler.EnumType>create("variant", EnumWoodHandler.EnumType.class);
    public BlockPlank(String name, Material material) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setSoundType(SoundType.WOOD);
        setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, EnumWoodHandler.EnumType.STARLIGHT));
        setCreativeTab(WuffysMagicMayhem.CREATIVE_TAB);
        setHarvestLevel("axe", 0);
        setHardness(2F);

        BlocksInit.BLOCKS.add(this);
        ItemsInit.ITEMS.add(new ItemBlockVariants(this).setRegistryName(this.getRegistryName()));

    }

    @Override
    public int damageDropped(IBlockState state) {
        return ((EnumWoodHandler.EnumType)state.getValue(VARIANT)).getMeta();
    }

    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {

        for(EnumWoodHandler.EnumType wmmplanks$enumtype : EnumWoodHandler.EnumType.values()) {

            items.add(new ItemStack(this, 1, wmmplanks$enumtype.getMeta()));
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
    public String getSpecialName(ItemStack stack) {

        return EnumWoodHandler.EnumType.values()[stack.getItemDamage()].getName();
    }

    @Override
    public void registerModels() {
        for(int i = 0; i < EnumWoodHandler.EnumType.values().length; i++)
        {
            WuffysMagicMayhem.proxy.registerVariantRenderer(Item.getItemFromBlock(this), i, "planks_" + EnumWoodHandler.EnumType.values()[i].getName(), "inventory");
        }
    }

    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
        IBlockState state = worldIn.getBlockState(pos).withProperty(VARIANT, EnumWoodHandler.EnumType.ENCHANTED);

        if (entityIn instanceof EntityLivingBase) {

            //todo Fix loop
            if (state == this.getBlockState()) {
                System.out.println("Woof");
                ((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(Potion.getPotionById(16), 201));
            }
        }
    }
}
