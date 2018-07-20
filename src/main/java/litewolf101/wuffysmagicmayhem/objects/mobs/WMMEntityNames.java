package litewolf101.wuffysmagicmayhem.objects.mobs;

import litewolf101.wuffysmagicmayhem.utils.Reference;
import net.minecraft.util.ResourceLocation;

/**
 * Created by LiteWolf101 on 6/28/2018.
 */
public class WMMEntityNames {

    public static final ResourceLocation FLOATING_STAR = name("floating_star");
    public static final ResourceLocation DARKENED_KNIGHT = name("darkened_knight");
    public static final ResourceLocation DARKENED_SUMMONER = name("darkened_summoner");
    public static final ResourceLocation SUMMONER_SPIKE = name("summoner_spike");

    private static ResourceLocation name(String entityName) {
        return new ResourceLocation(Reference.MODID, entityName);
    }
}
