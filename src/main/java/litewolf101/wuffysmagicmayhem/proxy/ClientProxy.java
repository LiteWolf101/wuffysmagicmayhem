package litewolf101.wuffysmagicmayhem.proxy;

import litewolf101.wuffysmagicmayhem.Reference;
import litewolf101.wuffysmagicmayhem.WuffysMagicMayhem;
import litewolf101.wuffysmagicmayhem.client.wmmgui.GUIHandler;
import litewolf101.wuffysmagicmayhem.handlers.ColorHandler;
import litewolf101.wuffysmagicmayhem.handlers.WMMSoundHandler;
import litewolf101.wuffysmagicmayhem.init.ModBlocks;
import litewolf101.wuffysmagicmayhem.init.ModItems;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

/**
 * Created by LiteWolf101 on 11/16/2017.
 */
public class ClientProxy extends CommonProxy {

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);

	}

	@Override
	public void init(FMLInitializationEvent event) {
		WMMSoundHandler.init();
		ColorHandler.init();
		NetworkRegistry.INSTANCE.registerGuiHandler(WuffysMagicMayhem.instance, new GUIHandler());
	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {
	}

	@Override
	public void registerModelBakeryStuff() {
		ModelBakery.registerItemVariants(ModItems.bubbleShroom, new ResourceLocation(Reference.MODID, "bubbleshroom_gray"), new ResourceLocation(Reference.MODID, "bubbleshroom_blue"), new ResourceLocation(Reference.MODID, "bubbleshroom_green"), new ResourceLocation(Reference.MODID, "bubbleshroom_pink"));
		ModelBakery.registerItemVariants(Item.getItemFromBlock(ModBlocks.blockBubbleshroom), new ResourceLocation(Reference.MODID, "block_bubbleshroom_gray"), new ResourceLocation(Reference.MODID, "block_bubbleshroom_blue"), new ResourceLocation(Reference.MODID, "block_bubbleshroom_green"), new ResourceLocation(Reference.MODID, "block_bubbleshroom_pink"));
		ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(ModBlocks.strangeGrass), stack -> new ModelResourceLocation(ModBlocks.strangeGrass.getRegistryName(), "inventory"));
		ModelBakery.registerItemVariants(Item.getItemFromBlock(ModBlocks.strangeGrass), ModBlocks.strangeGrass.getRegistryName());
	}

}
