package litewolf101.wuffysmagicmayhem.objects.mobs;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Random;

/**
 * Created by LiteWolf101 on 7/13/2018.
 */
public class MobDarkenedSummoner extends EntityMob implements IMob {
    public boolean isCasting;
    public int spellType;
    public int castingTime;
    public MobDarkenedSummoner(World worldIn) {
        super(worldIn);
        setSize(0.7F, 1.96F);
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIAvoidEntity(this, EntityPlayer.class, 6.0F, 0.9D, 1.7D));
        this.tasks.addTask(4, new EntityAIWander(this, 0.4D));
        this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 16.0F, 1.0F));
        this.tasks.addTask(1, new AISummonerSpell());
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, new Class[] {MobDarkenedKnight.class}));
        this.targetTasks.addTask(2, (new EntityAINearestAttackableTarget(this, EntityPlayer.class, true)).setUnseenMemoryTicks(100));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.27752982D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(24.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0D);
    }

    public boolean isCasting(){
        if(MobDarkenedSummoner.this.world.isRemote){
            return isCasting;
        }
        return  castingTime > 0;
    }

    public boolean getIsCasting(){
        return isCasting();
    }

    @Override
    protected void entityInit() {
        super.entityInit();
    }

    @Override
    protected void updateAITasks() {
        super.updateAITasks();
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        spawnParticles(this);
        if (isCasting){
            spawnMagicParticles(this);
        }
    }

    public void spawnParticles(Entity entity) {
        double d0 = entity.posX - 0.5;
        double d1 = entity.posY;
        double d2 = entity.posZ - 0.5;
        Random random = new Random();
        double randomX = random.nextInt(10);
        double randomY = random.nextInt(10);
        double randomZ = random.nextInt(10);
        int choice = random.nextInt(20);
        if(choice <= 10){world.spawnParticle(EnumParticleTypes.SPELL_MOB_AMBIENT, d0 + (randomX / 10), d1 + (randomY / 10), d2 + (randomZ / 10), 0.0D, 0.001D, 0.0D);}
        if(choice > 10){world.spawnParticle(EnumParticleTypes.ENCHANTMENT_TABLE, d0 + (randomX / 15), d1 + (randomY / 15), d2 + (randomZ / 15), 0.0D, 0.001D, 0.0D);}
    }

    private void spawnMagicParticles(Entity entity) {
        double d0 = entity.posX;
        double d1 = entity.posY + 2.5;
        double d2 = entity.posZ;

        world.spawnParticle(EnumParticleTypes.DRAGON_BREATH, d0, d1, d2, 0,0.01,0);

    }

    @Override
    protected int getExperiencePoints(EntityPlayer player) {
        return 55;
    }

    protected SoundEvent getPrepareSound() { return SoundEvents.EVOCATION_ILLAGER_PREPARE_SUMMON; }

    @SideOnly(Side.CLIENT)
    public MobDarkenedSummoner.SummonerArmPose getArmPose() {
        if(MobDarkenedSummoner.this.isCasting) {
            return SummonerArmPose.CASTING;
        } else {
            return SummonerArmPose.NORMAL;
        }
    }

    @SideOnly(Side.CLIENT)
    public static enum SummonerArmPose {
        NORMAL,
        CASTING;
    }

    //===============Inner Classes===================

    class AISummonerSpell extends EntityAIBase {
        protected int spellCooldown;
        //BlockPos entityPos = new BlockPos.MutableBlockPos((int)MobDarkenedSummoner.this.posX, (int)MobDarkenedSummoner.this.posY, (int)MobDarkenedSummoner.this.posZ);
        EntityLivingBase target = MobDarkenedSummoner.this.getAttackTarget();
        EntityLivingBase livingBase1 = MobDarkenedSummoner.this;

        private AISummonerSpell(){
            super();
        }
        @Override
        public void startExecuting() {
            castingTime = getCastingTime();
            this.spellCooldown = getCooldownTime();

        }

        protected int getCastingTime(){
            return 40;
        }
        protected int getCooldownTime() {return 120;}

        @Override
        public void updateTask() {
            spellCooldown--;
            if (spellCooldown == 0){
                isCasting = true;
            }
            if (isCasting){
                castingTime--;
                if(castingTime == 39){
                    chooseSpell();
                    MobDarkenedSummoner.this.playSound(getPrepareSound(), 1, 2);
                }
                if(castingTime < 39){
                    spawnMagicParticles(MobDarkenedSummoner.this);
                }
                if (castingTime == 0){
                    setSpellType();
                    spellCooldown = getCooldownTime();
                    castingTime = getCastingTime();
                }
            }
            if (spellCooldown > 0){
                isCasting = false;
            }
        }

        protected void chooseSpell(){
            Random random = new Random();
            int randSpell = random.nextInt(50);
            if(randSpell < 10){
                spellType = 0;
                System.out.println("heal");
            } else if (randSpell < 20 && randSpell >= 10) {
                spellType = 1;
                System.out.println("surround");
            } else if (randSpell < 30 && randSpell >= 20) {
                spellType = 2;
                System.out.println("spawn");
            } else if (randSpell < 40 && randSpell >= 30) {
                spellType = 3;
                System.out.println("fireball");
            } else if (randSpell >= 40) {
                spellType = 4;
                System.out.println("poke");
            }
        }

        public void setSpellType(){
            if(spellType == 0){
                spellHeal();
            }
            if(spellType == 1){
                spellSurround();
            }
            if(spellType == 2){
                spellSpawn();
            }
            if(spellType == 3){
                spellFireball();
            }
            if(spellType == 4){
                spellPrick();
            }
        }

        protected void spellHeal() {
            heal(3.5F);
            MobDarkenedSummoner.this.playSound(SoundEvents.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
            System.out.println("I healed");
        }

        protected void spellSurround(){
            EntitySummonerSpike summonerSpike0 = new EntitySummonerSpike(MobDarkenedSummoner.this.world, MobDarkenedSummoner.this.posX + 1,  MobDarkenedSummoner.this.posY - 0.5, MobDarkenedSummoner.this.posZ, 0F, 0, livingBase1);
            EntitySummonerSpike summonerSpike1 = new EntitySummonerSpike(MobDarkenedSummoner.this.world, MobDarkenedSummoner.this.posX + 1,  MobDarkenedSummoner.this.posY - 0.5, MobDarkenedSummoner.this.posZ + 1, 0F, 0, livingBase1);
            EntitySummonerSpike summonerSpike2 = new EntitySummonerSpike(MobDarkenedSummoner.this.world, MobDarkenedSummoner.this.posX,  MobDarkenedSummoner.this.posY - 0.5, MobDarkenedSummoner.this.posZ + 1, 0F, 0, livingBase1);
            EntitySummonerSpike summonerSpike3 = new EntitySummonerSpike(MobDarkenedSummoner.this.world, MobDarkenedSummoner.this.posX - 1,  MobDarkenedSummoner.this.posY - 0.5, MobDarkenedSummoner.this.posZ + 1, 0F, 0, livingBase1);
            EntitySummonerSpike summonerSpike4 = new EntitySummonerSpike(MobDarkenedSummoner.this.world, MobDarkenedSummoner.this.posX - 1,  MobDarkenedSummoner.this.posY - 0.5, MobDarkenedSummoner.this.posZ, 0F, 0, livingBase1);
            EntitySummonerSpike summonerSpike5 = new EntitySummonerSpike(MobDarkenedSummoner.this.world, MobDarkenedSummoner.this.posX - 1,  MobDarkenedSummoner.this.posY - 0.5, MobDarkenedSummoner.this.posZ - 1, 0F, 0, livingBase1);
            EntitySummonerSpike summonerSpike6 = new EntitySummonerSpike(MobDarkenedSummoner.this.world, MobDarkenedSummoner.this.posX,  MobDarkenedSummoner.this.posY - 0.5, MobDarkenedSummoner.this.posZ - 1, 0F, 0, livingBase1);
            EntitySummonerSpike summonerSpike7 = new EntitySummonerSpike(MobDarkenedSummoner.this.world, MobDarkenedSummoner.this.posX + 1,  MobDarkenedSummoner.this.posY - 0.5, MobDarkenedSummoner.this.posZ - 1, 0F, 0, livingBase1);
            MobDarkenedSummoner.this.world.spawnEntity(summonerSpike0);
            MobDarkenedSummoner.this.world.spawnEntity(summonerSpike1);
            MobDarkenedSummoner.this.world.spawnEntity(summonerSpike2);
            MobDarkenedSummoner.this.world.spawnEntity(summonerSpike3);
            MobDarkenedSummoner.this.world.spawnEntity(summonerSpike4);
            MobDarkenedSummoner.this.world.spawnEntity(summonerSpike5);
            MobDarkenedSummoner.this.world.spawnEntity(summonerSpike6);
            MobDarkenedSummoner.this.world.spawnEntity(summonerSpike7);
            MobDarkenedSummoner.this.playSound(SoundEvents.ENTITY_ENDERMEN_TELEPORT, 1.0F, 1.0F);
            System.out.println("Im surrounded");
        }
        protected void spellSpawn(){
            MobDarkenedKnight darkenedKnight = new MobDarkenedKnight(MobDarkenedSummoner.this.world, MobDarkenedSummoner.this.posX + 1,  MobDarkenedSummoner.this.posY, MobDarkenedSummoner.this.posZ + 1, MobDarkenedSummoner.this.rotationYaw);
            MobDarkenedKnight darkenedKnight1 = new MobDarkenedKnight(MobDarkenedSummoner.this.world, MobDarkenedSummoner.this.posX - 1,  MobDarkenedSummoner.this.posY, MobDarkenedSummoner.this.posZ - 1, MobDarkenedSummoner.this.rotationYaw);
            MobDarkenedSummoner.this.world.spawnEntity(darkenedKnight);
            MobDarkenedSummoner.this.world.spawnEntity(darkenedKnight1);
            MobDarkenedSummoner.this.playSound(SoundEvents.BLOCK_PORTAL_TRIGGER, 1.0F, 1.0F);
            System.out.println("I spawned stuff");
        }
        protected void spellFireball() {
            EntitySmallFireball entitySmallFireball = new EntitySmallFireball(MobDarkenedSummoner.this.world, MobDarkenedSummoner.this, MobDarkenedSummoner.this.getLook(1.0F).x, MobDarkenedSummoner.this.getLook(1.0F).y, MobDarkenedSummoner.this.getLook(1.0F).z);
            EntitySmallFireball entitySmallFireball1 = new EntitySmallFireball(MobDarkenedSummoner.this.world, MobDarkenedSummoner.this, MobDarkenedSummoner.this.getLook(1.0F).x + 0.01F, MobDarkenedSummoner.this.getLook(1.0F).y, MobDarkenedSummoner.this.getLook(1.0F).z);
            EntitySmallFireball entitySmallFireball2 = new EntitySmallFireball(MobDarkenedSummoner.this.world, MobDarkenedSummoner.this, MobDarkenedSummoner.this.getLook(1.0F).x - 0.01F, MobDarkenedSummoner.this.getLook(1.0F).y, MobDarkenedSummoner.this.getLook(1.0F).z);
            entitySmallFireball.posX = MobDarkenedSummoner.this.posX;
            entitySmallFireball.posY = MobDarkenedSummoner.this.posY + (double)(MobDarkenedSummoner.this.height / 2.0F) + 0.5D;
            entitySmallFireball.posZ = MobDarkenedSummoner.this.posZ;

            entitySmallFireball1.posX = MobDarkenedSummoner.this.posX;
            entitySmallFireball1.posY = MobDarkenedSummoner.this.posY + (double)(MobDarkenedSummoner.this.height / 2.0F) + 0.5D;
            entitySmallFireball1.posZ = MobDarkenedSummoner.this.posZ;

            entitySmallFireball2.posX = MobDarkenedSummoner.this.posX;
            entitySmallFireball2.posY = MobDarkenedSummoner.this.posY + (double)(MobDarkenedSummoner.this.height / 2.0F) + 0.5D;
            entitySmallFireball2.posZ = MobDarkenedSummoner.this.posZ;

            MobDarkenedSummoner.this.world.spawnEntity(entitySmallFireball);
            MobDarkenedSummoner.this.world.spawnEntity(entitySmallFireball1);
            MobDarkenedSummoner.this.world.spawnEntity(entitySmallFireball2);
            MobDarkenedSummoner.this.playSound(SoundEvents.ENTITY_GHAST_SHOOT, 1.0F, 1.0F);
            System.out.println("I shot fireball");
        }
        protected void spellPrick(){
            AxisAlignedBB targetbb = MobDarkenedSummoner.this.getEntityBoundingBox().grow(12D);
            List<EntityLivingBase> entities = MobDarkenedSummoner.this.world.getEntitiesWithinAABB(EntityLivingBase.class, targetbb);
            for (EntityLivingBase entity : MobDarkenedSummoner.this.world.getEntitiesWithinAABB(EntityLivingBase.class, targetbb)) {
                if (entity instanceof EntityPlayer) {
                    EntitySummonerSpike summonerSpike = new EntitySummonerSpike(MobDarkenedSummoner.this.world, ((EntityPlayer) entity).posX,  ((EntityPlayer) entity).posY - 0.5, ((EntityPlayer) entity).posZ, 0F, 0, livingBase1);
                    MobDarkenedSummoner.this.world.spawnEntity(summonerSpike);
                    MobDarkenedSummoner.this.playSound(SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0F, 1.0F);
                }
            }
            System.out.println("Prick!");
        }

        @Override
        public boolean shouldExecute() {
            if (MobDarkenedSummoner.this.getAttackTarget() == null) {
                return false;
            } else {
                return MobDarkenedSummoner.this.ticksExisted >= this.spellCooldown;
            }
        }
    }
}
