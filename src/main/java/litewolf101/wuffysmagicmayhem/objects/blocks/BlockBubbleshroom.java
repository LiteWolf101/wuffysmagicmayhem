package litewolf101.wuffysmagicmayhem.objects.blocks;

import litewolf101.wuffysmagicmayhem.WuffysMagicMayhem;
import litewolf101.wuffysmagicmayhem.init.BlocksInit;
import litewolf101.wuffysmagicmayhem.init.ItemsInit;
import litewolf101.wuffysmagicmayhem.objects.blocks.item.ItemBlockVariants;
import litewolf101.wuffysmagicmayhem.utils.IHasModel;
import litewolf101.wuffysmagicmayhem.utils.IMetaName;
import litewolf101.wuffysmagicmayhem.utils.handlers.EnumShroomColorHandler;
import net.minecraft.block.BlockBush;
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
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by LiteWolf101 on 7/7/2018.
 */
public class BlockBubbleshroom extends BlockBush implements IHasModel, IMetaName{
    public static final PropertyEnum<EnumShroomColorHandler.EnumType> COLOR = PropertyEnum.<EnumShroomColorHandler.EnumType>create("color", EnumShroomColorHandler.EnumType.class);

    public BlockBubbleshroom(String name, Material material) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setSoundType(SoundType.PLANT);
        setCreativeTab(WuffysMagicMayhem.CREATIVE_TAB);
        setDefaultState(this.blockState.getBaseState().withProperty(COLOR, EnumShroomColorHandler.EnumType.BLUE));
        setLightLevel(0.3F);

        BlocksInit.BLOCKS.add(this);
        ItemsInit.ITEMS.add(new ItemBlockVariants(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public int damageDropped(IBlockState state) {
        return ((EnumShroomColorHandler.EnumType)state.getValue(COLOR)).getMeta();
    }

    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {

        for(EnumShroomColorHandler.EnumType shroomColor$enumtype : EnumShroomColorHandler.EnumType.values()) {

            items.add(new ItemStack(this, 1, shroomColor$enumtype.getMeta()));
        }
    }

    @Override
    @SuppressWarnings("deprecation")
    public IBlockState getStateFromMeta(int meta) {

        return this.getDefaultState().withProperty(COLOR, EnumShroomColorHandler.EnumType.byMetadata(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state) {

        return ((EnumShroomColorHandler.EnumType)state.getValue(COLOR)).getMeta();
    }

    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {

        return new ItemStack(Item.getItemFromBlock(this), 1, getMetaFromState(world.getBlockState(pos)));
    }

    @Override
    protected BlockStateContainer createBlockState() {

        return new BlockStateContainer(this, new IProperty[] {COLOR});
    }

    @Override
    public String getSpecialName(ItemStack stack) {

        return EnumShroomColorHandler.EnumType.values()[stack.getItemDamage()].getName();
    }

    @Override
    public void registerModels() {
        for(int i = 0; i < EnumShroomColorHandler.EnumType.values().length; i++)
        {
            WuffysMagicMayhem.proxy.registerVariantRenderer(Item.getItemFromBlock(this), i, EnumShroomColorHandler.EnumType.values()[i].getName() + "_bubbleshroom", "inventory");
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }

    @Override
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
        if (entityIn instanceof EntityLivingBase) {
            ((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(Potion.getPotionById(24), 10, 2, true, false));
        }
    }
}
