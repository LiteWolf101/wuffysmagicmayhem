package litewolf101.wuffysmagicmayhem.utils.handlers;

import litewolf101.wuffysmagicmayhem.utils.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

/**
 * Created by LiteWolf101 on 5/14/2018.
 */
public class WMMSoundHandler {

    public static SoundEvent TOTEM_HIT;
    public static SoundEvent WMM_RECORD_WIZARD;
    public static SoundEvent ENTITY_FLOATING_STAR_HURT;
    public static SoundEvent ENTITY_FLOATING_STAR_DEATH;
    public static SoundEvent ENTITY_DARKENED_KNIGHT_AMBIENT;
    public static SoundEvent ENTITY_DARKENED_KNIGHT_HURT;
    public static SoundEvent ENTITY_DARKENED_KNIGHT_DEATH;
    public static SoundEvent ENTITY_SUMMONER_SPIKE;

    public static void init(){
        TOTEM_HIT = registerSounds("block.totem_top.totem_hit");
        WMM_RECORD_WIZARD = registerSounds("record.epic_wizards");
        ENTITY_FLOATING_STAR_HURT = registerSounds("entity.floating_star.hurt");
        ENTITY_FLOATING_STAR_DEATH = registerSounds("entity.floating_star.death");
        ENTITY_DARKENED_KNIGHT_AMBIENT = registerSounds("entity.darkened_knight.ambient");
        ENTITY_DARKENED_KNIGHT_HURT = registerSounds("entity.darkened_knight.hurt");
        ENTITY_DARKENED_KNIGHT_DEATH = registerSounds("entity.darkened_knight.death");
        ENTITY_SUMMONER_SPIKE = registerSounds("entity.summoner_spike");
    }

    private static SoundEvent registerSounds(String name){
        ResourceLocation location = new ResourceLocation(Reference.MODID, name);
        SoundEvent e = new SoundEvent(location);
        e.setRegistryName(name);
        ForgeRegistries.SOUND_EVENTS.register(e);
        return e;
    }
}
