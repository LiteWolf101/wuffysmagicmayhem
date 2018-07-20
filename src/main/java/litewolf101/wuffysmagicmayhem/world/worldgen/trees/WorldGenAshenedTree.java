package litewolf101.wuffysmagicmayhem.world.worldgen.trees;

import litewolf101.wuffysmagicmayhem.init.BlocksInit;
import litewolf101.wuffysmagicmayhem.utils.handlers.EnumWoodHandler;
import net.minecraft.block.BlockLog;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

import static litewolf101.wuffysmagicmayhem.objects.blocks.BlockLogs.VARIANT;
import static net.minecraft.block.BlockLog.LOG_AXIS;

/**
 * Created by LiteWolf101 on 7/10/2018.
 */
public class WorldGenAshenedTree extends WorldGenAbstractTree {
    private int minTreeHeight;
    protected IBlockState log = BlocksInit.LOGS.getDefaultState();
    protected IBlockState leaves = BlocksInit.LEAVES.getDefaultState();

    public WorldGenAshenedTree(boolean notify) {
        this(notify, 7);
    }

    public WorldGenAshenedTree(boolean notify, int minTreeHeightIn) {
        super(notify);
        this.minTreeHeight = minTreeHeightIn;
        log = BlocksInit.LOGS.getDefaultState().withProperty(VARIANT, EnumWoodHandler.EnumType.ASHENED).withProperty(LOG_AXIS, BlockLog.EnumAxis.NONE);
        leaves = BlocksInit.LEAVES.getDefaultState().withProperty(VARIANT, EnumWoodHandler.EnumType.ASHENED);
    }

    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position) {
        int treeHeight = rand.nextInt(3) + minTreeHeight;
        int randBranchNum = rand.nextInt(1) + 2;
        Material materialBelow = worldIn.getBlockState(position.down()).getMaterial();

        if (position.getY() <= 13 && position.getY() + treeHeight + 1 >= worldIn.getHeight() || materialBelow != Material.GRASS && materialBelow != Material.GROUND) {
            return false;
        }
        for (int i = 0; i <= randBranchNum; i++){
            buildBranchAndLeaf(worldIn, position.add(0, treeHeight - i - 3, 0));
        }
        drawLeafCircle(worldIn, position.add(0, treeHeight - 1, 0), 1, leaves);
        drawLeafCircle(worldIn, position.add(0, treeHeight, 0), 2, leaves);
        drawLeafCircle(worldIn, position.add(0, treeHeight + 1, 0), 1, leaves);
        buildTrunk(worldIn, position, treeHeight);
        return true;
    }
    private void buildTrunk(World world, BlockPos pos, int treeHeight) {
        for (int dy = 0; dy < treeHeight; dy++){
            this.setBlockAndNotifyAdequately(world, pos.add(0, dy, 0), log);
        }
    }
    private void buildBranchAndLeaf(World world, BlockPos pos){
        //choose direction to build a branch in
        Random rand = new Random();
        int randDir = rand.nextInt(3);

        if (randDir == 0) {
            //north
            this.setBlockAndNotifyAdequately(world, pos.add(1, 0, 0), log);
            this.setBlockAndNotifyAdequately(world, pos.add(2, 0, 0), leaves);
        }
        if (randDir == 1) {
            //east
            this.setBlockAndNotifyAdequately(world, pos.add(0, 0, 1), log);
            this.setBlockAndNotifyAdequately(world, pos.add(0, 0, 2), leaves);
        }
        if (randDir == 2) {
            //south
            this.setBlockAndNotifyAdequately(world, pos.add(-1, 0, 0), log);
            this.setBlockAndNotifyAdequately(world, pos.add(-2, 0, 0), leaves);
        }
        if (randDir == 3) {
            //west
            this.setBlockAndNotifyAdequately(world, pos.add(0, 0, -1), log);
            this.setBlockAndNotifyAdequately(world, pos.add(0, 0, -2), leaves);
        }
    }
    private void drawLeafCircle(World world, BlockPos pos, int rad, IBlockState baseState) {
        for (byte dx = 0; dx <= rad; dx++) {
            for (byte dz = 0; dz <= rad; dz++) {
                int dist = (int)(Math.max(dx, dz) + (Math.min(dx, dz) * 0.5));
                if (dx == 3 && dz == 3) {
                    dist = 6;
                }
                if (dx == 0) {
                    // two!
                    if (dz < rad) {
                        setBlockAndNotifyAdequately(world, pos.add(0, 0, dz), baseState);
                        setBlockAndNotifyAdequately(world, pos.add(0, 0, -dz), baseState);
                    } else {
                        setBlockAndNotifyAdequately(world, pos.add(0, 0, dz), leaves);
                        setBlockAndNotifyAdequately(world, pos.add(0, 0, -dz), leaves);
                    }
                } else if (dz == 0) {
                    // two!
                    if (dx < rad) {
                        setBlockAndNotifyAdequately(world, pos.add(dx, 0, 0), baseState);
                        setBlockAndNotifyAdequately(world, pos.add(-dx, 0, 0), baseState);
                    } else {
                        setBlockAndNotifyAdequately(world, pos.add(dx, 0, 0), leaves);
                        setBlockAndNotifyAdequately(world, pos.add(-dx, 0, 0), leaves);
                    }
                } else if (dist < rad) {
                    // do four at a time for easiness!
                    setBlockAndNotifyAdequately(world, pos.add(dx, 0, dz), baseState);
                    setBlockAndNotifyAdequately(world, pos.add(dx, 0, -dz), baseState);
                    setBlockAndNotifyAdequately(world, pos.add(-dx, 0, dz), baseState);
                    setBlockAndNotifyAdequately(world, pos.add(-dx, 0, -dz), baseState);
                } else if (dist == rad) {
                    // do four at a time for easiness!
                    setBlockAndNotifyAdequately(world, pos.add(dx, 0, dz), leaves);
                    setBlockAndNotifyAdequately(world, pos.add(dx, 0, -dz), leaves);
                    setBlockAndNotifyAdequately(world, pos.add(-dx, 0, dz), leaves);
                    setBlockAndNotifyAdequately(world, pos.add(-dx, 0, -dz), leaves);
                }
            }
        }
    }
}
