package litewolf101.wuffysmagicmayhem.world.biomes;

import litewolf101.wuffysmagicmayhem.init.BlocksInit;
import litewolf101.wuffysmagicmayhem.utils.Reference;
import litewolf101.wuffysmagicmayhem.utils.handlers.EnumWoodHandler;
import litewolf101.wuffysmagicmayhem.world.worldgen.trees.WorldGenAshenedTree;
import net.minecraft.block.BlockSand;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityHusk;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityWitherSkeleton;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

import static litewolf101.wuffysmagicmayhem.objects.blocks.BlockLogs.VARIANT;


/**
 * Created by LiteWolf101 on 6/16/2018.
 */
public class BiomeSmoldered extends Biome {
    private static BiomeProperties properties = new BiomeProperties("Smoldered Lands");
    public BiomeSmoldered() {
        super(properties);
        this.setRegistryName(new ResourceLocation(Reference.MODID, "biome_smoldered"));
        decorator.treesPerChunk = 1;
        decorator.reedsPerChunk = 0;
        decorator.flowersPerChunk = 0;
        properties.setTemperature(2.0F);
        properties.setHeightVariation(0.0F);
        properties.setRainDisabled();



        spawnableMonsterList.clear();
        spawnableMonsterList.add(new SpawnListEntry(EntityMagmaCube.class, 8, 1, 1));
        spawnableMonsterList.add(new SpawnListEntry(EntityBlaze.class, 3, 1, 1));
        spawnableMonsterList.add(new SpawnListEntry(EntityHusk.class, 8, 2, 5));
        spawnableMonsterList.add(new SpawnListEntry(EntityWitherSkeleton.class, 6, 2, 5));

        spawnableCreatureList.clear();
    }

    @Override
    public float getSpawningChance() {
        return 0.17F;
    }

    @Override
    public WorldGenerator getRandomWorldGenForGrass(Random par1Random) {
        if (par1Random.nextInt(2) == 0) {
            return new WorldGenTallGrass(BlockTallGrass.EnumType.DEAD_BUSH);
        } else {
            return new WorldGenTallGrass(BlockTallGrass.EnumType.GRASS);
        }
    }

    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random random) {
        return new WorldGenAshenedTree(true);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getGrassColorAtPos(BlockPos pos) {
        return 12105912;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getFoliageColorAtPos(BlockPos pos) {
        return 12105912;
    }

    @Override
    public int getWaterColorMultiplier() {
        return 16718362;
    }

    @Override
    public int getSkyColorByTemp(float currentTemperature) {
        return 100;
    }

    @Override
    public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal) {
        this.generateBiomeSmolderedTerrain(worldIn, rand, chunkPrimerIn, x, z, noiseVal);
    }

    protected void generateBiomeSmolderedTerrain(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal)
    {
        int i = worldIn.getSeaLevel();
        IBlockState iblockstate = BlocksInit.GRASS.getDefaultState().withProperty(VARIANT, EnumWoodHandler.EnumType.ASHENED);
        IBlockState iblockstate1 = BlocksInit.DIRT.getDefaultState().withProperty(VARIANT, EnumWoodHandler.EnumType.ASHENED);
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
                            iblockstate = BlocksInit.GRASS.getDefaultState().withProperty(VARIANT, EnumWoodHandler.EnumType.ASHENED);
                            iblockstate1 = BlocksInit.DIRT.getDefaultState().withProperty(VARIANT, EnumWoodHandler.EnumType.ASHENED);
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
