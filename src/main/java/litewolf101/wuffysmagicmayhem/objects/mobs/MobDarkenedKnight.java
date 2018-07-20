package litewolf101.wuffysmagicmayhem.objects.mobs;

import litewolf101.wuffysmagicmayhem.utils.handlers.WMMSoundHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

/**
 * Created by LiteWolf101 on 7/11/2018.
 */
public class MobDarkenedKnight extends EntityMob implements IMob {

    public MobDarkenedKnight(World worldIn) {
        super(worldIn);
        setSize(0.7F, 1.96F);
    }

    public MobDarkenedKnight(World world, double x, double y, double z, float rotationYaw) {
        this(world);
        this.rotationYaw = rotationYaw * (180F / (float)Math.PI);
        this.setPosition(x, y, z);
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIAttackMelee(this, 1.0D, false));
        this.tasks.addTask(3, new EntityAIWander(this, 0.4D));
        this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 16.0F, 1.0F));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, new Class[] {MobDarkenedKnight.class}));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3499999940395355D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(16.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5.0D);
    }

    @Override
    protected void entityInit() {
        super.entityInit();
    }

    @Nullable
    @Override
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
        IEntityLivingData ientitylivingdata = super.onInitialSpawn(difficulty, livingdata);
        this.setEquipmentBasedOnDifficulty(difficulty);
        this.setEnchantmentBasedOnDifficulty(difficulty);
        return ientitylivingdata;
    }

    @Override
    protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
        this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.DIAMOND_SWORD));
    }

    @Override
    protected void updateAITasks() {
        super.updateAITasks();
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return WMMSoundHandler.ENTITY_DARKENED_KNIGHT_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource p_184601_1_) {
        return WMMSoundHandler.ENTITY_DARKENED_KNIGHT_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return WMMSoundHandler.ENTITY_DARKENED_KNIGHT_DEATH;
    }

    @Override
    protected float getSoundVolume() {
        return 0.5F;
    }

    @Override
    protected float getSoundPitch() {
        return super.getSoundPitch() * 0.95F;
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        spawnParticles(this);
    }

    public void spawnParticles(Entity entity){
        double d0 = entity.posX - 0.5;
        double d1 = entity.posY;
        double d2 = entity.posZ - 0.5;
        Random random = new Random();
        double randomX = random.nextInt(10);
        double randomY = random.nextInt(10);
        double randomZ = random.nextInt(10);
        int choice = random.nextInt(20);
        if(choice <= 10){world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0 + (randomX / 10), d1 + (randomY / 10), d2 + (randomZ / 10), 0.0D, 0.001D, 0.0D);}
        if(choice > 10){world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, d0 + (randomX / 15), d1 + (randomY / 15), d2 + (randomZ / 15), 0.0D, 0.001D, 0.0D);}

    }
}
