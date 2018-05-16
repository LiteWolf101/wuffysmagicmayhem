package litewolf101.wuffysmagicmayhem.init;

import litewolf101.wuffysmagicmayhem.Reference;
import litewolf101.wuffysmagicmayhem.WuffysMagicMayhem;
import litewolf101.wuffysmagicmayhem.blocks.*;
import litewolf101.wuffysmagicmayhem.handlers.EnumHandler;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Ethan Migit on 11/17/2017.
 */

@Mod.EventBusSubscriber(modid = Reference.MODID)
public class ModBlocks {

	public static Block darkInfusedWood;
	public static Block starlightWood;
	public static Block enchantedWood;
	public static Block ashenedWood;
	public static Block darkInfusedPlanks;
	public static Block starlightPlanks;
	public static Block enchantedPlanks;
	public static Block ashenedPlanks;
	public static Block darkInfusedLeaves;
	public static Block starlightLeaves;
	public static Block enchantedLeaves;
	public static Block ashenedLeaves;
	public static Block glowFlowers;
	public static Block blockBubbleshroom;
	public static Block totemTop;
	public static Block totemUpgradeBase;

	public static void init() {
		darkInfusedWood = new DarkInfusedWood("dark_infused_wood", Material.WOOD).setHardness(1.0f).setCreativeTab(WuffysMagicMayhem.CREATIVE_TAB).setLightLevel(0.2f);
		darkInfusedWood.setHarvestLevel("axe", 0);

		starlightWood = new StarlightWood("starlight_wood", Material.WOOD).setHardness(1.0f).setCreativeTab(WuffysMagicMayhem.CREATIVE_TAB).setLightLevel(0.2f);
		starlightWood.setHarvestLevel("axe", 0);

		enchantedWood = new EnchantedWood("enchanted_wood", Material.WOOD).setHardness(1.0f).setCreativeTab(WuffysMagicMayhem.CREATIVE_TAB);
		enchantedWood.setHarvestLevel("axe", 0);

		ashenedWood = new AshenedWood("ashened_wood", Material.WOOD).setHardness(1.0f).setCreativeTab(WuffysMagicMayhem.CREATIVE_TAB).setLightLevel(0f);
		ashenedWood.setHarvestLevel("axe", 0);

		darkInfusedPlanks = new DarkInfusedPlanks("dark_infused_planks", Material.WOOD).setHardness(1.0f).setCreativeTab(WuffysMagicMayhem.CREATIVE_TAB).setLightLevel(0f);
		darkInfusedPlanks.setHarvestLevel("axe", 0);

		starlightPlanks = new StarlightPlanks("starlight_planks", Material.WOOD).setHardness(1.0f).setCreativeTab(WuffysMagicMayhem.CREATIVE_TAB).setLightLevel(0f);
		starlightPlanks.setHarvestLevel("axe", 0);

		enchantedPlanks = new EnchantedPlanks("enchanted_planks", Material.WOOD).setHardness(1.0f).setCreativeTab(WuffysMagicMayhem.CREATIVE_TAB).setLightLevel(0f);
		enchantedPlanks.setHarvestLevel("axe", 0);

		ashenedPlanks = new StarlightPlanks("ashened_planks", Material.WOOD).setHardness(1.0f).setCreativeTab(WuffysMagicMayhem.CREATIVE_TAB).setLightLevel(0f);
		ashenedPlanks.setHarvestLevel("axe", 0);

		darkInfusedLeaves = new DarkInfusedLeaves("dark_infused_leaves", Material.LEAVES).setHardness(0.5f).setCreativeTab(WuffysMagicMayhem.CREATIVE_TAB).setLightLevel(1.0f).setLightOpacity(15);

		starlightLeaves = new StarlightLeaves("starlight_leaves", Material.LEAVES).setHardness(0.5f).setCreativeTab(WuffysMagicMayhem.CREATIVE_TAB).setLightLevel(0.4f).setLightOpacity(15);

		enchantedLeaves = new EnchantedLeaves("enchanted_leaves", Material.LEAVES).setHardness(0.5f).setCreativeTab(WuffysMagicMayhem.CREATIVE_TAB).setLightOpacity(15);

		ashenedLeaves = new EnchantedLeaves("ashened_leaves", Material.LEAVES).setHardness(0.5f).setCreativeTab(WuffysMagicMayhem.CREATIVE_TAB).setLightOpacity(15);

		glowFlowers = new GlowFlowers("glow_flowers", Material.GRASS).setCreativeTab(WuffysMagicMayhem.CREATIVE_TAB).setLightOpacity(15);

		blockBubbleshroom = new BlockBubbleshroom("block_bubbleshroom", Material.GRASS).setCreativeTab(WuffysMagicMayhem.CREATIVE_TAB).setLightLevel(0.5f);

		totemTop = new BlockTotemTop("totem_top", Material.ROCK).setCreativeTab(WuffysMagicMayhem.CREATIVE_TAB);

		totemUpgradeBase = new BlockTotemUpgradeBase("totem_upgrade_base", Material.ROCK).setCreativeTab(WuffysMagicMayhem.CREATIVE_TAB);

	}

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().register(darkInfusedWood);
		event.getRegistry().register(starlightWood);
		event.getRegistry().register(enchantedWood);
		event.getRegistry().register(ashenedWood);
		event.getRegistry().register(darkInfusedPlanks);
		event.getRegistry().register(starlightPlanks);
		event.getRegistry().register(enchantedPlanks);
		event.getRegistry().register(ashenedPlanks);
		event.getRegistry().register(darkInfusedLeaves);
		event.getRegistry().register(starlightLeaves);
		event.getRegistry().register(enchantedLeaves);
		event.getRegistry().register(ashenedLeaves);
		event.getRegistry().register(glowFlowers);
		event.getRegistry().register(blockBubbleshroom);
		event.getRegistry().register(totemTop);
		event.getRegistry().register(totemUpgradeBase);

	}

	@SubscribeEvent
	public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(new ItemBlock(darkInfusedWood).setRegistryName(darkInfusedWood.getRegistryName()));
		event.getRegistry().registerAll(new ItemBlock(starlightWood).setRegistryName(starlightWood.getRegistryName()));
		event.getRegistry().registerAll(new ItemBlock(enchantedWood).setRegistryName(enchantedWood.getRegistryName()));
		event.getRegistry().registerAll(new ItemBlock(ashenedWood).setRegistryName(ashenedWood.getRegistryName()));
		event.getRegistry().registerAll(new ItemBlock(darkInfusedPlanks).setRegistryName(darkInfusedPlanks.getRegistryName()));
		event.getRegistry().registerAll(new ItemBlock(starlightPlanks).setRegistryName(starlightPlanks.getRegistryName()));
		event.getRegistry().registerAll(new ItemBlock(enchantedPlanks).setRegistryName(enchantedPlanks.getRegistryName()));
		event.getRegistry().registerAll(new ItemBlock(ashenedPlanks).setRegistryName(ashenedPlanks.getRegistryName()));
		event.getRegistry().registerAll(new ItemBlock(darkInfusedLeaves).setRegistryName(darkInfusedLeaves.getRegistryName()));
		event.getRegistry().registerAll(new ItemBlock(starlightLeaves).setRegistryName(starlightLeaves.getRegistryName()));
		event.getRegistry().registerAll(new ItemBlock(enchantedLeaves).setRegistryName(enchantedLeaves.getRegistryName()));
		event.getRegistry().registerAll(new ItemBlock(ashenedLeaves).setRegistryName(ashenedLeaves.getRegistryName()));
		event.getRegistry().registerAll(new ItemBlock(glowFlowers).setRegistryName(glowFlowers.getRegistryName()));
		event.getRegistry().registerAll(new ItemBlock(blockBubbleshroom).setRegistryName(blockBubbleshroom.getRegistryName()));
		event.getRegistry().registerAll(new ItemBlock(totemTop).setRegistryName(totemTop.getRegistryName()));
		event.getRegistry().registerAll(new ItemBlock(totemUpgradeBase).setRegistryName(totemUpgradeBase.getRegistryName()));
	}

	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event) {
		registerRender(Item.getItemFromBlock(darkInfusedWood));
		registerRender(Item.getItemFromBlock(starlightWood));
		registerRender(Item.getItemFromBlock(enchantedWood));
		registerRender(Item.getItemFromBlock(ashenedWood));
		registerRender(Item.getItemFromBlock(darkInfusedPlanks));
		registerRender(Item.getItemFromBlock(starlightPlanks));
		registerRender(Item.getItemFromBlock(enchantedPlanks));
		registerRender(Item.getItemFromBlock(ashenedPlanks));
		registerRender(Item.getItemFromBlock(darkInfusedLeaves));
		registerRender(Item.getItemFromBlock(starlightLeaves));
		registerRender(Item.getItemFromBlock(enchantedLeaves));
		registerRender(Item.getItemFromBlock(ashenedLeaves));
		registerRender(Item.getItemFromBlock(glowFlowers));
		for (int i = 0; i < EnumHandler.BubbleshroomType.values().length; i++) {
			registerRender(blockBubbleshroom, i, EnumHandler.BubbleshroomType.values()[i].getName() + "_block_bubbleshroom");
		}
		registerRender(Item.getItemFromBlock(totemTop));
		registerRender(Item.getItemFromBlock(totemUpgradeBase));
	}

	public static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
	private static void registerRender(Block block, int meta, String fileName) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta, new ModelResourceLocation(new ResourceLocation(Reference.MODID, fileName), "inventory"));
	}
}
