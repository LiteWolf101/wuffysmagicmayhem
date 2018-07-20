package litewolf101.wuffysmagicmayhem.init;

import litewolf101.wuffysmagicmayhem.objects.blocks.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiteWolf101 on 7/6/2018.
 */
public class BlocksInit {
    public static final List<Block> BLOCKS = new ArrayList<Block>();

    public static final Block PLANKS = new BlockPlank("plank", Material.WOOD);
    public static final Block LOGS = new BlockLogs("log");
    public static final Block DIRT = new BlockDirts("dirt", Material.GROUND);
    public static final Block GRASS = new BlockGrasses("grass", Material.GRASS);
    public static final Block LEAVES = new BlockLeaf("leaves", Material.LEAVES);
    public static final Block GLOW_FLOWERS = new BlockBase("glow_flowers", Material.PLANTS);
    public static final Block STRANGE_GRASS = new BlockStrangeGrass("strange_grass", Material.PLANTS);
    public static final Block BUBBLESHROOM = new BlockBubbleshroom("bubbleshroom", Material.PLANTS);
    public static final Block SHIMMERING_GRASS = new BlockShimmeringGrass("shimmering_grass", Material.PLANTS);
    public static final Block DEVOURER = new BlockDevourer("devourer", Material.STRUCTURE_VOID);
    public static final Block TOTEM_UPGRADE_BASE = new BlockTotemUpgradeBase("totem_upgrade_base", Material.GLASS);
    public static final Block MAGIC_GEARBOX = new BlockMagicGearbox("magic_gearbox", Material.ROCK);
    public static final Block SAPLING = new BlockSaplings("sapling", Material.PLANTS);
    public static final Block TOTEM_TOP = new BlockTotemTop("totem_top", Material.ROCK);
}
