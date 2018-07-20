package litewolf101.wuffysmagicmayhem.objects.mobs.render;

import litewolf101.wuffysmagicmayhem.objects.mobs.MobFloatingStar;
import litewolf101.wuffysmagicmayhem.objects.mobs.model.ModelFloatingStar;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

/**
 * Created by LiteWolf101 on 6/27/2018.
 */
public class RenderFloatingStar extends RenderLiving<MobFloatingStar> {
    private ResourceLocation mobTexture = new ResourceLocation("wuffysmagicmayhem:textures/entity/star_texture.png");
    public static final IRenderFactory FACTORY = new Factory();

    public RenderFloatingStar(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelFloatingStar(), 0.5F);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(MobFloatingStar entity) {
        return mobTexture;
    }

    public static class Factory implements IRenderFactory<MobFloatingStar> {

        @Override
        public Render<? super MobFloatingStar> createRenderFor(RenderManager manager) {
            return new RenderFloatingStar(manager, new ModelFloatingStar(), 0.5F) {
            };
        }
    }
}
