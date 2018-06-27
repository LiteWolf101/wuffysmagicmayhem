package litewolf101.wuffysmagicmayhem.handlers;

import litewolf101.wuffysmagicmayhem.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

/**
 * Created by LiteWolf101 on 5/14/2018.
 */
public class WMMSoundHandler {

    public static SoundEvent TOTEM_HIT;
    public static SoundEvent WMM_RECORD_WIZARD;

    public static void init(){
        TOTEM_HIT = registerSounds("block.totem_top.totem_hit");
        WMM_RECORD_WIZARD = registerSounds("record.epic_wizards");
    }

    private static SoundEvent registerSounds(String name){
        ResourceLocation location = new ResourceLocation(Reference.MODID, name);
        SoundEvent e = new SoundEvent(location);
        e.setRegistryName(name);
        ForgeRegistries.SOUND_EVENTS.register(e);
        return e;
    }
}
