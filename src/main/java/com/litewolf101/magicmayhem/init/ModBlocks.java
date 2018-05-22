package com.litewolf101.magicmayhem.init;

import com.litewolf101.magicmayhem.block.*;
import com.litewolf101.magicmayhem.tile.TileEntityTotemUpgradeBase;
import de.kitsunealex.silverfish.util.RegistryUtils;
import net.minecraft.block.Block;

public class ModBlocks {

    public static Block LOG;
    public static Block PLANKS;
    public static Block GLOWING_PANDORA;
    public static Block LEAVES;
    public static Block TOTEM_UPGRADE_BASE;

    public static void registerBlocks() {
        LOG = RegistryUtils.registerBlock(BlockMMLog.class);
        PLANKS = RegistryUtils.registerBlock(BlockMMPlanks.class);
        GLOWING_PANDORA = RegistryUtils.registerBlock(BlockGlowingPandora.class);
        LEAVES = RegistryUtils.registerBlock(BlockMMLeaves.class);
        TOTEM_UPGRADE_BASE = RegistryUtils.registerBlock(BlockTotemUpgradeBase.class);
    }

    public static void registerTileEntities() {
        RegistryUtils.registerTileEntity(TileEntityTotemUpgradeBase.class, "totem_upgrade_base");
    }

}
