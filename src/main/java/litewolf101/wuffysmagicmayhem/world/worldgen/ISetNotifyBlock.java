package litewolf101.wuffysmagicmayhem.world.worldgen;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Created by LiteWolf101 on 7/10/2018.
 */
public interface ISetNotifyBlock {
    void setBlockAndNotify(World world, BlockPos pos, IBlockState state);
}
