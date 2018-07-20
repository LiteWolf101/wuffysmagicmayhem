package litewolf101.wuffysmagicmayhem.world.biomes;

import litewolf101.wuffysmagicmayhem.init.BlocksInit;
import litewolf101.wuffysmagicmayhem.utils.Reference;
import litewolf101.wuffysmagicmayhem.utils.handlers.EnumWoodHandler;
import litewolf101.wuffysmagicmayhem.world.worldgen.trees.WorldGenDarkenedTree;
import net.minecraft.block.BlockSand;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
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
public class BiomeDarkened extends Biome {
    private static BiomeProperties properties = new BiomeProperties("Darkened Forest");
    protected static final NoiseGeneratorPerlin DARK_COLOR_NOISE = new NoiseGeneratorPerlin(new Random(1176L), 1);
    public BiomeDarkened() {
        super(properties);
        this.setRegistryName(new ResourceLocation(Reference.MODID, "biome_darkened"));
        decorator.treesPerChunk = 4;
        decorator.flowersPerChunk = 1;
        properties.setTemperature(0.5F);
        properties.setHeightVariation(0.0F);
        decorator.sandPatchesPerChunk = 0;
        decorator.grassPerChunk = 10;

        spawnableMonsterList.clear();
        spawnableMonsterList.add(new SpawnListEntry(EntityZombie.class, 7, 1, 3));
        spawnableMonsterList.add(new SpawnListEntry(EntityCreeper.class, 4, 2, 3));
        spawnableMonsterList.add(new SpawnListEntry(EntitySkeleton.class, 10, 1, 4));
        spawnableMonsterList.add(new SpawnListEntry(EntityEnderman.class, 1, 1, 1));
        spawnableMonsterList.add(new SpawnListEntry(EntitySpider.class, 2, 1, 2));
        spawnableMonsterList.add(new SpawnListEntry(EntityWitch.class, 5, 1, 3));
        spawnableMonsterList.add(new SpawnListEntry(EntityMagmaCube.class, 4, 1, 1));
        //Add Darkened Knight

        spawnableCreatureList.clear();
        spawnableCreatureList.add(new SpawnListEntry(EntityPig.class, 3, 2, 5));
        spawnableCreatureList.add(new SpawnListEntry(EntitySheep.class, 5, 1, 4));
        spawnableCreatureList.add(new SpawnListEntry(EntityCow.class, 6, 3, 8));
        spawnableCreatureList.remove(new SpawnListEntry(EntityChicken.class, 1, 100, 100));
        //timer();
    }

    @Override
    public float getSpawningChance() {
        return 0.17F;
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
    public WorldGenAbstractTree getRandomTreeFeature(Random random) {
        if (random.nextInt(5) == 0) {
            return BIG_TREE_FEATURE;
        } else {
            return new WorldGenDarkenedTree(true);
        }
    }



    /**public static double xPos;

    public static void timer() {
        final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(BiomeDarkened::myTask, 0, 1, TimeUnit.SECONDS);
        if (Minecraft.getMinecraft().isGamePaused()){
            executorService.shutdown();
        }
    }

    public static void myTask() {

        double newX = (double) 0;
        try {
            for (xPos = 1; xPos <= 20; xPos++) {
                double piConstant = ((double)xPos / 20.0) * 3.14d;
                double y = 0.25 * Math.sin(piConstant / 0.5) + 0.5;
                newX = y;
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {}
        xPos = newX;
    }
     The methods above animates the top layer of grass dynamically. However, this was removed to massive fps tanking.*/

    @Override
    @SideOnly(Side.CLIENT)
    public int getGrassColorAtPos(BlockPos pos) {

        double d0 = DARK_COLOR_NOISE.getValue((double)pos.getX() * 0.0755D/**xPos*/, (double)pos.getZ() * 0.0755D);
        return d0 < -0.1D ? 2688093 : 2031677;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getFoliageColorAtPos(BlockPos pos) {
        return 6291645;
    }

    @Override
    public int getWaterColorMultiplier() {
        return 1;
    }

    @Override
    public int getSkyColorByTemp(float currentTemperature) {
        return 100;
    }

    @Override
    public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal) {
        this.generateBiomeDarkenedTerrain(worldIn, rand, chunkPrimerIn, x, z, noiseVal);
    }

    protected void generateBiomeDarkenedTerrain(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal)
    {

        int i = worldIn.getSeaLevel();
        IBlockState iblockstate = BlocksInit.GRASS.getDefaultState().withProperty(VARIANT, EnumWoodHandler.EnumType.DARKENED);
        IBlockState iblockstate1 = BlocksInit.DIRT.getDefaultState().withProperty(VARIANT, EnumWoodHandler.EnumType.DARKENED);
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
                            iblockstate = BlocksInit.GRASS.getDefaultState().withProperty(VARIANT, EnumWoodHandler.EnumType.DARKENED);
                            iblockstate1 = BlocksInit.DIRT.getDefaultState().withProperty(VARIANT, EnumWoodHandler.EnumType.DARKENED);
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
