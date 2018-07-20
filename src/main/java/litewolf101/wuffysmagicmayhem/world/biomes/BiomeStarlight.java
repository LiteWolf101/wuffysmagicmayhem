package litewolf101.wuffysmagicmayhem.world.biomes;

import litewolf101.wuffysmagicmayhem.init.BlocksInit;
import litewolf101.wuffysmagicmayhem.objects.mobs.MobFloatingStar;
import litewolf101.wuffysmagicmayhem.utils.Reference;
import litewolf101.wuffysmagicmayhem.utils.handlers.EnumWoodHandler;
import litewolf101.wuffysmagicmayhem.world.WMMBiomeDecorator;
import litewolf101.wuffysmagicmayhem.world.worldgen.WMMGrassWorldGen;
import litewolf101.wuffysmagicmayhem.world.worldgen.trees.WorldGenStarlightTree;
import net.minecraft.block.BlockSand;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

import static litewolf101.wuffysmagicmayhem.objects.blocks.BlockGrasses.VARIANT;



/**
 * Created by LiteWolf101 on 6/16/2018.
 */
public class BiomeStarlight extends Biome {
    private static BiomeProperties properties = new Biome.BiomeProperties("Starlight Forest");
    private float heightVariation = 0.1F;
    public BiomeStarlight() {
        super(properties);
        this.setRegistryName(new ResourceLocation(Reference.MODID, "biome_starlight"));
        this.decorator.flowersPerChunk = 4;
        this.decorator.treesPerChunk = 4;
        properties.setTemperature(0.2F);
        this.heightVariation = heightVariation;
        this.getHeightVariation();
        getWMMBiomeDecor().setSmallRocksPerChunk(1);
        getWMMBiomeDecor().setStarlightTreesPerChunk(3);
        getWMMBiomeDecor().setLightPostsPerChunk(1);
        getWMMBiomeDecor().setTallGrassPerChunk(4);


        spawnableMonsterList.clear();
        spawnableMonsterList.add(new SpawnListEntry(EntityZombie.class, 7, 1, 3));
        spawnableMonsterList.add(new SpawnListEntry(EntityCreeper.class, 4, 2, 3));
        spawnableMonsterList.add(new SpawnListEntry(EntitySkeleton.class, 10, 1, 4));
        spawnableMonsterList.add(new SpawnListEntry(EntityEnderman.class, 1, 1, 1));
        spawnableMonsterList.add(new SpawnListEntry(EntitySpider.class, 2, 1, 2));
        //Add Darkened Knight

        spawnableCreatureList.clear();
        spawnableCreatureList.add(new SpawnListEntry(EntityPig.class, 3, 2, 5));
        spawnableCreatureList.add(new SpawnListEntry(EntitySheep.class, 5, 1, 4));
        spawnableCreatureList.add(new SpawnListEntry(EntityCow.class, 6, 3, 8));
        spawnableCreatureList.add(new SpawnListEntry(MobFloatingStar.class, 20, 1, 1));
    }

    @Override
    public float getSpawningChance() {
        return 0.11F;
    }

    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random random) {
        if (random.nextInt(10) == 0) {
            return TREE_FEATURE;
        } else {
            return new WorldGenStarlightTree(true);
        }
    }

    @Override
    public BiomeDecorator createBiomeDecorator() {
        return new WMMBiomeDecorator();
    }

    protected WMMBiomeDecorator getWMMBiomeDecor() {
        return (WMMBiomeDecorator) this.decorator;
    }

    @Override
    public WorldGenerator getRandomWorldGenForGrass(Random par1Random) {
        if (par1Random.nextInt(4) == 0) {
            return new WorldGenTallGrass(BlockTallGrass.EnumType.FERN);
        } else {
            return new WorldGenTallGrass(BlockTallGrass.EnumType.GRASS);
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getGrassColorAtPos(BlockPos pos) {
        return 589901;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getFoliageColorAtPos(BlockPos pos) {
        return 1573063;
    }

    @Override
    public int getWaterColorMultiplier() {
        return 589901;
    }

    @Override
    public int getSkyColorByTemp(float currentTemperature) {
        return 100;
    }

    @Override
    public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal) {
        this.generateBiomeStarlightTerrain(worldIn, rand, chunkPrimerIn, x, z, noiseVal);
    }

    @Override
    public void decorate(World worldIn, Random rand, BlockPos pos) {
        super.decorate(worldIn, rand, pos);

        WMMGrassWorldGen grass = new WMMGrassWorldGen(BlocksInit.SHIMMERING_GRASS.getDefaultState(), 1);
        WMMGrassWorldGen grass1 = new WMMGrassWorldGen(BlocksInit.STRANGE_GRASS.getDefaultState(), 2);
        BlockPos.MutableBlockPos mutPos = new BlockPos.MutableBlockPos(0, 0, 0);
        for (int i = 0; i < 20; i++) {
            int rx = pos.getX() + rand.nextInt(8) + 4;
            int ry = worldIn.getSeaLevel();
            int rz = pos.getZ() + rand.nextInt(8) + 4;
            mutPos.setPos(rx, ry, rz);
            grass.generate(worldIn, rand, mutPos);
            grass1.generate(worldIn, rand, mutPos);

        }
    }

    protected void generateBiomeStarlightTerrain(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal)
    {
        int i = worldIn.getSeaLevel();
        IBlockState iblockstate = BlocksInit.GRASS.getDefaultState().withProperty(VARIANT, EnumWoodHandler.EnumType.STARLIGHT);
        IBlockState iblockstate1 = BlocksInit.DIRT.getDefaultState().withProperty(VARIANT, EnumWoodHandler.EnumType.STARLIGHT);
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
                            iblockstate = BlocksInit.GRASS.getDefaultState().withProperty(VARIANT, EnumWoodHandler.EnumType.STARLIGHT);
                            iblockstate1 = BlocksInit.DIRT.getDefaultState().withProperty(VARIANT, EnumWoodHandler.EnumType.STARLIGHT);
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
