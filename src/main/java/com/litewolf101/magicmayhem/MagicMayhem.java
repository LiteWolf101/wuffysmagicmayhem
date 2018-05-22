package com.litewolf101.magicmayhem;

import com.litewolf101.magicmayhem.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.Logger;

import static com.litewolf101.magicmayhem.util.Constants.*;

@Mod(modid = MODID, name = NAME, version = VERSION, useMetadata = true)
public class MagicMayhem {

	@Mod.Instance(MODID)
	public static MagicMayhem INSTANCE;
	@SidedProxy(clientSide = CSIDE, serverSide = SSIDE)
	public static CommonProxy PROXY;
	public static Logger LOGGER;

	public static CreativeTabs CREATIVE_TAB = new CreativeTabs("magicmayhem.name") {
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(Blocks.IRON_BLOCK, 1, 0);
		}
	};

	@Mod.EventHandler
	public void handlePreInit(FMLPreInitializationEvent event) {
		LOGGER = event.getModLog();
		PROXY.handlePreInit(event);
	}

	@Mod.EventHandler
	public void handleInit(FMLInitializationEvent event) {
		PROXY.handleInit(event);
	}

	@Mod.EventHandler
	public void handlePostInit(FMLPostInitializationEvent event) {
		PROXY.handlePostInit(event);
	}

}
