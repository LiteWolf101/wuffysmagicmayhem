package litewolf101.wuffysmagicmayhem.utils.client.fx;

import net.minecraft.client.particle.ParticleDragonBreath;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Created by LiteWolf101 on 6/27/2018.
 */
public class ParticleShimmeringGrass extends ParticleDragonBreath{

    public ParticleShimmeringGrass(World worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double p_i1229_8_, double ySpeed, double p_i1229_12_) {
        super(worldIn, xCoordIn, yCoordIn, zCoordIn, p_i1229_8_, ySpeed, p_i1229_12_);
        this.setRBGColorF(0.7F, 1.0F, 0.1F);
        this.motionY = 0.01467218D;
        this.particleGravity = 1.0F;
    }

    public int getBrightnessForRender(float p_189214_1_)
    {
        BlockPos blockpos = new BlockPos(this.posX, this.posY, this.posZ);
        return this.world.isBlockLoaded(blockpos) ? this.world.getCombinedLight(blockpos, 15) : 15;
    }

    @Override
    public void renderParticle(BufferBuilder buffer, Entity entityIn, float partialTicks, float rotationX, float rotationZ, float rotationYZ, float rotationXY, float rotationXZ) {
        super.renderParticle(buffer, entityIn, partialTicks, rotationX, rotationZ, rotationYZ, rotationXY, rotationXZ);
        getBrightnessForRender(1.0F);
    }
}
