package litewolf101.wuffysmagicmayhem;

import litewolf101.wuffysmagicmayhem.init.ModBlocks;
import litewolf101.wuffysmagicmayhem.init.ModItems;
import litewolf101.wuffysmagicmayhem.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_MINECRAFT_VERSIONS)
public class WuffysMagicMayhem {

	@SidedProxy(clientSide = "litewolf101.wuffysmagicmayhem.proxy.ClientProxy", serverSide = "litewolf101.wuffysmagicmayhem.proxy.CommonProxy")
	public static CommonProxy proxy;

	@Mod.Instance
	public static WuffysMagicMayhem instance;

	public static CreativeTabs CREATIVE_TAB = new CreativeTabs(Reference.MODID) {

		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(ModItems.darkInfusedSapling);
		}
	};;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)

	{
		System.out.println(Reference.MODID + ":preInit");
		proxy.preInit(event);
		ModItems.init();
		ModBlocks.init();

	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		System.out.println(Reference.MODID + ":init");
		proxy.init(event);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		System.out.println(Reference.MODID + ":postInit");
		proxy.postInit(event);
	}
}
