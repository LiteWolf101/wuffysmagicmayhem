package litewolf101.wuffysmagicmayhem.objects.mobs;

import litewolf101.wuffysmagicmayhem.utils.handlers.WMMSoundHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.UUID;

/**
 * Created by LiteWolf101 on 7/14/2018.
 */
public class EntitySummonerSpike extends Entity {
    private int warmupDelayTicks;
    private boolean sentSpikeEvent;
    private int lifeTicks;
    private boolean clientSideAttackStarted;
    private EntityLivingBase caster;
    private UUID casterUuid;

    public EntitySummonerSpike(World worldIn) {
        super(worldIn);
        this.lifeTicks = 30;
        this.setSize(0.5F, 0.8F);
    }

    public EntitySummonerSpike(World world, double x, double y, double z, float rotationYaw, int delay, EntityLivingBase caster) {
        this(world);
        this.warmupDelayTicks = delay;
        this.setCaster(caster);
        this.rotationYaw = rotationYaw * (180F / (float)Math.PI);
        this.setPosition(x, y, z);
    }

    @Override
    protected void entityInit() {
    }

    public void setCaster(@Nullable EntityLivingBase entity) {
        this.caster = entity;
        this.casterUuid = entity == null ? null : entity.getUniqueID();
    }

    @Nullable
    public EntityLivingBase getCaster() {
        if (this.caster == null && this.casterUuid != null && this.world instanceof WorldServer)
        {
            Entity entity = ((WorldServer)this.world).getEntityFromUuid(this.casterUuid);

            if (entity instanceof EntityLivingBase)
            {
                this.caster = (EntityLivingBase)entity;
            }
        }

        return this.caster;
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound compound) {
        this.warmupDelayTicks = compound.getInteger("Warmup");
        this.casterUuid = compound.getUniqueId("OwnerUUID");
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound compound) {
        compound.setInteger("Warmup", this.warmupDelayTicks);

        if (this.casterUuid != null) {
            compound.setUniqueId("OwnerUUID", this.casterUuid);
        }
    }

    @Override
    public void onUpdate() {
        super.onUpdate();

        if (this.world.isRemote)
        {
            if (this.clientSideAttackStarted)
            {
                --this.lifeTicks;

                if (this.lifeTicks == 14)
                {
                    for (int i = 0; i < 12; ++i)
                    {
                        double d0 = this.posX + (this.rand.nextDouble() * 2.0D - 1.0D) * (double)this.width * 0.5D;
                        double d1 = this.posY + 0.05D + this.rand.nextDouble() * 1.0D;
                        double d2 = this.posZ + (this.rand.nextDouble() * 2.0D - 1.0D) * (double)this.width * 0.5D;
                        double d3 = (this.rand.nextDouble() * 2.0D - 1.0D) * 0.3D;
                        double d4 = 0.3D + this.rand.nextDouble() * 0.3D;
                        double d5 = (this.rand.nextDouble() * 2.0D - 1.0D) * 0.3D;
                        this.world.spawnParticle(EnumParticleTypes.CRIT, d0, d1 + 1.0D, d2, d3, d4, d5);
                    }
                }
            }
        }
        else if (--this.warmupDelayTicks < 0)
        {
            if (this.warmupDelayTicks == -8)
            {
                for (EntityLivingBase entitylivingbase : this.world.getEntitiesWithinAABB(EntityLivingBase.class, this.getEntityBoundingBox().grow(0.2D, 0.0D, 0.2D)))
                {
                    this.damage(entitylivingbase);
                }
            }

            if (!this.sentSpikeEvent)
            {
                this.world.setEntityState(this, (byte)4);
                this.sentSpikeEvent = true;
            }

            if (--this.lifeTicks < 0)
            {
                this.setDead();
            }
        }
    }

    private void damage(EntityLivingBase entity)
    {
        EntityLivingBase entitylivingbase = this.getCaster();

        if (entity.isEntityAlive() && !entity.getIsInvulnerable() && entity != entitylivingbase)
        {
            if (entitylivingbase == null)
            {
                entity.attackEntityFrom(DamageSource.MAGIC, 6.0F);
            }
            else
            {
                if (entitylivingbase.isOnSameTeam(entity))
                {
                    return;
                }

                entity.attackEntityFrom(DamageSource.causeIndirectMagicDamage(this, entitylivingbase), 6.0F);
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void handleStatusUpdate(byte id) {
        super.handleStatusUpdate(id);

        if (id == 4)
        {
            this.clientSideAttackStarted = true;

            if (!this.isSilent())
            {
                this.world.playSound(this.posX, this.posY, this.posZ, WMMSoundHandler.ENTITY_SUMMONER_SPIKE, SoundCategory.HOSTILE, 0.7F, 1.0F, false);
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public float getAnimationProgress(float time)
    {
        if (!this.clientSideAttackStarted)
        {
            return 0.0F;
        }
        else
        {
            int i = this.lifeTicks - 2;
            return i <= 0 ? 1.0F : 1.0F - ((float)i - time) / 20.0F;
        }
    }
}
