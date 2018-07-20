package litewolf101.wuffysmagicmayhem.objects.mobs.render;

import litewolf101.wuffysmagicmayhem.objects.mobs.MobDarkenedKnight;
import litewolf101.wuffysmagicmayhem.objects.mobs.model.ModelDarkenedKnight;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

/**
 * Created by LiteWolf101 on 7/12/2018.
 */
public class RenderDarkenedKnight extends RenderLiving<MobDarkenedKnight> {
    private ResourceLocation mobTexture = new ResourceLocation("wuffysmagicmayhem:textures/entity/darkened_knight.png");
    public static final IRenderFactory FACTORY = new Factory();
    private final ModelDarkenedKnight modelDarkenedKnight;

    public RenderDarkenedKnight(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelDarkenedKnight(), 0.5F);
        modelDarkenedKnight = (ModelDarkenedKnight) super.mainModel;
        addLayer(new LayerHeldItemMainHand(this));
    }

    @Override
    public void doRender(MobDarkenedKnight entity, double x, double y, double z, float entityYaw, float partialTicks) {
        ItemStack stack = entity.getHeldItemMainhand();
        modelDarkenedKnight.isHolding = stack != null || !stack.isEmpty();
        if (modelDarkenedKnight.isHolding && stack != null){
            modelDarkenedKnight.itemStack = stack;
        }
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(MobDarkenedKnight entity) {
        return mobTexture;
    }

    public static class Factory implements IRenderFactory<MobDarkenedKnight> {

        @Override
        public Render<? super MobDarkenedKnight> createRenderFor(RenderManager manager) {
            return new RenderDarkenedKnight(manager, new ModelDarkenedKnight(), 0.5F);
        }
    }

}
