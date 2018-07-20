package litewolf101.wuffysmagicmayhem.utils.client.wmmgui;

import litewolf101.wuffysmagicmayhem.utils.Reference;
import litewolf101.wuffysmagicmayhem.utils.client.wmmgui.buttons.*;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

import java.awt.*;
import java.io.IOException;

/**
 * Created by LiteWolf101 on 6/8/2018.
 */
public class GUIItemBookIndex extends GuiScreen {
    private int guix = 256;
    private int guiy = 256;
    public static ResourceLocation textureBookIndex1 = new ResourceLocation(Reference.MODID + ":textures/gui/item/book_index_gui.png");

    public GUIItemBookIndex() {
        super();
    }

    @Override
    public void initGui() {
        this.buttonList.add(new GuiButton(0, this.width / 2 - 24, this.guiy - 228, 48, 20, "Blocks"));
        this.buttonList.add(new GuiButton(1, this.width / 2 - 24, this.guiy - 206, 48, 20, "Items"));
        this.buttonList.add(new GuiButton(2, this.width / 2 - 24, this.guiy - 184, 48, 20, "Mobs"));
        this.buttonList.add(new GuiButton(3, this.width / 2 - 24, this.guiy - 162, 48, 20, "Biomes"));
        super.initGui();
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    @Override
    public void drawDefaultBackground() {

        int fromleft = (this.width - 256) / 2;
        int fromtop = 0;
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        mc.getTextureManager().bindTexture(textureBookIndex1);
        this.drawTexturedModalRect(fromleft, fromtop, 0, 0, this.guix, this.guiy);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        int fromleft = (this.width - 256) / 2;
        int fromtop = 64;
        drawDefaultBackground();
        drawCenteredString(fontRenderer, ("Index Information WIP"), (width / 2), (guiy - 250), 13339391);
        super.drawScreen(mouseX, mouseY, partialTicks);
        //draw hovering text over button

    }

    @Override
    public void drawCenteredString(FontRenderer fontRendererIn, String text, int x, int y, int color) {
        int textWidth = fontRendererIn.getStringWidth(text);
        int colorBg = new Color(0, 0, 0, 0).getRGB();
        int spacing = fontRendererIn.FONT_HEIGHT / 4;
        int posLeft = x - (textWidth / 2);
        drawRect(posLeft - spacing, y - spacing, posLeft + textWidth + (2 * spacing), y + fontRendererIn.FONT_HEIGHT + (2 * spacing), colorBg);
        fontRenderer.drawString(text, posLeft + 1, y + 1, color);
    }

    //public void drawPageInfo(){
    //    this.drawCenteredString(fontRenderer, "Test", width / 2, height / 2, 0);
    //    System.out.println("Run");
    //}

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        this.buttonList.clear();
        //Main Menu
        if(button.id == 0){
            System.out.println("Clicked Blocks");
            this.buttonList.add(new ButtonHome(4, this.width / 2 - 8, this.height - 20));
            //this.buttonList.add(new ButtonItemRendered(9, this.width / 2 - 8, this.height - 50));
        }
        if(button.id == 1){
            System.out.println("Clicked Items");
            this.buttonList.add(new ButtonHome(4, this.width / 2 - 8, this.height - 20));
        }
        if(button.id == 2){
            System.out.println("Clicked Mobs");
            this.buttonList.add(new ButtonHome(4, this.width / 2 - 8, this.height - 20));
        }
        if(button.id == 3){
            System.out.println("Clicked Biomes");
            this.buttonList.add(new ButtonHome(4, this.width / 2 - 8, this.height - 20));
            this.buttonList.add(new ButtonBiomeDarken(5, this.width / 2 - 72, this.height - 200));
            this.buttonList.add(new ButtonBiomeEnchanted(6, this.width / 2 - 72, this.height - 174));
            this.buttonList.add(new ButtonBiomeStarlight(7, this.width / 2 - 72, this.height - 148));
            this.buttonList.add(new ButtonBiomeSmoldered(8, this.width / 2 - 72, this.height - 122));
        }
        if(button.id == 4){
            System.out.println("Clicked Home");
            this.buttonList.add(new GuiButton(0, this.width / 2 - 24, this.guiy - 228, 48, 20, "Blocks"));
            this.buttonList.add(new GuiButton(1, this.width / 2 - 24, this.guiy - 206, 48, 20, "Items"));
            this.buttonList.add(new GuiButton(2, this.width / 2 - 24, this.guiy - 184, 48, 20, "Mobs"));
            this.buttonList.add(new GuiButton(3, this.width / 2 - 24, this.guiy - 162, 48, 20, "Biomes"));
        }
        //Biomes
        if(button.id == 5){
            System.out.println("Clicked Biome Darken");
            this.buttonList.add(new ButtonHome(4, this.width / 2 - 8, this.height - 20));
            this.buttonList.add(new ButtonPrevious(10, this.width / 2 - 25, this.height - 20 ));

        }
        if(button.id == 6){
            System.out.println("Clicked Biome Enchanted");
            this.buttonList.add(new ButtonHome(4, this.width / 2 - 8, this.height - 20));
            this.buttonList.add(new ButtonPrevious(10, this.width / 2 - 25, this.height - 20 ));
        }
        if(button.id == 7){
            System.out.println("Clicked Biome Starlight");
            this.buttonList.add(new ButtonHome(4, this.width / 2 - 8, this.height - 20));
            this.buttonList.add(new ButtonPrevious(10, this.width / 2 - 25, this.height - 20 ));
        }
        if(button.id == 8){
            System.out.println("Clicked Biome Smoldered");
            this.buttonList.add(new ButtonHome(4, this.width / 2 - 8, this.height - 20));
            this.buttonList.add(new ButtonPrevious(10, this.width / 2 - 25, this.height - 20 ));
        }
        if(button.id == 10){
            System.out.println("Clicked Previous from Biome");
            this.buttonList.add(new ButtonHome(4, this.width / 2 - 8, this.height - 20));
            this.buttonList.add(new ButtonBiomeDarken(5, this.width / 2 - 72, this.height - 200));
            this.buttonList.add(new ButtonBiomeEnchanted(6, this.width / 2 - 72, this.height - 174));
            this.buttonList.add(new ButtonBiomeStarlight(7, this.width / 2 - 72, this.height - 148));
            this.buttonList.add(new ButtonBiomeSmoldered(8, this.width / 2 - 72, this.height - 122));
        }
    }
}
