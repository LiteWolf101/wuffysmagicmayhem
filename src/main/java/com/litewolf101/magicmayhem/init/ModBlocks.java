package com.litewolf101.magicmayhem.init;

import com.litewolf101.magicmayhem.block.BlockGlowingPandora;
import com.litewolf101.magicmayhem.block.BlockMMLeaves;
import com.litewolf101.magicmayhem.block.BlockMMLog;
import com.litewolf101.magicmayhem.block.BlockMMPlanks;
import de.kitsunealex.silverfish.util.RegistryUtils;
import net.minecraft.block.Block;

public class ModBlocks {

    public static Block LOG;
    public static Block PLANKS;
    public static Block GLOWING_PANDORA;
    public static Block LEAVES;

    public static void registerBlocks() {
        LOG = RegistryUtils.registerBlock(BlockMMLog.class);
        PLANKS = RegistryUtils.registerBlock(BlockMMPlanks.class);
        GLOWING_PANDORA = RegistryUtils.registerBlock(BlockGlowingPandora.class);
        LEAVES = RegistryUtils.registerBlock(BlockMMLeaves.class);
    }

    public static void registerTileEntities() {

    }

}
