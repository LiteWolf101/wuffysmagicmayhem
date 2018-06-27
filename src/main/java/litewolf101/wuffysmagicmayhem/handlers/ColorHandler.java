package litewolf101.wuffysmagicmayhem.handlers;

import litewolf101.wuffysmagicmayhem.init.ModBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.item.ItemBlock;
import net.minecraft.world.ColorizerFoliage;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by LiteWolf101 on 6/19/2018.
 */
@SideOnly(Side.CLIENT)
public final class ColorHandler {
    public static void init(){
        BlockColors blockColors = Minecraft.getMinecraft().getBlockColors();
        blockColors.registerBlockColorHandler((state, worldIn, pos, tintIndex) -> {
            if (tintIndex > 15) return 0xFFFFFF;

            if (worldIn == null || pos == null) {
                return ColorizerFoliage.getFoliageColorBasic();
            }

            int red = 0;
            int grn = 0;
            int blu = 0;

            for (int dz = -1; dz <= 1; ++dz) {
                for (int dx = -1; dx <= 1; ++dx) {
                    int i2 = worldIn.getBiome(pos.add(dx, 0, dz)).getFoliageColorAtPos(pos.add(dx, 0, dz));
                    red += (i2 & 16711680) >> 16;
                    grn += (i2 & 65280) >> 8;
                    blu += i2 & 255;
                }
            }

            return (red / 9 & 255) << 16 | (grn / 9 & 255) << 8 | blu / 9 & 255;
        }, ModBlocks.strangeGrass, ModBlocks.shimmeringGrass);
        ItemColors itemColors = Minecraft.getMinecraft().getItemColors();
        itemColors.registerItemColorHandler((stack, tintIndex) -> blockColors.colorMultiplier(((ItemBlock)stack.getItem()).getBlock().getStateFromMeta(stack.getMetadata()), null, null, tintIndex),ModBlocks.strangeGrass, ModBlocks.shimmeringGrass);
    }
    private ColorHandler() {
    }
}
