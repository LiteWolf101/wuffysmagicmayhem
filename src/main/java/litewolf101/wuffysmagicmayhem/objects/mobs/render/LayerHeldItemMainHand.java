package litewolf101.wuffysmagicmayhem.objects.mobs.render;

import litewolf101.wuffysmagicmayhem.objects.mobs.MobDarkenedKnight;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

/**
 * Created by LiteWolf101 on 7/12/2018.
 */
public class LayerHeldItemMainHand implements LayerRenderer<MobDarkenedKnight> {
    private final RenderDarkenedKnight renderDarkenedKnight;

    public LayerHeldItemMainHand(RenderDarkenedKnight renderDarkenedKnightIn) {
        renderDarkenedKnight = renderDarkenedKnightIn;
    }

    @Override
    public void doRenderLayer(MobDarkenedKnight entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        ItemStack stack = entitylivingbaseIn.getHeldItemMainhand();

        if(stack != null) {
            if(stack.getItem() == Items.DIAMOND_SWORD)
            GlStateManager.enableRescaleNormal();
            GlStateManager.pushMatrix();
            GlStateManager.translate(-0.35F, 0.65F + -0.0F, -0.6F);
            GlStateManager.rotate(-155.0F, 250.0F, 40.0F, -205.0F);
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            Minecraft.getMinecraft().getItemRenderer().renderItem(entitylivingbaseIn, new ItemStack(Items.DIAMOND_SWORD), ItemCameraTransforms.TransformType.NONE);
            GlStateManager.popMatrix();
            GlStateManager.disableRescaleNormal();
        }
    }

    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
}
