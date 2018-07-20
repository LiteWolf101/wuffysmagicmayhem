package litewolf101.wuffysmagicmayhem;

import litewolf101.wuffysmagicmayhem.commands.CommandWuffysMagicMayhem;
import litewolf101.wuffysmagicmayhem.init.ItemsInit;
import litewolf101.wuffysmagicmayhem.proxy.CommonProxy;
import litewolf101.wuffysmagicmayhem.utils.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;


@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_MINECRAFT_VERSIONS)
public class WuffysMagicMayhem {

	@Mod.Instance
	public static WuffysMagicMayhem instance;

	@SidedProxy(clientSide = "litewolf101.wuffysmagicmayhem.proxy.ClientProxy", serverSide = "litewolf101.wuffysmagicmayhem.proxy.CommonProxy")
	public static CommonProxy proxy;
	public static CreativeTabs CREATIVE_TAB = new CreativeTabs(Reference.MODID) {

		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(ItemsInit.MAGICAL_INSPECTOR);
		}
	};

	@EventHandler
	public static void preInit(FMLPreInitializationEvent event)
	{
		System.out.println(Reference.MODID + ":preInit");
		proxy.preInit(event);
		proxy.registerTileEntities();

	}

	@EventHandler
	public static void init(FMLInitializationEvent event) {
		System.out.println(Reference.MODID + ":init");
		proxy.init(event);
	}

	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {
		System.out.println(Reference.MODID + ":postInit");
		proxy.postInit(event);
	}

	@EventHandler
	public void serverLoad(FMLServerStartingEvent event) {
		event.registerServerCommand(new CommandWuffysMagicMayhem());
	}
}

//Tree Structures are found in the world named "Tree"
