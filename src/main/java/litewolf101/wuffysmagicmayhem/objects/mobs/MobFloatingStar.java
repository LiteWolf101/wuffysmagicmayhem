package litewolf101.wuffysmagicmayhem.objects.mobs;


import litewolf101.wuffysmagicmayhem.WuffysMagicMayhem;
import litewolf101.wuffysmagicmayhem.utils.client.fx.WMMParticleType;
import litewolf101.wuffysmagicmayhem.utils.handlers.WMMSoundHandler;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityAmbientCreature;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

/**
 * Created by LiteWolf101 on 6/16/2018.
 */
public class MobFloatingStar extends EntityAmbientCreature {
    public MobFloatingStar(World worldIn) {
        super(worldIn);
        setSize(1.0F, 1.0F);
    }

    private BlockPos spawnPosition;

    @Override
    protected void entityInit() {
        super.entityInit();
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(4.0D);
        getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.1D);
        getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0.5D);
    }

    @Override
    protected float getSoundVolume() {
        return 0.1F;
    }

    @Override
    protected float getSoundPitch() {
        return super.getSoundPitch() * 0.95F;
    }


    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return WMMSoundHandler.ENTITY_FLOATING_STAR_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return WMMSoundHandler.ENTITY_FLOATING_STAR_DEATH;
    }

    @Override
    public boolean canBePushed() {
        return false;
    }

    @Override
    protected void collideWithEntity(Entity par1Entity) {
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        spawnParticles(this);
        this.motionY *= 0.0000000238418579D;
    }

    @Override
    protected void updateAITasks() {
        super.updateAITasks();

        // [VanillaCopy] direct from last half of EntityBat.updateAITasks
        if (this.spawnPosition != null && (!this.world.isAirBlock(this.spawnPosition) || this.spawnPosition.getY() < 1)) {
            this.spawnPosition = null;
        }

        if (this.spawnPosition == null || this.rand.nextInt(30) == 0 || this.spawnPosition.distanceSq((double) ((int) this.posX), (double) ((int) this.posY), (double) ((int) this.posZ)) < 4.0D) {
            this.spawnPosition = new BlockPos((int) this.posX + this.rand.nextInt(7) - this.rand.nextInt(7), (int) this.posY + this.rand.nextInt(6) - 2, (int) this.posZ + this.rand.nextInt(7) - this.rand.nextInt(7));
        }

        double d0 = (double) this.spawnPosition.getX() + 0.5D - this.posX;
        double d1 = (double) this.spawnPosition.getY() + 0.1D - this.posY;
        double d2 = (double) this.spawnPosition.getZ() + 0.5D - this.posZ;
        this.motionX += (Math.signum(d0) * 0.2D - this.motionX) * 0.10000000149011612D;
        this.motionY += (Math.signum(d1) * 0.199999988079071D - this.motionY) * 0.10000000149011612D;
        this.motionZ += (Math.signum(d2) * 0.2D - this.motionZ) * 0.10000000149011612D;
        float f = (float) (MathHelper.atan2(this.motionZ, this.motionX) * (180D / Math.PI)) - 90.0F;
        float f1 = MathHelper.wrapDegrees(f - this.rotationYaw);
        this.moveForward = 0.2F;
        this.rotationYaw += f1;
        // End copy
        this.experienceValue = 10;
    }

    @Override
    protected boolean canTriggerWalking() {
        return false;
    }

    @Override
    public void fall(float dist, float mult) {
    }

    @Override
    protected void updateFallState(double par1, boolean par3, IBlockState state, BlockPos pos) {
    }

    @Override
    public boolean doesEntityNotTriggerPressurePlate() {
        return true;
    }

    // [VanillaCopy] EntityBat.getCanSpawnHere. Edits noted.
    @Override
    public boolean getCanSpawnHere() {
        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getBrightnessForRender() {
        return 15728880;
    }

    //public float getGlowBrightness() {
    //    return (float) Math.sin(this.ticksExisted / 7.0) + 1F;
    //}

    public void spawnParticles(Entity entity){
        double d0 = entity.posX - 0.5;
        double d1 = entity.posY + 0.5;
        double d2 = entity.posZ - 0.5;
        Random random = new Random();
        double randomX = random.nextInt(10);
        double randomY = random.nextInt(10);
        double randomZ = random.nextInt(10);
        WuffysMagicMayhem.proxy.spawnParticle(world, WMMParticleType.SHIMMERING_GRASS, d0 + (randomX / 10), d1 + (randomY / 10), d2 + (randomZ / 10), 0.0D, 0.1D, 0.0D);
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return 1;
    }


}


