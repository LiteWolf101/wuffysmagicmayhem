package litewolf101.wuffysmagicmayhem.objects.mobs.render;

import litewolf101.wuffysmagicmayhem.objects.mobs.EntitySummonerSpike;
import litewolf101.wuffysmagicmayhem.objects.mobs.model.ModelSummonerSpike;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

/**
 * Created by LiteWolf101 on 7/14/2018.
 */
public class RenderSummonerSpike extends Render<EntitySummonerSpike> {
    private ResourceLocation mobTexture = new ResourceLocation("wuffysmagicmayhem:textures/entity/summoner_spike.png");
    public static final IRenderFactory FACTORY = new Factory();
    private final ModelSummonerSpike model = new ModelSummonerSpike();

    protected RenderSummonerSpike(RenderManager rendermanagerIn, ModelBase modelBaseIn) {
        super(rendermanagerIn);
    }

    @Override
    public void doRender(EntitySummonerSpike entity, double x, double y, double z, float entityYaw, float partialTicks) {
        float f = entity.getAnimationProgress(partialTicks);

        if (f != 0.0F) {
            float f1 = 2.0F;

            if (f > 0.9F) {
                f1 = (float) ((double) f1 * ((1.0D - (double) f) / 0.10000000149011612D));
            }

            GlStateManager.pushMatrix();
            GlStateManager.disableCull();
            GlStateManager.enableAlpha();
            this.bindEntityTexture(entity);
            GlStateManager.translate((float) x, (float) y, (float) z);
            GlStateManager.rotate(90.0F - entity.rotationYaw, 0.0F, 1.0F, 0.0F);
            GlStateManager.scale(-f1, -f1, f1);
            float f2 = 0.03125F;
            GlStateManager.translate(0.0F, -0.626F, 0.0F);
            this.model.render(entity, f, 0.0F, 0.0F, entity.rotationYaw, entity.rotationPitch, 0.03125F);
            GlStateManager.popMatrix();
            GlStateManager.enableCull();
            super.doRender(entity, x, y, z, entityYaw, partialTicks);
        }
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntitySummonerSpike entity) {
        return mobTexture;
    }

    public static class Factory implements IRenderFactory<EntitySummonerSpike> {

        @Override
        public Render<? super EntitySummonerSpike> createRenderFor(RenderManager manager) {
            return new RenderSummonerSpike(manager, new ModelSummonerSpike()) {
            };
        }
    }
}
