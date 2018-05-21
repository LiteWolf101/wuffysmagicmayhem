package com.litewolf101.magicmayhem.proxy;

import com.litewolf101.magicmayhem.init.ModBlocks;
import com.litewolf101.magicmayhem.init.ModCrafting;
import com.litewolf101.magicmayhem.init.ModItems;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

    public void handlePreInit(FMLPreInitializationEvent event) {
        ModBlocks.registerBlocks();
        ModItems.registerItems();
    }

    public void handleInit(FMLInitializationEvent event) {
        ModBlocks.registerTileEntities();
        ModCrafting.registerRecipes();
    }

    public void handlePostInit(FMLPostInitializationEvent event) {

    }

}
