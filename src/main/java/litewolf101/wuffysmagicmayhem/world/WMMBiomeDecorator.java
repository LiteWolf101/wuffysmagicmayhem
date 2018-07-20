package litewolf101.wuffysmagicmayhem.world;

import litewolf101.wuffysmagicmayhem.world.worldgen.feature.WorldGenLightPost;
import litewolf101.wuffysmagicmayhem.world.worldgen.feature.WorldGenSmallRock;
import litewolf101.wuffysmagicmayhem.world.worldgen.trees.WorldGenStarlightTree;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.feature.WorldGenTallGrass;

import java.util.Random;

/**
 * Created by LiteWolf101 on 7/10/2018.
 */
public class WMMBiomeDecorator extends BiomeDecorator {
    private WorldGenSmallRock genSmallRock = new WorldGenSmallRock();
    private WorldGenStarlightTree genStarlightTree = new WorldGenStarlightTree(true);
    private WorldGenLightPost genLightPost = new WorldGenLightPost();
    private WorldGenTallGrass genTallGrass = new WorldGenTallGrass(BlockTallGrass.EnumType.GRASS);

    public int smallRocksPerChunk = 1;
    public int starlightTreesPerChunk = 5;
    public int lightPostsPerChunk = 1;
    public int tallGrassPerChunk = 4;

    @Override
    protected void genDecorations(Biome biome, World world, Random random) {
        for (int i = 0; i < smallRocksPerChunk; i++) {
            int rx = chunkPos.getX() + random.nextInt(16) + 8;
            int rz = chunkPos.getZ() + random.nextInt(16) + 8;
            genSmallRock.generate(world, random, world.getHeight(new BlockPos(rx, 0, rz)));
        }
        for (int i = 0; i < starlightTreesPerChunk; i++) {
            int rx = chunkPos.getX() + random.nextInt(16) + 8;
            int rz = chunkPos.getZ() + random.nextInt(16) + 8;
            genStarlightTree.generate(world, random, world.getHeight(new BlockPos(rx, 0, rz)));
        }
        for (int i = 0; i < lightPostsPerChunk; i++) {
            int rx = chunkPos.getX() + random.nextInt(24) + 8;
            int rz = chunkPos.getZ() + random.nextInt(24) + 8;
            genLightPost.generate(world, random, world.getHeight(new BlockPos(rx, 0, rz)));
        }
        for (int i = 0; i < tallGrassPerChunk; i++) {
            int rx = chunkPos.getX() + random.nextInt(16) + 8;
            int rz = chunkPos.getZ() + random.nextInt(16) + 8;
            genTallGrass.generate(world, random, world.getHeight(new BlockPos(rx, 0, rz)));
        }
    }

    public void setSmallRocksPerChunk(int smallRocksPerChunk){
        this.smallRocksPerChunk = smallRocksPerChunk;
    }

    public void setStarlightTreesPerChunk(int starlightTreesPerChunk){
        this.starlightTreesPerChunk = starlightTreesPerChunk;
    }

    public void setLightPostsPerChunk(int lightPostsPerChunk){
        this.lightPostsPerChunk = lightPostsPerChunk;
    }

    public void setTallGrassPerChunk(int tallGrassPerChunk){
        this.tallGrassPerChunk = tallGrassPerChunk;
    }

}
