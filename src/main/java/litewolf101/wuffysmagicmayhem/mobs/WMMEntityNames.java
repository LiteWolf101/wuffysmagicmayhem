package litewolf101.wuffysmagicmayhem.mobs;

import litewolf101.wuffysmagicmayhem.Reference;
import net.minecraft.util.ResourceLocation;

/**
 * Created by LiteWolf101 on 6/28/2018.
 */
public class WMMEntityNames {

    public static final ResourceLocation FLOATING_STAR = name("floating_star");

    private static ResourceLocation name(String entityName) {
        return new ResourceLocation(Reference.MODID, entityName);
    }
}
