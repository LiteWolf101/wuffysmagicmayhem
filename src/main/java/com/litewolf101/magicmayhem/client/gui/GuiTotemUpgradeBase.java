package com.litewolf101.magicmayhem.client.gui;

import com.litewolf101.magicmayhem.container.ContainerTotemUpgradeBase;
import com.litewolf101.magicmayhem.tile.TileEntityTotemUpgradeBase;
import com.litewolf101.magicmayhem.util.Constants;
import de.kitsunealex.silverfish.client.gui.GuiContainerBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiTotemUpgradeBase extends GuiContainerBase<TileEntityTotemUpgradeBase, ContainerTotemUpgradeBase> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Constants.MODID, "textures/gui/totem_upgrade_base.png");

    public GuiTotemUpgradeBase(InventoryPlayer inventoryPlayer, TileEntityTotemUpgradeBase tile) {
        super(inventoryPlayer, tile, new ContainerTotemUpgradeBase(inventoryPlayer, tile));
        xSize = 176;
        ySize = 166;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.pushMatrix();
        mc.getTextureManager().bindTexture(TEXTURE);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
        GlStateManager.popMatrix();
    }

}
