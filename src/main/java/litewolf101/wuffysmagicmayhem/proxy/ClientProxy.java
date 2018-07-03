package litewolf101.wuffysmagicmayhem.proxy;

import litewolf101.wuffysmagicmayhem.Reference;
import litewolf101.wuffysmagicmayhem.WuffysMagicMayhem;
import litewolf101.wuffysmagicmayhem.client.fx.ParticleShimmeringGrass;
import litewolf101.wuffysmagicmayhem.client.fx.WMMParticleType;
import litewolf101.wuffysmagicmayhem.client.wmmgui.GUIHandler;
import litewolf101.wuffysmagicmayhem.handlers.ColorHandler;
import litewolf101.wuffysmagicmayhem.handlers.WMMSoundHandler;
import litewolf101.wuffysmagicmayhem.init.ModBlocks;
import litewolf101.wuffysmagicmayhem.init.ModEntities;
import litewolf101.wuffysmagicmayhem.init.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
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
		ModEntities.initModels();

	}

	@Override
	public void init(FMLInitializationEvent event) {
		WMMSoundHandler.init();
		ColorHandler.init();
		ColorHandler.registerExtraBlockColors();
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

	@Override
	public void spawnParticle(World world, WMMParticleType particletype, double x, double y, double z, double velX, double velY, double velZ) {
		Minecraft mc = Minecraft.getMinecraft();
		Entity entity = mc.getRenderViewEntity();

		if (entity != null && mc.effectRenderer != null) {
			int i = mc.gameSettings.particleSetting;

			if (i == 1 && world.rand.nextInt(3) == 0) {
				i = 2;
			}

			double d0 = entity.posX - x;
			double d1 = entity.posY - y;
			double d2 = entity.posZ - z;

			if (d0 * d0 + d1 * d1 + d2 * d2 <= 1024D && i <= 1) {
				Particle particle = null;

				switch (particletype) {
					case SHIMMERING_GRASS:
						particle = new ParticleShimmeringGrass(world, x, y, z, velX, velY, velZ);
						break;
				}

				if (particle != null) {
					mc.effectRenderer.addEffect(particle);
				}
			}
		}
	}
}
