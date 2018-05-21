package com.litewolf101.magicmayhem.init;

import com.litewolf101.magicmayhem.block.BlockGlowingPandora;
import de.kitsunealex.silverfish.util.RegistryUtils;
import net.minecraft.block.Block;

public class ModBlocks {

    public static Block GLOWING_PANDORA;

    public static void registerBlocks() {
        GLOWING_PANDORA = RegistryUtils.registerBlock(BlockGlowingPandora.class);
    }

    public static void registerTileEntities() {

    }

}
