package litewolf101.wuffysmagicmayhem.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import static net.minecraft.block.BlockLog.LOG_AXIS;

/**
 * Created by Ethan Migit on 11/17/2017.
 */
public class DarkInfusedWood extends BlockLog {

    public DarkInfusedWood(String name, Material material) {
        super();
        setUnlocalizedName(name);
        setRegistryName(name);
        setSoundType(SoundType.WOOD);
    }

    public IBlockState getStateFromMeta(int meta)
    {
        IBlockState iblockstate = this.getDefaultState();

        switch (meta & 4)
        {
            case 0:
                iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.Y);
                break;
            case 1:
                iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.X);
                break;
            case 2:
                iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.Z);
                break;
            case 3:
                iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.NONE);
        }

        return iblockstate;
    }

    public int getMetaFromState(IBlockState state)
    {
        int i = 0;

        switch ((BlockLog.EnumAxis)state.getValue(LOG_AXIS))
        {
            case X:
                i = i | 1;
                break;
            case Y:
                i = i | 0;
                break;
            case Z:
                i = i | 2;
                break;
            case NONE:
                i = i | 3;
        }

        return i;
    }


    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {LOG_AXIS});
    }

    @Override
    public boolean canSustainLeaves(IBlockState state, IBlockAccess world, BlockPos pos)
    {
        return true;
    }

    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        return this.getStateFromMeta(meta).withProperty(LOG_AXIS, BlockLog.EnumAxis.fromFacingAxis(facing.getAxis()));
    }
}