package litewolf101.wuffysmagicmayhem.handlers;

import litewolf101.wuffysmagicmayhem.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

/**
 * Created by Ethan Migit on 5/14/2018.
 */
public class WMMSoundHandler {

    public static SoundEvent TOTEM_HIT;

    public static void init(){
        TOTEM_HIT = registerSounds("block.totem_top.totem_hit");
    }

    private static SoundEvent registerSounds(String name){
        ResourceLocation location = new ResourceLocation(Reference.MODID, name);
        SoundEvent e = new SoundEvent(location);
        e.setRegistryName(name);
        ForgeRegistries.SOUND_EVENTS.register(e);
        return e;
    }
}
