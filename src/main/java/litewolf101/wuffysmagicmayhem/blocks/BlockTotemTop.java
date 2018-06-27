package litewolf101.wuffysmagicmayhem.blocks;

import litewolf101.wuffysmagicmayhem.handlers.WMMSoundHandler;
import litewolf101.wuffysmagicmayhem.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

/**
 * Created by LiteWolf101 on 5/11/2018.
 */
public class BlockTotemTop extends Block {
    public BlockTotemTop(String name, Material material) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setSoundType(SoundType.METAL);
        setTickRandomly(true);
        setLightLevel(1F);
        setLightOpacity(0);
        setHarvestLevel("pickaxe", 2);
        blockResistance = 7000;
        blockHardness = 1;

    }
    AxisAlignedBB totemBB = new AxisAlignedBB(0.3125D, 0, 0.3125D, 0.6875, 1, 0.6875);
    boolean isClicked;

    @Override
    public int tickRate(World worldIn) {
        return 40;
    }

    @Override
    public void updateTick(World world, BlockPos pos, IBlockState state, Random rand) {
        detectInBB(pos, world);
        world.scheduleUpdate(pos, this, 40);
        randomDisplayTick(state, world, pos, rand);
    }

    public void detectInBB (BlockPos pos, World world){
        double x = (double)pos.getX();
        double y = (double)pos.getY() + 1.0d;
        double z = (double)pos.getZ();
        AxisAlignedBB attackBB = new AxisAlignedBB(x - 6, y - 7 , z - 6, x + 7, y + 6, z + 7);
        List<EntityLivingBase> entities = world.getEntitiesWithinAABB(EntityLivingBase.class, attackBB);
        for (EntityLivingBase entity : world.getEntitiesWithinAABB(EntityLivingBase.class, attackBB)) {
            if (entity instanceof IMob) {
                Random randomPitch = new Random();
                float pitch = randomPitch.nextFloat()*(1.3F-0.7F)+0.7F;

                entity.attackEntityFrom(DamageSource.FALL, 4);
                world.playSound(null, pos, WMMSoundHandler.TOTEM_HIT, SoundCategory.BLOCKS, 0.5F, pitch);
            }
        }
    }

    @Override
    public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
        world.scheduleUpdate(pos, this, 40);
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
    @SuppressWarnings("deprecation")
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    @SuppressWarnings("deprecation")
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return totemBB;
    }

    @Nullable
    @Override
    @SuppressWarnings("deprecation")
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
        return totemBB;
    }

    @Override
    public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random rand) {
        double d0 = (double)pos.getX() + 0.5D;
        double d1 = (double)pos.getY() + 1.0D;
        double d2 = (double)pos.getZ() + 0.5D;
        world.spawnParticle(EnumParticleTypes.SPIT, d0, d1, d2, 0.0D, 0.1D, 0.0D);

        if (isClicked){
            Random random = new Random();
            int randX1 = random.nextInt(13);
            int randX2 = random.nextInt(13);
            int randX3 = random.nextInt(13);
            int randY1 = random.nextInt(13);
            int randY2 = random.nextInt(13);
            int randY3 = random.nextInt(13);
            int randZ1 = random.nextInt(13);
            int randZ2 = random.nextInt(13);
            int randZ3 = random.nextInt(13);
            EnumParticleTypes p = EnumParticleTypes.DRAGON_BREATH;
            for (int i = 0; i < 10; i++) {
                //line1
                world.spawnParticle(p, d0 + randX1 - 6, d1 + 6, d2 + 6, 0.0D, 0.0D, 0.0D);
                world.spawnParticle(p, d0 + randX2 - 6, d1 + 6, d2 + 6, 0.0D, 0.0D, 0.0D);
                world.spawnParticle(p, d0 + randX3 - 6, d1 + 6, d2 + 6, 0.0D, 0.0D, 0.0D);
                //line2
                world.spawnParticle(p, d0 + randX1 - 6, d1 + 6, d2 - 6, 0.0D, 0.0D, 0.0D);
                world.spawnParticle(p, d0 + randX2 - 6, d1 + 6, d2 - 6, 0.0D, 0.0D, 0.0D);
                world.spawnParticle(p, d0 + randX3 - 6, d1 + 6, d2 - 6, 0.0D, 0.0D, 0.0D);
                //line3
                world.spawnParticle(p, d0 + 6, d1 + 6, d2 + randZ1 - 6, 0.0D, 0.0D, 0.0D);
                world.spawnParticle(p, d0 + 6, d1 + 6, d2 + randZ2 - 6, 0.0D, 0.0D, 0.0D);
                world.spawnParticle(p, d0 + 6, d1 + 6, d2 + randZ3 - 6, 0.0D, 0.0D, 0.0D);
                //line4
                world.spawnParticle(p, d0 - 6, d1 + 6, d2 + randZ1 - 6, 0.0D, 0.0D, 0.0D);
                world.spawnParticle(p, d0 - 6, d1 + 6, d2 + randZ2 - 6, 0.0D, 0.0D, 0.0D);
                world.spawnParticle(p, d0 - 6, d1 + 6, d2 + randZ3 - 6, 0.0D, 0.0D, 0.0D);
                //line5
                world.spawnParticle(p, d0 + randX1 - 6, d1 - 6, d2 + 6, 0.0D, 0.0D, 0.0D);
                world.spawnParticle(p, d0 + randX2 - 6, d1 - 6, d2 + 6, 0.0D, 0.0D, 0.0D);
                world.spawnParticle(p, d0 + randX3 - 6, d1 - 6, d2 + 6, 0.0D, 0.0D, 0.0D);
                //line6
                world.spawnParticle(p, d0 + randX1 - 6, d1 - 6, d2 - 6, 0.0D, 0.0D, 0.0D);
                world.spawnParticle(p, d0 + randX2 - 6, d1 - 6, d2 - 6, 0.0D, 0.0D, 0.0D);
                world.spawnParticle(p, d0 + randX3 - 6, d1 - 6, d2 - 6, 0.0D, 0.0D, 0.0D);
                //line7
                world.spawnParticle(p, d0 + 6, d1 - 6, d2 + randZ1 - 6, 0.0D, 0.0D, 0.0D);
                world.spawnParticle(p, d0 + 6, d1 - 6, d2 + randZ2 - 6, 0.0D, 0.0D, 0.0D);
                world.spawnParticle(p, d0 + 6, d1 - 6, d2 + randZ3 - 6, 0.0D, 0.0D, 0.0D);
                //line8
                world.spawnParticle(p, d0 - 6, d1 - 6, d2 + randZ1 - 6, 0.0D, 0.0D, 0.0D);
                world.spawnParticle(p, d0 - 6, d1 - 6, d2 + randZ2 - 6, 0.0D, 0.0D, 0.0D);
                world.spawnParticle(p, d0 - 6, d1 - 6, d2 + randZ3 - 6, 0.0D, 0.0D, 0.0D);
                //line9
                world.spawnParticle(p, d0 - 6, d1 + randY1 - 6, d2 - 6, 0.0D, 0.0D, 0.0D);
                world.spawnParticle(p, d0 - 6, d1 + randY2 - 6, d2 - 6, 0.0D, 0.0D, 0.0D);
                world.spawnParticle(p, d0 - 6, d1 + randY3 - 6, d2 - 6, 0.0D, 0.0D, 0.0D);
                //line10
                world.spawnParticle(p, d0 + 6, d1 + randY1 - 6, d2 - 6, 0.0D, 0.0D, 0.0D);
                world.spawnParticle(p, d0 + 6, d1 + randY2 - 6, d2 - 6, 0.0D, 0.0D, 0.0D);
                world.spawnParticle(p, d0 + 6, d1 + randY3 - 6, d2 - 6, 0.0D, 0.0D, 0.0D);
                //line11
                world.spawnParticle(p, d0 + 6, d1 + randY1 - 6, d2 + 6, 0.0D, 0.0D, 0.0D);
                world.spawnParticle(p, d0 + 6, d1 + randY2 - 6, d2 + 6, 0.0D, 0.0D, 0.0D);
                world.spawnParticle(p, d0 + 6, d1 + randY3 - 6, d2 + 6, 0.0D, 0.0D, 0.0D);
                //line12
                world.spawnParticle(p, d0 - 6, d1 + randY1 - 6, d2 + 6, 0.0D, 0.0D, 0.0D);
                world.spawnParticle(p, d0 - 6, d1 + randY2 - 6, d2 + 6, 0.0D, 0.0D, 0.0D);
                world.spawnParticle(p, d0 - 6, d1 + randY3 - 6, d2 + 6, 0.0D, 0.0D, 0.0D);
                //System.out.println(i);
            }

        }


    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        Side fmlside = FMLCommonHandler.instance().getEffectiveSide();
        if (playerIn.getHeldItemMainhand() != ItemStack.EMPTY) {
            isClicked = true;
            worldIn.playSound(null, pos, WMMSoundHandler.TOTEM_HIT, SoundCategory.BLOCKS, 0.2F, 2.0F);
        }
        if (playerIn.getHeldItemMainhand() == ItemStack.EMPTY) {
            isClicked = false;
        }

        if (fmlside == Side.CLIENT){
            if (playerIn.getHeldItemMainhand() != ItemStack.EMPTY) {
                infoBBIsOn(playerIn);
            }
            if (playerIn.getHeldItemMainhand() == ItemStack.EMPTY) {
                infoBBIsOff(playerIn);
            }
        }
        return false;
    }

    @SideOnly(Side.CLIENT)
    public void infoBBIsOn(EntityLivingBase player) {
        player.sendMessage(new TextComponentTranslation(TextFormatting.LIGHT_PURPLE + "Area of effect: " + TextFormatting.RESET + "Shown"));
    }

    @SideOnly(Side.CLIENT)
    public void infoBBIsOff(EntityLivingBase player) {
        player.sendMessage(new TextComponentTranslation(TextFormatting.LIGHT_PURPLE + "Area of effect: " + TextFormatting.RESET + "Hidden"));
    }
}
