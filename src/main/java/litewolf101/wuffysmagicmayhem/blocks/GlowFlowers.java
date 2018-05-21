package litewolf101.wuffysmagicmayhem.blocks;

import net.minecraft.block.BlockBush;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

/**
 * Created by LiteWolf101 on 11/17/2017.
 */
public class GlowFlowers extends BlockBush {

    public GlowFlowers(String name, Material material) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        this.setSoundType(SoundType.PLANT);
        setLightLevel(0.5F);
    }

    @SuppressWarnings("deprecation")
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return super.getBoundingBox(state, source, pos).offset(state.getOffset(source, pos));
    }

    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    @Override
    public EnumOffsetType getOffsetType() {
        return EnumOffsetType.XZ;
    }
}


