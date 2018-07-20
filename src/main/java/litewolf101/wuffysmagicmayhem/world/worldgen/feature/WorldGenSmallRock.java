package litewolf101.wuffysmagicmayhem.world.worldgen.feature;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

/**
 * Created by LiteWolf101 on 7/11/2018.
 */
public class WorldGenSmallRock extends WorldGenerator {
    IBlockState stone1 = Blocks.MOSSY_COBBLESTONE.getDefaultState();
    IBlockState stone2 = Blocks.COBBLESTONE.getDefaultState();

    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position) {
        Material materialBelow = worldIn.getBlockState(position.down()).getMaterial();
        if (position.getY() >= 80 && position.getY() <= 63 && materialBelow != Material.GRASS) {
            return false;
        }

        generateRock(worldIn, position);


        return true;
    }

    private void generateRock(World world, BlockPos pos){
        getRandomStone(world, pos.add(0, -1, 0));
        getRandomStone(world, pos.add(1, -1, 0));
        getRandomStone(world, pos.add(0, -1, -1));

        getRandomStone(world, pos.add(0, 0, 1));
        getRandomStone(world, pos.add(1, 0, 1));
        getRandomStone(world, pos.add(-1, 0, 0));
        getRandomStone(world, pos.add(0, 0, 0));
        getRandomStone(world, pos.add(1, 0, 0));
        getRandomStone(world, pos.add(2, 0, 0));
        getRandomStone(world, pos.add(-1, 0, -1));
        getRandomStone(world, pos.add(0, 0, -1));
        getRandomStone(world, pos.add(1, 0, -1));
        getRandomStone(world, pos.add(0, 0, -2));

        getRandomStone(world, pos.add(0, 1, 0));
        getRandomStone(world, pos.add(1, 1, 0));
        getRandomStone(world, pos.add(0, 1, -1));

        getRandomStone(world, pos.add(0, 2, 0));

    }

    private IBlockState getRandomStone(World world, BlockPos pos){
        Random random = new Random();
        IBlockState state = null;
        int rand = random.nextInt(10);
        if (rand <= 5){
            state = stone1;
        }
        if (rand > 5){
            state = stone2;
        }
        setBlockAndNotifyAdequately(world, pos, state);
        return state;
    }
}
