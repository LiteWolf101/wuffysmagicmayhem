package litewolf101.wuffysmagicmayhem.init;

import litewolf101.wuffysmagicmayhem.Reference;
import litewolf101.wuffysmagicmayhem.items.DarkInfusedSapling;
import litewolf101.wuffysmagicmayhem.handlers.EnumHandler;
import litewolf101.wuffysmagicmayhem.items.ItemBubbleshroom;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by Ethan Migit on 11/17/2017.
 */
@Mod.EventBusSubscriber(modid = Reference.MODID)
public class ModItems {

	public static Item darkInfusedSapling;
	public static Item bubbleShroom;

	public static void init() {
		darkInfusedSapling = new DarkInfusedSapling("dark_infused_sapling");
		darkInfusedSapling = new DarkInfusedSapling("dark_infused_sapling").setMaxStackSize(64);
		bubbleShroom = new ItemBubbleshroom("bubbleshroom");
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(darkInfusedSapling);
		event.getRegistry().registerAll(bubbleShroom);
	}

	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event) {
		registerRender(darkInfusedSapling);
		for (int i = 0; i < EnumHandler.BubbleshroomType.values().length; i++) {
			registerRender(bubbleShroom, i, "bubbleshroom" + EnumHandler.BubbleshroomType.values()[i].getName());
		}
	}

	private static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}

	private static void registerRender(Item item, int meta, String fileName) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(new ResourceLocation(Reference.MODID, fileName), "inventory"));
	}

}
