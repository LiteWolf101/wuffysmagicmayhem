package litewolf101.wuffysmagicmayhem.client.wmmgui;

import litewolf101.wuffysmagicmayhem.Reference;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import java.awt.*;

/**
 * Created by LiteWolf101 on 6/8/2018.
 */
public class GUIItemBookSpecial extends GuiScreen {
    private int guix = 256;
    private int guiy = 128;
    public static ResourceLocation textureBookSpecial = new ResourceLocation(Reference.MODID + ":textures/gui/item/book_special_gui.png");

    public GUIItemBookSpecial() {
        super();
    }

    @Override
    public void initGui() {
        super.initGui();
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    @Override
    public void drawDefaultBackground() {

        int fromleft = (this.width - 256) / 2;
        int fromtop = 64;
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        mc.getTextureManager().bindTexture(textureBookSpecial);
        this.drawTexturedModalRect(fromleft, fromtop, 0, 0, this.guix, this.guiy);


    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        int fromleft = (this.width - 256) / 2;
        int fromtop = 64;
        drawDefaultBackground();
        drawCenteredString(fontRenderer, ("Special Information NYI"), (width / 2), (guiy - 10), 4819438);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public void drawCenteredString(FontRenderer fontRendererIn, String text, int x, int y, int color) {
        int textWidth = fontRendererIn.getStringWidth(text);
        int colorBg = new Color(0, 0, 0, 10).getRGB();
        int spacing = fontRendererIn.FONT_HEIGHT / 4;
        int posLeft = x - (textWidth / 2);
        drawRect(posLeft - spacing, y - spacing, posLeft + textWidth + (2 * spacing), y + fontRendererIn.FONT_HEIGHT + (2 * spacing), colorBg);
        fontRenderer.drawStringWithShadow(text, (float) posLeft + 1, (float) y + 1, color);
    }
}


