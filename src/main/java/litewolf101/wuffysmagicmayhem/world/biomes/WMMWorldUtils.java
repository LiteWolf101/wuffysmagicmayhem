package litewolf101.wuffysmagicmayhem.world.biomes;

import litewolf101.wuffysmagicmayhem.utils.Reference;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

/**
 * Created by LiteWolf101 on 6/16/2018.
 */
@Mod.EventBusSubscriber(modid = Reference.MODID)
public final class WMMWorldUtils {
    public static final BiomeStarlight biomeStarlight = new BiomeStarlight();
    public static final BiomeDarkened biomeDarkened = new BiomeDarkened();
    public static final BiomeEnchanted biomeEnchanted = new BiomeEnchanted();
    public static final BiomeSmoldered biomeSmoldered = new BiomeSmoldered();

    @SubscribeEvent
    public static void registerBiomes(RegistryEvent.Register<Biome> event) {
        IForgeRegistry<Biome> registry = event.getRegistry();

        registry.register(biomeStarlight);
        registry.register(biomeDarkened);
        registry.register(biomeEnchanted);
        registry.register(biomeSmoldered);

        BiomeDictionary.addTypes(biomeStarlight, BiomeDictionary.Type.FOREST);
        BiomeDictionary.addTypes(biomeDarkened, BiomeDictionary.Type.MAGICAL);
        BiomeDictionary.addTypes(biomeEnchanted, BiomeDictionary.Type.CONIFEROUS);
        BiomeDictionary.addTypes(biomeSmoldered, BiomeDictionary.Type.NETHER);

        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(biomeStarlight, 1000));
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(biomeDarkened, 1000));
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(biomeEnchanted, 1000));
        BiomeManager.addBiome(BiomeManager.BiomeType.DESERT, new BiomeManager.BiomeEntry(biomeSmoldered, 1000));


        BiomeManager.addSpawnBiome(biomeStarlight);
        BiomeManager.addSpawnBiome(biomeDarkened);
        BiomeManager.addSpawnBiome(biomeEnchanted);
        BiomeManager.addSpawnBiome(biomeSmoldered);

        BiomeProvider.allowedBiomes.add(biomeStarlight);
        BiomeProvider.allowedBiomes.add(biomeDarkened);
        BiomeProvider.allowedBiomes.add(biomeEnchanted);
        BiomeProvider.allowedBiomes.add(biomeSmoldered);
    }
}
