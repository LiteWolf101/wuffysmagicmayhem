package litewolf101.wuffysmagicmayhem.init;

import litewolf101.wuffysmagicmayhem.WuffysMagicMayhem;
import litewolf101.wuffysmagicmayhem.mobs.MobFloatingStar;
import litewolf101.wuffysmagicmayhem.mobs.WMMEntityNames;
import litewolf101.wuffysmagicmayhem.mobs.render.RenderFloatingStar;
import litewolf101.wuffysmagicmayhem.world.biomes.WMMWorldUtils;
import net.minecraft.entity.EnumCreatureType;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by LiteWolf101 on 6/16/2018.
 */
public class ModEntities {
    public static void init() {
        int id = 1;
        EntityRegistry.registerModEntity(WMMEntityNames.FLOATING_STAR, MobFloatingStar.class, "floating_star", id++, WuffysMagicMayhem.instance, 64, 3, true, 16777215, 16776652);

        EntityRegistry.addSpawn(MobFloatingStar.class, 100, 1, 1, EnumCreatureType.AMBIENT, WMMWorldUtils.biomeStarlight);
    }

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        RenderingRegistry.registerEntityRenderingHandler(MobFloatingStar.class, RenderFloatingStar.FACTORY);
    }
}
