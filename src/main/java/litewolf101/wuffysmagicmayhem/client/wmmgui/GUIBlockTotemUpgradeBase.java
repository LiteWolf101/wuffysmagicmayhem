package litewolf101.wuffysmagicmayhem.client.wmmgui;

import litewolf101.wuffysmagicmayhem.Reference;
import litewolf101.wuffysmagicmayhem.container.ContainerBlockTotemUpgradeBase;
import litewolf101.wuffysmagicmayhem.tileentity.TileEntityBlockTotemUpgradeBase;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

/**
 * Created by LiteWolf101 on 5/15/2018.
 */
public class GUIBlockTotemUpgradeBase extends GuiContainer {
    private TileEntityBlockTotemUpgradeBase te;
    private IInventory playerInv;

     public GUIBlockTotemUpgradeBase(IInventory playerInv, TileEntityBlockTotemUpgradeBase te){
        super(new ContainerBlockTotemUpgradeBase(playerInv, te));
        this.te = te;
        this.playerInv = playerInv;
        this.xSize = 176;
        this.ySize = 166;
     }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MODID, "textures/gui/container/totem_upgrade_base_gui.png"));
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String s = I18n.format("container.totem_upgrade_base");
        this.mc.fontRenderer.drawString(s, this.xSize / 2 - this.mc.fontRenderer.getStringWidth(s) / 2, 6, 4210752);
        this.mc.fontRenderer.drawString(this.playerInv.getDisplayName().getFormattedText(), 8, 72, 4210752);
        this.renderHoveredToolTip(mouseX - 125, mouseY - 35);
    }
}
