package litewolf101.wuffysmagicmayhem.blocks;

import litewolf101.wuffysmagicmayhem.handlers.WMMSoundHandler;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

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
        AxisAlignedBB attackBB = new AxisAlignedBB(x - 7, y -7 , z -7, x + 7, y + 7, z + 8);
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
        world.spawnParticle(EnumParticleTypes.SPIT, d0, d1, d2, 0.0D, 0.5D, 0.0D);
    }
}
