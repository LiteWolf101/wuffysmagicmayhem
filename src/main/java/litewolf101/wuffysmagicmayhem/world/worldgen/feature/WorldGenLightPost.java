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
public class WorldGenLightPost extends WorldGenerator{
    IBlockState post = Blocks.OAK_FENCE.getDefaultState();
    IBlockState light = Blocks.GLOWSTONE.getDefaultState();
    private int minPostHeight = 3;

    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position) {
        int randHeight = rand.nextInt(3);
        int postHeight = minPostHeight + randHeight;
        Material materialBelow = worldIn.getBlockState(position.down()).getMaterial();
        if (position.getY() <= 13 && position.getY() + postHeight + 1 >= worldIn.getHeight() || materialBelow != Material.GRASS && materialBelow != Material.GROUND) {
            return false;
        }

        generatePost(worldIn, position, postHeight);
        return true;
    }

    private void generatePost(World world, BlockPos pos, int postHeight){
        for (int dy = 0; dy < postHeight; dy++){
            this.setBlockAndNotifyAdequately(world, pos.add(0, dy, 0), post);
        }
        this.setBlockAndNotifyAdequately(world, pos.up(postHeight), light);
    }
}
