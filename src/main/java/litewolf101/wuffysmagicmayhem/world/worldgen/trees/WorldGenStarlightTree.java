package litewolf101.wuffysmagicmayhem.world.worldgen.trees;

import litewolf101.wuffysmagicmayhem.init.BlocksInit;
import litewolf101.wuffysmagicmayhem.utils.handlers.EnumWoodHandler;
import litewolf101.wuffysmagicmayhem.world.worldgen.ISetNotifyBlock;
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
public class WorldGenStarlightTree extends WorldGenAbstractTree implements ISetNotifyBlock{
    private int minTreeHeight;
    protected IBlockState log = BlocksInit.LOGS.getDefaultState();
    protected IBlockState leaves = BlocksInit.LEAVES.getDefaultState();


    public WorldGenStarlightTree(boolean notify){
        this(notify, 12);
    }

    public WorldGenStarlightTree(boolean notify, int minTreeHeightIn) {
        super(notify);
        this.minTreeHeight = minTreeHeightIn;
        log = BlocksInit.LOGS.getDefaultState().withProperty(VARIANT, EnumWoodHandler.EnumType.STARLIGHT).withProperty(LOG_AXIS, BlockLog.EnumAxis.NONE);
        leaves = BlocksInit.LEAVES.getDefaultState().withProperty(VARIANT, EnumWoodHandler.EnumType.STARLIGHT);

    }

    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position) {
        int treeHeight = rand.nextInt(8) + minTreeHeight;
        Material materialBelow = worldIn.getBlockState(position.down()).getMaterial();

        //Roll an intelligence check to see if we're on dirt, grass or at the right height
        if (position.getY() <= 13 && position.getY() + treeHeight + 1 >= worldIn.getHeight() || materialBelow != Material.GRASS && materialBelow != Material.GROUND) {
            return false;
        }
        buildTrunk(worldIn, position, treeHeight);
        createBranchLayers(worldIn, position, treeHeight);
        return true;
    }

    //Roll a strength saving throw to build the trunk
    private void buildTrunk(World world, BlockPos pos, int treeHeight) {
        for (int dy = 0; dy < treeHeight; dy++){
            this.setBlockAndNotifyAdequately(world, pos.add(0, dy, 0), log);
        }
    }

    //Roll a dexterity check to properly place branches
    private void createBranchLayers(World world, BlockPos pos, int treeHeight) {
        drawLeafCircle(world, pos.up(treeHeight - 3), 2, leaves);
        smallBranches(world, pos.up(treeHeight - 3));
        leaflette(world, pos.up(treeHeight - 2));
        drawLeafCircle(world, pos.up(treeHeight - 6), 3, leaves);
        mediumBranches(world, pos.up(treeHeight - 6));
        leaflette(world, pos.up(treeHeight - 5));
        drawLeafCircle(world, pos.up(treeHeight - 9), 4, leaves);
        largeBranches(world, pos.up(treeHeight - 9));
        leaflette(world, pos.up(treeHeight - 8));
        this.setBlockAndNotifyAdequately(world, pos.up(treeHeight), leaves);
    }

    private void smallBranches(World world, BlockPos pos) {
        Boolean airAtPos = world.isAirBlock(pos);
        if (airAtPos){this.setBlockAndNotifyAdequately(world, pos.north(), log);}
        if (airAtPos){this.setBlockAndNotifyAdequately(world, pos.east(), log);}
        if (airAtPos){this.setBlockAndNotifyAdequately(world, pos.south(), log);}
        if (airAtPos){this.setBlockAndNotifyAdequately(world, pos.west(), log);}
    }

    private void mediumBranches(World world, BlockPos pos) {
        Boolean airAtPos = world.isAirBlock(pos);
        for (int i = 1; i <= 2; i++){
            if (airAtPos){this.setBlockAndNotifyAdequately(world, pos.north(i), log);}
        }
        for (int i = 1; i <= 2; i++){
            if (airAtPos){this.setBlockAndNotifyAdequately(world, pos.east(i), log);}
        }
        for (int i = 1; i <= 2; i++){
            if (airAtPos){this.setBlockAndNotifyAdequately(world, pos.south(i), log);}
        }
        for (int i = 1; i <= 2; i++){
            if (airAtPos){this.setBlockAndNotifyAdequately(world, pos.west(i), log);}
        }
    }

    private void largeBranches(World world, BlockPos pos) {
        for (int i = 1; i <= 3; i++){
            this.setBlockAndNotifyAdequately(world, pos.north(i), log);
        }
        for (int i = 1; i <= 3; i++){
            this.setBlockAndNotifyAdequately(world, pos.east(i), log);
        }
        for (int i = 1; i <= 3; i++){
            this.setBlockAndNotifyAdequately(world, pos.south(i), log);
        }
        for (int i = 1; i <= 3; i++){
            this.setBlockAndNotifyAdequately(world, pos.west(i), log);
        }
    }

    private void leaflette(World world, BlockPos pos) {
        this.setBlockAndNotifyAdequately(world, pos.north(), leaves);
        this.setBlockAndNotifyAdequately(world, pos.east(), leaves);
        this.setBlockAndNotifyAdequately(world, pos.south(), leaves);
        this.setBlockAndNotifyAdequately(world, pos.west(), leaves);
    }

    //Credit to Twilight Forest
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

    @Override
    public void setBlockAndNotify(World world, BlockPos pos, IBlockState state) {
        setBlockAndNotifyAdequately(world, pos, state);
    }
}
