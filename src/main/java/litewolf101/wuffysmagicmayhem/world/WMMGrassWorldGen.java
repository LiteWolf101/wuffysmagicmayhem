package litewolf101.wuffysmagicmayhem.world;

import net.minecraft.block.BlockBush;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

/**
 * Created by LiteWolf101 on 6/27/2018.
 */
public class WMMGrassWorldGen extends WorldGenerator{
    private final IBlockState state;
    private final int amount;

    public WMMGrassWorldGen(IBlockState state) {
        this(state, 1);
    }

    public WMMGrassWorldGen(IBlockState state, int amount) { // TF - Allow any blockstate, allow amount to be changed
        //WorldGenTallGrass use to use canBlockStay of Block, which was delegated to BlockBush.
        //It's sane to make sure that we pass BlockBush in via the constructor.
        if (!(state.getBlock() instanceof BlockBush)) {
            throw new RuntimeException("attempt to use WMMGrassWorldGen with a blockstate that isn't a BlockBush");
        }
        this.state = state;
        this.amount = amount;
    }

    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position) {
        do {
            IBlockState state = worldIn.getBlockState(position);
            if (!state.getBlock().isAir(state, worldIn, position) && !state.getBlock().isLeaves(state, worldIn, position))
                break;
            position = position.down();
        } while (position.getY() > 0);

        for (int i = 0; i < amount; ++i) // TF - 128 -> amount
        {
            BlockPos blockpos = position.add(rand.nextInt(16) - rand.nextInt(16), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(16) - rand.nextInt(16));

            // TF - use our own state
            if (worldIn.isAirBlock(blockpos) && ((BlockBush) state.getBlock()).canBlockStay(worldIn, blockpos, state)) {
                worldIn.setBlockState(blockpos, state, 2);
            }
        }

        return true;
    }

}
