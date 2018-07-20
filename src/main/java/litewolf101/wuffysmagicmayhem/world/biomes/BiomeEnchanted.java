package litewolf101.wuffysmagicmayhem.world.biomes;

import litewolf101.wuffysmagicmayhem.init.BlocksInit;
import litewolf101.wuffysmagicmayhem.utils.Reference;
import litewolf101.wuffysmagicmayhem.utils.handlers.EnumWoodHandler;
import litewolf101.wuffysmagicmayhem.world.worldgen.trees.WorldGenEnchantedTree;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityVindicator;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenMegaJungle;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

import static litewolf101.wuffysmagicmayhem.objects.blocks.BlockLogs.VARIANT;


/**
 * Created by LiteWolf101 on 6/16/2018.
 */
public class BiomeEnchanted extends Biome {
    private static final IBlockState JUNGLE_LOG = Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.JUNGLE);
    private static final IBlockState JUNGLE_LEAF = Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.JUNGLE).withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false));
    private static BiomeProperties properties = new BiomeProperties("Enchanted Woods");
    public BiomeEnchanted() {
        super(properties);
        this.setRegistryName(new ResourceLocation(Reference.MODID, "biome_enchanted"));
        decorator.treesPerChunk = 1;
        decorator.flowersPerChunk = 1;
        properties.setTemperature(1.2F);
        properties.setHeightVariation(0.0F);

        spawnableMonsterList.clear();
        spawnableMonsterList.add(new SpawnListEntry(EntityEnderman.class, 100, 1, 1));
        spawnableMonsterList.add(new SpawnListEntry(EntityWitch.class, 30, 2, 4));
        spawnableMonsterList.add(new SpawnListEntry(EntityVindicator.class, 100, 1, 1));


        spawnableCreatureList.clear();
        spawnableCreatureList.add(new SpawnListEntry(EntityPig.class, 3, 2, 5));
        spawnableCreatureList.add(new SpawnListEntry(EntitySheep.class, 5, 1, 4));
        spawnableCreatureList.add(new SpawnListEntry(EntityCow.class, 6, 3, 8));
    }

    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random random) {
        if (random.nextInt(5) == 0) {
            return new WorldGenMegaJungle(false, 12, 15, JUNGLE_LOG, JUNGLE_LEAF);
        } else {
            return new WorldGenEnchantedTree(true);
        }
    }

    @Override
    public float getSpawningChance() {
        return 0.14F;
    }

    @Override
    public WorldGenerator getRandomWorldGenForGrass(Random par1Random) {
        if (par1Random.nextInt(2) == 0) {
            return new WorldGenTallGrass(BlockTallGrass.EnumType.FERN);
        } else {
            return new WorldGenTallGrass(BlockTallGrass.EnumType.GRASS);
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getGrassColorAtPos(BlockPos pos) {
        return 2424756;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getFoliageColorAtPos(BlockPos pos) {
        return getGrassColorAtPos(pos);
    }

    @Override
    public int getWaterColorMultiplier() {
        return 1244664;
    }

    @Override
    public int getSkyColorByTemp(float currentTemperature) {
        return 24655;
    }

    @Override
    public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal) {
        this.generateBiomeEnchantedTerrain(worldIn, rand, chunkPrimerIn, x, z, noiseVal);
    }

    protected void generateBiomeEnchantedTerrain(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal)
    {
        int i = worldIn.getSeaLevel();
        IBlockState iblockstate = BlocksInit.GRASS.getDefaultState().withProperty(VARIANT, EnumWoodHandler.EnumType.ENCHANTED);
        IBlockState iblockstate1 = BlocksInit.DIRT.getDefaultState().withProperty(VARIANT, EnumWoodHandler.EnumType.ENCHANTED);
        int j = -1;
        int k = (int)(noiseVal / 3.0D + 3.0D + rand.nextDouble() * 0.25D);
        int l = x & 15;
        int i1 = z & 15;
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

        for (int j1 = 255; j1 >= 0; --j1)
        {
            if (j1 <= rand.nextInt(5))
            {
                chunkPrimerIn.setBlockState(i1, j1, l, BEDROCK);
            }
            else
            {
                IBlockState iblockstate2 = chunkPrimerIn.getBlockState(i1, j1, l);

                if (iblockstate2.getMaterial() == Material.AIR)
                {
                    j = -1;
                }
                else if (iblockstate2.getBlock() == Blocks.STONE)
                {
                    if (j == -1)
                    {
                        if (k <= 0)
                        {
                            iblockstate = AIR;
                            iblockstate1 = STONE;
                        }
                        else if (j1 >= i - 4 && j1 <= i + 1)
                        {
                            iblockstate = BlocksInit.GRASS.getDefaultState().withProperty(VARIANT, EnumWoodHandler.EnumType.ENCHANTED);
                            iblockstate1 = BlocksInit.DIRT.getDefaultState().withProperty(VARIANT, EnumWoodHandler.EnumType.ENCHANTED);
                        }

                        if (j1 < i && (iblockstate == null || iblockstate.getMaterial() == Material.AIR))
                        {
                            if (this.getFloatTemperature(blockpos$mutableblockpos.setPos(x, j1, z)) < 0.15F)
                            {
                                iblockstate = ICE;
                            }
                            else
                            {
                                iblockstate = WATER;
                            }
                        }

                        j = k;

                        if (j1 >= i - 1)
                        {
                            chunkPrimerIn.setBlockState(i1, j1, l, iblockstate);
                        }
                        else if (j1 < i - 7 - k)
                        {
                            iblockstate = AIR;
                            iblockstate1 = STONE;
                            chunkPrimerIn.setBlockState(i1, j1, l, GRAVEL);
                        }
                        else
                        {
                            chunkPrimerIn.setBlockState(i1, j1, l, iblockstate1);
                        }
                    }
                    else if (j > 0)
                    {
                        --j;
                        chunkPrimerIn.setBlockState(i1, j1, l, iblockstate1);

                        if (j == 0 && iblockstate1.getBlock() == Blocks.SAND && k > 1)
                        {
                            j = rand.nextInt(4) + Math.max(0, j1 - 63);
                            iblockstate1 = iblockstate1.getValue(BlockSand.VARIANT) == BlockSand.EnumType.RED_SAND ? RED_SANDSTONE : SANDSTONE;
                        }
                    }
                }
            }
        }
    }
}
