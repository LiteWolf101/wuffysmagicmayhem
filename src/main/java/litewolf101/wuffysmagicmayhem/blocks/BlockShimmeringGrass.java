package litewolf101.wuffysmagicmayhem.blocks;

import net.minecraft.block.BlockBush;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by LiteWolf101 on 6/27/2018.
 */
public class BlockShimmeringGrass extends BlockBush {
    public BlockShimmeringGrass(String name, Material material) {
        super();
        setRegistryName(name);
        setUnlocalizedName(name);
        setSoundType(SoundType.PLANT);
        this.setLightLevel(1F);
        setTickRandomly(true);
    }
    @Override
    public int tickRate(World worldIn) {
        return 5;
    }

    @Override
    public void updateTick(World world, BlockPos pos, IBlockState state, Random rand) {
        world.scheduleUpdate(pos, this, 5);
        randomDisplayTick(state, world, pos, rand);
    }

    @Override
    public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
        world.scheduleUpdate(pos, this, 5);
    }

    @Override
    public void randomDisplayTick(IBlockState stateIn, World world, BlockPos pos, Random rand) {
        double d0 = (double)pos.getX();
        double d1 = (double)pos.getY();
        double d2 = (double)pos.getZ();
        Random random = new Random();
        double randomX = random.nextInt(50);
        double randomY = random.nextInt(3);
        double randomZ = random.nextInt(50);
        world.spawnParticle(EnumParticleTypes.SPELL_WITCH, d0 + (randomX / 5) - 5, d1 + randomY, d2 + (randomZ / 5) - 5, 0.0D, 0.1D, 0.0D);
    }
}
