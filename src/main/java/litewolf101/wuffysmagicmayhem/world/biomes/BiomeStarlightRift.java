package litewolf101.wuffysmagicmayhem.world.biomes;

import litewolf101.wuffysmagicmayhem.init.ModBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.chunk.ChunkPrimer;

import java.util.Random;

/**
 * Created by LiteWolf101 on 5/22/2018.
 */
public class BiomeStarlightRift extends Biome {

    //TODO: protected static final WorldGen[Tree Name]
    public BiomeStarlightRift(BiomeProperties properties) {
        super(properties);
    }

    @Override
    public void addFlower(IBlockState state, int weight) {
    }

    @Override
    public BiomeDecorator createBiomeDecorator() {
        return super.createBiomeDecorator();
    }

    @Override
    public void decorate(World worldIn, Random rand, BlockPos pos) {
        super.decorate(worldIn, rand, pos);
    }

    @Override
    public int getFoliageColorAtPos(BlockPos pos) {
        return super.getFoliageColorAtPos(pos);
    }

    @Override
    public int getGrassColorAtPos(BlockPos pos) {
        return super.getGrassColorAtPos(pos);
    }

    @Override
    public int getWaterColorMultiplier() {
        return super.getWaterColorMultiplier();
    }

    @Override
    public int getModdedBiomeGrassColor(int original) {
        return super.getModdedBiomeGrassColor(original);
    }

    @Override
    public BiomeDecorator getModdedBiomeDecorator(BiomeDecorator original) {
        return super.getModdedBiomeDecorator(original);
    }

    @Override
    public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal) {
        this.topBlock = Blocks.GRASS.getDefaultState();
        this.fillerBlock = Blocks.DIRT.getDefaultState();
        this.generateBiomeTerrain(worldIn, rand, chunkPrimerIn, x, z, noiseVal);
    }

    @Override
    public boolean canRain() {
        return false;
    }

    @Override
    public TempCategory getTempCategory() {
        return TempCategory.MEDIUM;
    }
}
