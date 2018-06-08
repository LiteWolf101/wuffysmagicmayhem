package litewolf101.wuffysmagicmayhem.init;

import litewolf101.wuffysmagicmayhem.Reference;
import litewolf101.wuffysmagicmayhem.WuffysMagicMayhem;
import litewolf101.wuffysmagicmayhem.items.*;
import litewolf101.wuffysmagicmayhem.handlers.EnumHandler;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by LiteWolf101 on 11/17/2017.
 */
@Mod.EventBusSubscriber(modid = Reference.MODID)
public class ModItems {

	public static Item darkInfusedSapling;
	public static Item bubbleShroom;
	public static Item wmmPowerUpgrade;
	public static Item wmmRangeUpgrade;
	public static Item wmmSpeedUpgrade;
	public static Item bookSpecial;
	public static Item bookIndex;

	public static void init() {
		darkInfusedSapling = new DarkInfusedSapling("dark_infused_sapling").setMaxStackSize(64).setCreativeTab(WuffysMagicMayhem.CREATIVE_TAB);
		bubbleShroom = new ItemBubbleshroom("bubbleshroom");
		wmmPowerUpgrade = new ItemPowerUpgrade("wmm_power_upgrade").setCreativeTab(WuffysMagicMayhem.CREATIVE_TAB);
		wmmRangeUpgrade = new ItemRangeUpgrade("wmm_range_upgrade").setCreativeTab(WuffysMagicMayhem.CREATIVE_TAB);
		wmmSpeedUpgrade = new ItemSpeedUpgrade("wmm_speed_upgrade").setCreativeTab(WuffysMagicMayhem.CREATIVE_TAB);
		bookSpecial = new ItemBookSpecial("wmm_book_special").setCreativeTab(WuffysMagicMayhem.CREATIVE_TAB);
		bookIndex = new ItemBookIndex("wmm_book_index").setCreativeTab(WuffysMagicMayhem.CREATIVE_TAB);
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(darkInfusedSapling);
		event.getRegistry().registerAll(bubbleShroom);
		event.getRegistry().registerAll(wmmPowerUpgrade);
		event.getRegistry().registerAll(wmmRangeUpgrade);
		event.getRegistry().registerAll(wmmSpeedUpgrade);
		event.getRegistry().registerAll(bookSpecial);
		event.getRegistry().registerAll(bookIndex);
	}

	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event) {
		registerRender(darkInfusedSapling);
		for (int i = 0; i < EnumHandler.BubbleshroomType.values().length; i++) {
			registerRender(bubbleShroom, i, "bubbleshroom" + EnumHandler.BubbleshroomType.values()[i].getName());
		}
		registerRender(wmmPowerUpgrade);
		registerRender(wmmRangeUpgrade);
		registerRender(wmmSpeedUpgrade);
		registerRender(bookSpecial);
		registerRender(bookIndex);
	}

	private static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}

	private static void registerRender(Item item, int meta, String fileName) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(new ResourceLocation(Reference.MODID, fileName), "inventory"));
	}

}
