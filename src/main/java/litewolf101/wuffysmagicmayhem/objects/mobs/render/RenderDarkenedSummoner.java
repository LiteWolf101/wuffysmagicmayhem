package litewolf101.wuffysmagicmayhem.objects.mobs.render;

import litewolf101.wuffysmagicmayhem.objects.mobs.MobDarkenedSummoner;
import litewolf101.wuffysmagicmayhem.objects.mobs.model.ModelDarkenedSummoner;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

/**
 * Created by LiteWolf101 on 7/13/2018.
 */
public class RenderDarkenedSummoner extends RenderLiving<MobDarkenedSummoner> {
    private ResourceLocation mobTexture = new ResourceLocation("wuffysmagicmayhem:textures/entity/darkened_summoner.png");
    public static final IRenderFactory FACTORY = new RenderDarkenedSummoner.Factory();

    public RenderDarkenedSummoner(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelDarkenedSummoner(), 0.5F);
    }
    //TODO: Incorrect rendering for blending alpha on model textures?
    /**Is it a good idea to have GL methods in the model class?
    * @see ModelDarkenedSummoner
    * */



    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(MobDarkenedSummoner entity) {
        return mobTexture;
    }

    public static class Factory implements IRenderFactory<MobDarkenedSummoner> {

        @Override
        public Render<? super MobDarkenedSummoner> createRenderFor(RenderManager manager) {
            return new RenderDarkenedSummoner(manager, new ModelDarkenedSummoner(), 0.5F) {
            };
        }
    }

    @Override
    public void doRender(MobDarkenedSummoner entity, double x, double y, double z, float entityYaw, float partialTicks) {
        if(entity.isCasting){super.doRender(entity, x, y, z, entityYaw, partialTicks);}
    }
}
