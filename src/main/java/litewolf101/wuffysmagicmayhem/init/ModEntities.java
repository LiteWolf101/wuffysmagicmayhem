package litewolf101.wuffysmagicmayhem.init;

import litewolf101.wuffysmagicmayhem.WuffysMagicMayhem;
import litewolf101.wuffysmagicmayhem.objects.mobs.*;
import litewolf101.wuffysmagicmayhem.objects.mobs.render.RenderDarkenedKnight;
import litewolf101.wuffysmagicmayhem.objects.mobs.render.RenderDarkenedSummoner;
import litewolf101.wuffysmagicmayhem.objects.mobs.render.RenderFloatingStar;
import litewolf101.wuffysmagicmayhem.objects.mobs.render.RenderSummonerSpike;
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
        EntityRegistry.registerModEntity(WMMEntityNames.DARKENED_KNIGHT, MobDarkenedKnight.class, "darkened_knight", id++, WuffysMagicMayhem.instance, 64, 3, true, 9875402, 7569292);
        EntityRegistry.registerModEntity(WMMEntityNames.DARKENED_SUMMONER, MobDarkenedSummoner.class, "darkened_summoner", id++, WuffysMagicMayhem.instance, 64, 3, true, 4403727, 9431295);
        EntityRegistry.registerModEntity(WMMEntityNames.SUMMONER_SPIKE, EntitySummonerSpike.class, "summoner_spike", id++, WuffysMagicMayhem.instance, 64, 3, true);

        EntityRegistry.addSpawn(MobFloatingStar.class, 100, 1, 1, EnumCreatureType.AMBIENT, WMMWorldUtils.biomeStarlight);
    }

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        RenderingRegistry.registerEntityRenderingHandler(MobFloatingStar.class, RenderFloatingStar.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(MobDarkenedKnight.class, RenderDarkenedKnight.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(MobDarkenedSummoner.class, RenderDarkenedSummoner.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntitySummonerSpike.class, RenderSummonerSpike.FACTORY);
    }
}
