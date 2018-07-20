package litewolf101.wuffysmagicmayhem.objects.mobs.render;

import litewolf101.wuffysmagicmayhem.objects.mobs.MobDarkenedSummoner;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;

/**
 * Created by LiteWolf101 on 7/13/2018.
 */
public class LayerSummonerWisp implements LayerRenderer<MobDarkenedSummoner> {
    private final RenderDarkenedSummoner summonerRenderer;
    private ResourceLocation mobTexture = new ResourceLocation("wuffysmagicmayhem:textures/entity/darkened_summoner.png");

    public LayerSummonerWisp(RenderDarkenedSummoner summonerRendererIn) {
        this.summonerRenderer = summonerRendererIn;
    }

    @Override
    public void doRenderLayer(MobDarkenedSummoner entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        summonerRenderer.bindTexture(mobTexture);
        GlStateManager.enableBlendProfile(GlStateManager.Profile.TRANSPARENT_MODEL);
        summonerRenderer.getMainModel().render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        GlStateManager.disableBlendProfile(GlStateManager.Profile.TRANSPARENT_MODEL);
    }

    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
}
